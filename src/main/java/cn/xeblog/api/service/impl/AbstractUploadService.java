package cn.xeblog.api.service.impl;

import cn.xeblog.api.enums.Code;
import cn.xeblog.api.exception.ErrorCodeException;
import cn.xeblog.api.service.UploadService;
import cn.xeblog.api.util.FileUtils;
import cn.xeblog.api.util.ImageUtils;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author anlingyi
 * @date 2020/11/13
 */
@Slf4j
public abstract class AbstractUploadService implements UploadService {

    protected List<String> execute(MultipartFile[] files, boolean watermarked) {
        List<String> list = new ArrayList<>(files.length);

        for (MultipartFile multipartFile : files) {
            if (multipartFile.isEmpty()) {
                continue;
            }

            list.add(upload(multipartFile, watermarked));
        }

        return list;
    }

    protected BufferedImage buildWatermarkImage(MultipartFile multipartFile) {
        try (InputStream inputStream = multipartFile.getInputStream()) {
            BufferedImage image = ImageIO.read(inputStream);
            if (null == image) {
                // 上传的文件不是图片
                throw new ErrorCodeException(Code.CAN_ONLY_UPLOAD_IMAGES);
            }

            return ImageUtils.watermark(image);
        } catch (IOException e) {
            log.error("上传文件出现异常", e);
        }

        throw new ErrorCodeException(Code.FAILED);
    }

    protected boolean acceptWatermark(String fileType) {
        return !"gif".equals(fileType);
    }

    protected FileInfo getFileInfo(MultipartFile multipartFile, String accessUrl) {
        String name = createFileName();
        return new FileInfo(accessUrl, name, FileUtils.getFileType(multipartFile));
    }

    protected abstract FileInfo getFileInfo(MultipartFile multipartFile);

    @Data
    protected static class FileInfo {
        private String url;
        private String name;
        private String type;
        private String fileName;

        public FileInfo(String url, String name, String type) {
            this.name = name;
            this.type = type;
            this.fileName = name + "." + type;
            this.url = url + this.fileName;
        }
    }

}
