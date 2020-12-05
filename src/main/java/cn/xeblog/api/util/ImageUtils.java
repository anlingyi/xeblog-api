package cn.xeblog.api.util;

import cn.xeblog.api.constant.FileConstant;
import cn.xeblog.api.enums.Code;
import cn.xeblog.api.exception.ErrorCodeException;
import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author anlingyi
 * @date 2020/12/5 10:30 下午
 */
@Slf4j
public class ImageUtils {

    private static final float DEFAULT_OPACITY = 0.35f;

    private static BufferedImage WATERMARK_IMAGE;

    static {
        try (InputStream in = ImageUtils.class.getResourceAsStream(FileConstant.WATERMARK_FILE_URL)) {
            WATERMARK_IMAGE = ImageIO.read(in);
        } catch (Exception e) {
            log.error("水印图读取失败！", e);
        }
    }

    public static double calculateWatermarkScale(int width, int height) {
        int min = Math.min(width, height);
        double scale = min * 0.12 / 60;
        scale = scale > 2.5 ? 2.5 : scale;
        return scale;
    }

    public static boolean noWatermark(double scale) {
        return scale < 0.3;
    }

    public static Thumbnails.Builder watermarkWithThumbnailator(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();
        double scale = calculateWatermarkScale(width, height);
        Thumbnails.Builder builder = Thumbnails.of(image).size(width, height);
        if (noWatermark(scale)) {
            return builder;
        }

        try {
            return builder.watermark(Positions.BOTTOM_RIGHT,
                    Thumbnails.of(WATERMARK_IMAGE).scale(scale).asBufferedImage(), DEFAULT_OPACITY);
        } catch (IOException e) {
            log.error("图片添加水印失败！", e);
        }

        throw new ErrorCodeException(Code.FAILED);
    }

    public static BufferedImage watermark(BufferedImage image) {
        return watermark(image, DEFAULT_OPACITY);
    }

    public static BufferedImage watermark(BufferedImage image, float opacity) {
        int width = image.getWidth();
        int height = image.getHeight();
        double scale = calculateWatermarkScale(width, height);
        if (noWatermark(scale)) {
            return image;
        }

        BufferedImage watermarkImage = scale(WATERMARK_IMAGE, scale);
        BufferedImage result = new BufferedImage(width, height, image.getType());
        Graphics2D graphics2D = result.createGraphics();
        graphics2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        graphics2D.drawImage(image, 0, 0, null);
        graphics2D.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, opacity));
        graphics2D.drawImage(watermarkImage, width - watermarkImage.getWidth(), height - watermarkImage.getHeight(), null);
        graphics2D.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER));
        graphics2D.dispose();

        return result;
    }

    public static BufferedImage scale(BufferedImage image, double scale) {
        int originWidth = image.getWidth();
        int originHeight = image.getHeight();
        int width = (int) (scale * originWidth);
        int height = (int) (scale * originHeight);

        Image img = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        BufferedImage result = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D graphics = result.createGraphics();
        graphics.drawImage(img, 0, 0, null);
        graphics.dispose();

        return result;
    }

}
