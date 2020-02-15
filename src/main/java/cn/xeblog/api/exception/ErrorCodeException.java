package cn.xeblog.api.exception;


import cn.xeblog.api.enums.ErrorCode;

/**
 * 响应错误码
 *
 * @author yanpanyi
 */
public class ErrorCodeException extends RuntimeException {

    private ErrorCode errorCode;

    public ErrorCodeException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }
}
