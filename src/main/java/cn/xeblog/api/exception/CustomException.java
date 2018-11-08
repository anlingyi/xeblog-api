package cn.xeblog.api.exception;


import cn.xeblog.api.enums.ErrorCode;

/**
 * 自定义异常
 *
 * @author yanpanyi
 */
public class CustomException extends Exception {

    private ErrorCode errorCode;

    public CustomException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }
}