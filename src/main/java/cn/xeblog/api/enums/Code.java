package cn.xeblog.api.enums;


/**
 * 错误响应码
 *
 * @author yanpanyi
 */
public enum Code implements ErrorCode {

    /**
     * 上传的文件太大
     */
    UPLOADED_FILE_IS_TOO_LARGE(1018, "上传的文件太大了！"),
    /**
     * 没有订阅用户需要推送
     */
    NO_SUBSCRIBER_NEED_TO_PUSH(1017, "没有订阅用户需要推送！"),
    /**
     * 文章未公开
     */
    ARTICLE_NOT_PUBLIC(1016, "文章未公开！"),
    /**
     * 文章不存在
     */
    ARTICLE_DOES_NOT_EXIST(1015, "文章不存在！"),
    /**
     * 操作频繁
     */
    FREQUENT_OPERATIONS(1014, "操作频繁！"),
    /**
     * 验证码已过期
     */
    VERIFICATION_CODE_HAS_EXPIRED(1013, "验证码已过期！"),
    /**
     * 验证码不正确
     */
    INCORRECT_VERIFICATION_CODE(1012, "验证码不正确！"),
    /**
     * 请发送验证邮件
     */
    PLEASE_SEND_VERIFICATION_EMAIL(1011, "请发送验证邮件！"),
    /**
     * 邮箱不合法
     */
    EMAIL_IS_INVALID(1010, "邮箱不合法！"),
    /**
     * 该邮箱已订阅
     */
    THIS_EMAIL_IS_SUBSCRIBED(1009, "该邮箱已订阅！"),
    /**
     * 邮件发送失败
     */
    MAIL_SEND_FAILED(1008, "邮件发送失败！"),
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
