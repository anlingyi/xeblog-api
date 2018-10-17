package cn.xeblog.xeblogapi.enums;


/**
 * 错误响应码
 *
 * @author yanpanyi
 */
public enum Code implements ErrorCode {

    /**
     * 旧密码输入错误
     */
    OLD_PASSWORD_INPUT_ERROR(1003, "旧密码输入错误!"),
    /**
     * 用户名或密码错误
     */
    WRONG_USER_NAME_OR_PASSWORD(1002, "用户名或密码错误!"),
    /**
     * 标签已存在
     */
    TAG_ALREADY_EXISTS(1001, "标签已存在!"),
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
    FAILED(503, "处理失败");

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

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
