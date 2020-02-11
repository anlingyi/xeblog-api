package cn.xeblog.api.enums;


/**
 * 错误响应码
 *
 * @author yanpanyi
 */
public enum Code implements ErrorCode {

    /**
     * 不支持的图片类型
     */
    UNSUPPORTED_IMAGE_TYPE(1007, "不支持的图片类型！"),
    /**
     * 图片合成失败
     */
    IMAGE_SYNTHESIS_FAILED(1006, "图片合成失败！"),
    /**
     * 只能上传图片
     */
    CAN_ONLY_UPLOAD_IMAGES(1005, "只能上传图片！"),
    /**
     * 该分类下存在文章，删除失败
     */
    EXISTING_ARTICLE_FAILED_TO_DELETE(1004, "该分类下存在文章，删除失败！"),
    /**
     * 旧密码输入错误
     */
    OLD_PASSWORD_INPUT_ERROR(1003, "旧密码输入错误！"),
    /**
     * 用户名或密码错误
     */
    WRONG_USER_NAME_OR_PASSWORD(1002, "用户名或密码错误！"),
    /**
     * 标签已存在
     */
    TAG_ALREADY_EXISTS(1001, "标签已存在！"),
    /**
     * 处理成功
     */
    SUCCESS(200, "Success"),
    /**
     * 服务器内部错误
     */
    INTERNAL_SERVER_ERROR(500, "网络异常！"),
    /**
     * 参数验证失败
     */
    INVALID_PARAMETERS(501, "非法参数！"),
    /**
     * Token验证不通过
     */
    INVALID_TOKEN(502, "没有权限！"),
    /**
     * 处理失败
     */
    FAILED(503, "处理失败！");

    private int code;
    private String message;

    Code(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
