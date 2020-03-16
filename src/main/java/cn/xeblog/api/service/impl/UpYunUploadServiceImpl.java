package cn.xeblog.api.service.impl;

import cn.xeblog.api.domain.config.UpYunConfig;
import cn.xeblog.api.enums.Code;
import cn.xeblog.api.exception.ErrorCodeException;
import cn.xeblog.api.service.UploadService;
import cn.xeblog.api.util.RequestUtils;
import cn.xeblog.api.util.UUIDUtils;
import main.java.com.UpYun;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 又拍云上传
 *
 * @author yanpanyi
 * @date 2019/1/25
 */
@Service
@RequestScope
public class UpYunUploadServiceImpl implements UploadService {

    @Resource
    private UpYunConfig upYunConfig;

    private volatile static UpYun upYun;
    private List<MultipartFile> files;
    private Map<String, String> map;
    /**
     * 文件名
     */
    private String fileName;
    /**
     * 文件类型
     */
    private String type;
    /**
     * 返回路径
     */
    private String respPath;
    private byte[] bytes;
    private MultipartFile multipartFile;

    private void init(HttpServletRequest request) {
        files = RequestUtils.getFiles(request);
        map = new HashMap<>(files.size());

        if (null == upYun) {
            upYun = new UpYun(upYunConfig.getBucketName(), upYunConfig.getUserName(), upYunConfig.getPassword());
        }
    }

    private void getValues() {
        type = multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().
                lastIndexOf("."));
        fileName = UUIDUtils.createUUID() + type;
        respPath = upYunConfig.getAccessAddress() + fileName;
    }

    private boolean execute() {
        return upYun.writeFile(upYunConfig.getUploadPath() + fileName, bytes, true);
    }

    private void add() {
        map.put(multipartFile.getName(), respPath);
    }

    @Override
    public Map<String, String> upload(HttpServletRequest request) throws Exception {
        init(request);

        for (int i = 0; i < files.size(); i++) {
            multipartFile = files.get(i);

            if (multipartFile.isEmpty()) {
                continue;
            }

            bytes = multipartFile.getBytes();
            getValues();

            if (!execute()) {
                throw new ErrorCodeException(Code.FAILED);
            }

            add();
        }

        return map;
    }

    @Override
    public Map<String, String> uploadImageWithWatermark(HttpServletRequest request) throws Exception {
        init(request);

        for (int i = 0; i < files.size(); i++) {
            multipartFile = files.get(i);

            if (multipartFile.isEmpty()) {
                continue;
            }

            getWatermarkImageBytes();

            if (!execute()) {
                throw new ErrorCodeException(Code.FAILED);
            }

            add();
        }

        return map;
    }

    private void getWatermarkImageBytes() throws ErrorCodeException, IOException {
        BufferedImage bufferedImage = ImageIO.read(multipartFile.getInputStream());
        if (null == bufferedImage) {
            // 上传的文件不是图片
            throw new ErrorCodeException(Code.CAN_ONLY_UPLOAD_IMAGES);
        }

        BufferedImage watermarkImage = Thumbnails.of(bufferedImage)
                .size(bufferedImage.getWidth(), bufferedImage.getHeight())
                .watermark(Positions.BOTTOM_RIGHT, ImageIO.read(this.getClass()
                        .getResourceAsStream("/watermark.png")), 0.25f)
                .asBufferedImage();

        getValues();

        // 将BufferedImage转换成byte[]
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ImageIO.write(watermarkImage, type.replace(".", ""), byteArrayOutputStream);
        bytes = byteArrayOutputStream.toByteArray();
    }
}
