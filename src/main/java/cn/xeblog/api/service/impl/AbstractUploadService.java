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

            int width = bufferedImage.getWidth();
            int height = bufferedImage.getHeight();
            int max = Math.min(width, height);
            String conserved = "false";
            if (max >= 1800) {
                conserved = "true";
            }
            System.setProperty("thumbnailator.conserveMemoryWorkaround", conserved);
            Thumbnails.Builder builder = Thumbnails.of(bufferedImage)
                    .size(width, height);

            double scale = max * 0.12 / 60;
            if (scale >= 0.3) {
                scale = scale > 2.5 ? 2.5 : scale;
                builder.watermark(Positions.BOTTOM_RIGHT,
                        Thumbnails.of(watermarkInputStream).scale(scale).asBufferedImage(),
                        0.35f);
            }

            return builder;
        } catch (IOException e) {
            log.error("上传文件出现异常", e);
        }

        throw new ErrorCodeException(Code.FAILED);
    }

    protected boolean acceptWatermark(MultipartFile multipartFile) {
        return !"gif".equals(FileUtils.getFileType(multipartFile));
    }

}
