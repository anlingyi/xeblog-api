package cn.xeblog.api.service.impl;

import cn.xeblog.api.domain.config.UpYunConfig;
import cn.xeblog.api.enums.Code;
import cn.xeblog.api.exception.ErrorCodeException;
import cn.xeblog.api.util.FileUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import main.java.com.UpYun;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * 又拍云上传
 *
 * @author yanpanyi
 * @date 2019/1/25
 */
@Service
@Slf4j
public class UpYunUploadServiceImpl extends AbstractUploadService implements CommandLineRunner {

    @Resource
    private UpYunConfig upYunConfig;

    private static UpYun upYun;

    @Override
    public void run(String... args) throws Exception {
        if (null == upYun) {
            upYun = new UpYun(upYunConfig.getBucketName(), upYunConfig.getUserName(), upYunConfig.getPassword());
        }
    }

    @Override
    public List<String> upload(MultipartFile[] files) {
        return execute(files, false);
    }

    @Override
    public List<String> uploadImageWithWatermark(MultipartFile[] files, boolean watermarked) {
        return execute(files, watermarked);
    }

    @Override
    public String uploadImage(MultipartFile file, boolean watermarked) {
        try {
            byte[] bytes = watermarked && !"gif".equals(FileUtils.getFileType(file)) ? getWatermarkImageBytes(file) : file.getBytes();
            FileInfo fileInfo = getFileInfo(file);

            if (!toUpYun(fileInfo.getFileName(), bytes)) {
                throw new ErrorCodeException(Code.FAILED);
            }

            return fileInfo.getFileUrl();
        } catch (IOException e) {
            log.error("上传文件出现异常", e);
            throw new ErrorCodeException(Code.FAILED);
        }
    }

    private FileInfo getFileInfo(MultipartFile multipartFile) {
        String fileName = createFileName(multipartFile);
        return new FileInfo(fileName, upYunConfig.getAccessAddress() + fileName);
    }

    private boolean toUpYun(String fileName, byte[] bytes) {
        return upYun.writeFile(upYunConfig.getUploadPath() + fileName, bytes, true);
    }

    private byte[] getWatermarkImageBytes(MultipartFile multipartFile) throws ErrorCodeException, IOException {
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

        // 将BufferedImage转换成byte[]
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ImageIO.write(watermarkImage, FileUtils.getFileType(multipartFile), byteArrayOutputStream);

        return byteArrayOutputStream.toByteArray();
    }

    @Data
    @AllArgsConstructor
    private static class FileInfo {
        private String fileName;
        private String fileUrl;
    }
}
