package cn.xeblog.api.service.impl;

import cn.xeblog.api.domain.config.FileConfig;
import cn.xeblog.api.enums.Code;
import cn.xeblog.api.exception.ErrorCodeException;
import cn.xeblog.api.service.UploadService;
import cn.xeblog.api.util.RequestUtils;
import cn.xeblog.api.util.UUIDUtils;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 默认文件上传实现
 * @author yanpanyi
 * @date 2018/11/12
 */
@Service
@RequestScope
public class DefaultUploadServiceImpl implements UploadService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultUploadServiceImpl.class);

    @Resource
    private FileConfig fileConfig;

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
    private MultipartFile multipartFile;

    private void init(HttpServletRequest request) {
        files = RequestUtils.getFiles(request);
        map = new HashMap<>(files.size());
    }

    private File getFile() {
        type = multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().
                lastIndexOf("."));
        fileName = UUIDUtils.createUUID() + type;
        respPath = fileConfig.getAccessAddress() + fileName;

        File file = new File(fileConfig.getDirectoryMapping().replace("file:", "") +
                fileConfig.getUploadPath() + fileName);
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }

        return file;
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

            multipartFile.transferTo(getFile());
            add();
        }

        return map;
    }

    @Override
    public Map<String, String> uploadImageWithWatermark(HttpServletRequest request) throws Exception {
        init(request);
        BufferedImage bufferedImage;

        for (int i = 0; i < files.size(); i++) {
            multipartFile = files.get(i);

            if (multipartFile.isEmpty()) {
                continue;
            }

            bufferedImage = ImageIO.read(multipartFile.getInputStream());
            if (null == bufferedImage) {
                // 上传的文件不是图片
                throw new ErrorCodeException(Code.CAN_ONLY_UPLOAD_IMAGES);
            }

            Thumbnails.of(bufferedImage)
                    .size(bufferedImage.getWidth(), bufferedImage.getHeight())
                    .watermark(Positions.BOTTOM_RIGHT,
                            ImageIO.read(this.getClass().getResourceAsStream("/watermark.png")), 0.25f)
                    .toFile(getFile());

            add();
        }

        return map;
    }
}
