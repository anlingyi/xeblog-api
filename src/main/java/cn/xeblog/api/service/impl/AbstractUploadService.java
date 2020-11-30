package cn.xeblog.api.service.impl;

import cn.xeblog.api.enums.Code;
import cn.xeblog.api.exception.ErrorCodeException;
import cn.xeblog.api.service.UploadService;
import cn.xeblog.api.util.FileUtils;
import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
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

            list.add(uploadImage(multipartFile, watermarked));
        }

        return list;
    }

    protected InputStream getWatermarkAsStream() {
        return this.getClass().getResourceAsStream("/watermark.png");
    }

    protected Thumbnails.Builder buildWatermarkImage(MultipartFile multipartFile) {
        try (InputStream inputStream = multipartFile.getInputStream();
             InputStream watermarkInputStream = getWatermarkAsStream()) {
            BufferedImage bufferedImage = ImageIO.read(inputStream);
            if (null == bufferedImage) {
                // 上传的文件不是图片
                throw new ErrorCodeException(Code.CAN_ONLY_UPLOAD_IMAGES);
            }

            return Thumbnails.of(bufferedImage)
                    .size(bufferedImage.getWidth(), bufferedImage.getHeight())
                    .watermark(Positions.BOTTOM_RIGHT, ImageIO.read(watermarkInputStream), 0.25f);
        } catch (IOException e) {
            log.error("上传文件出现异常", e);
        }

        throw new ErrorCodeException(Code.FAILED);
    }

    protected boolean acceptWatermark(MultipartFile multipartFile) {
        return !"gif".equals(FileUtils.getFileType(multipartFile));
    }

}
