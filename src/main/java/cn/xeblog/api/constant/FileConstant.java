package cn.xeblog.api.constant;

/**
 * 文件相关常量类
 *
 * @author anlingyi
 * @date 2020/11/13
 */
public class FileConstant {

    /**
     * 支持的图片类型
     */
    public static final String ACCEPT_IMAGE_FILE_TYPE = "jpg,jpeg,png,gif";
    /**
     * 文件最大限制, 10M
     */
    public static final long FILE_MAX_SIZE = 10 << 20;

    /**
     * 水印图片地址
     */
    public static final String WATERMARK_FILE_URL = "/images/watermark.png";

    /**
     * 图片上传中
     */
    public static final String IMAGE_UPLOADING_URL = "https://oss.xeblog.cn/prod/uploading.png";
    /**
     * 图片上传失败
     */
    public static final String IMAGE_UPLOAD_FAIL_URL = "https://oss.xeblog.cn/prod/upload_fail.png";

}
