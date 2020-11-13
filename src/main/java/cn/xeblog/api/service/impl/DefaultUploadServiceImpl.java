package cn.xeblog.api.service.impl;

import cn.xeblog.api.domain.config.FileConfig;
import cn.xeblog.api.enums.Code;
import cn.xeblog.api.exception.ErrorCodeException;
import cn.xeblog.api.util.FileUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.List;

/**
 * 默认文件上传实现
 *
 * @author yanpanyi
 * @date 2018/11/12
 */
@Service
@Slf4j
public class DefaultUploadServiceImpl extends AbstractUploadService {

    @Resource
    private FileConfig fileConfig;

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
        FileInfo fileInfo = getFileInfo(file);

        try (InputStream inputStream = file.getInputStream()) {
            if (watermarked && !"gif".equals(FileUtils.getFileType(file))) {
                BufferedImage bufferedImage = ImageIO.read(inputStream);

                if (null == bufferedImage) {
                    // 上传的文件不是图片
                    throw new ErrorCodeException(Code.CAN_ONLY_UPLOAD_IMAGES);
                }

                Thumbnails.of(bufferedImage)
                        .size(bufferedImage.getWidth(), bufferedImage.getHeight())
                        .watermark(Positions.BOTTOM_RIGHT,
                                ImageIO.read(this.getClass().getResourceAsStream("/watermark.png")), 0.25f)
                        .toFile(fileInfo.getFile());
            } else {
                file.transferTo(fileInfo.getFile());
            }

            return fileInfo.getFileUrl();
        } catch (IOException e) {
            log.error("上传文件出现异常", e);
            throw new ErrorCodeException(Code.FAILED);
        }
    }

    private FileInfo getFileInfo(MultipartFile multipartFile) {
        String fileName = createFileName(multipartFile);

        File file = new File(fileConfig.getDirectoryMapping().replace("file:", "") +
                fileConfig.getUploadPath() + fileName);
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }

        return new FileInfo(fileConfig.getAccessAddress() + fileName, file);
    }

    @Data
    @AllArgsConstructor
    private static class FileInfo {
        private String fileUrl;
        private File file;
    }
}
