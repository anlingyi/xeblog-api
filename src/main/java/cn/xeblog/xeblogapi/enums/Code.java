package cn.xeblog.xeblogapi.enums;


/**
 * response枚举类
 *
 * @author yanpanyi
 */
public enum Code implements ErrorCode {

    /**
     * 标签已存在
     */
    TAG_ALREADY_EXISTS(1001, "Tag Already Exists"),
    /**
     * 处理成功
     */
    SUCCESS(200, "Success"),
    /**
     * 服务器内部错误
     */
    INTERNAL_SERVER_ERROR(500, "Internal Server Error"),
    /**
     * 参数验证失败
     */
    INVALID_PARAMETERS(501, "Invalid Parameters"),
    /**
     * Token验证不通过
     */
    INVALID_TOKEN(502, "Invalid Token"),
    /**
     * 处理失败
     */
    FAILED(503, "Failed");

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
