package cn.xeblog.api.util;

import net.coobird.thumbnailator.Thumbnails;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

/**
 * 图像合成
 *
 * @author anlingyi
 * @date 2020/2/10
 */
public class ImageSynthesisUtils {

    /**
     * 目录分隔符
     */
    private static final String SEPARATOR = File.separator;

    /**
     * 亮度[-1,1]
     */
    private static final double BRIGHTNESS = 0;
    /**
     * 对比度[-1,1]
     */
    private static final double CONTRAST = -0.5;

    /**
     * 横坐标
     */
    private static int x;
    /**
     * 纵坐标
     */
    private static int y;
    /**
     * 旋转角度
     */
    private static double rotate;
    /**
     * 缩放比例
     */
    private static double scale;


    /**
     * 初始化安卓参数
     */
    private static void initAndroidConfig() {
        x = 457;
        y = 295;
        rotate = 16;
        scale = 0.18;
    }

    /**
     * 初始化iPhone参数
     */
    private static void initIPhoneConfig() {
        x = 448;
        y = 285;
        rotate = 15;
        scale = 0.17;
    }

    /**
     * 图片合成
     *
     * @param inputStream 待合成的图片文件流
     * @param systemType 系统类型，1.安卓 2.iPhone
     * @throws IOException
     */
    public static byte[] synthesis(InputStream inputStream, int systemType) throws IOException {
        if (systemType == 2) {
            initIPhoneConfig();
        } else {
            initAndroidConfig();
        }

        // 模板图
        BufferedImage template = ImageIO.read(Thread.currentThread().getContextClassLoader().getResourceAsStream(SEPARATOR + "images" + SEPARATOR + "template.png"));
        // 待合成图
        BufferedImage image = ImageIO.read(inputStream);
        // 调整待合成图的亮度、对比度
        adjustBrightnessAndContrast(image);
        // 调整待合成图的尺寸和旋转角度
        image = Thumbnails.of(image).scale(scale).rotate(rotate).asBufferedImage();

        // 合成后的图
        BufferedImage result = new BufferedImage(template.getWidth(), template.getHeight(), template.getType());
        Graphics2D graphics2D = result.createGraphics();
        // 先画待合成图，后画模板图，这样就能将待合成图放置在模板图的下层
        graphics2D.drawImage(image, x, y, null);
        graphics2D.drawImage(template,0,0, null);
        graphics2D.dispose();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(1024 << 10);
        ImageIO.write(result, "png", outputStream);
        return outputStream.toByteArray();
    }

    /**
     * 调整亮度、对比度
     *
     * @param image
     */
    private static void adjustBrightnessAndContrast(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                Color color = new Color(image.getRGB(x, y));
                int red = calculateColor(color.getRed());
                int green = calculateColor(color.getGreen());
                int blue = calculateColor(color.getBlue());
                color = new Color(red, green, blue);
                image.setRGB(x, y, color.getRGB());
            }
        }
    }

    /**
     * 计算亮度、对比度颜色值
     *
     * @param color 原颜色值
     * @return 返回计算后的颜色值
     */
    private static int calculateColor(int color) {
        return getColor((int)((color - 127.5 * (1 - BRIGHTNESS)) * Math.tan((45 + 44 * CONTRAST) / 180 * Math.PI) + 127.5 * (1 + BRIGHTNESS)));
    }

    /**
     * 获取范围内的颜色值
     *
     * @param color
     * @return
     */
    private static int getColor(int color) {
        return color > 255 ? 255 : color < 0 ? 0 : color;
    }

}
