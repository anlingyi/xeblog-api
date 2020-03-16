package cn.xeblog.api.util;

import cn.xeblog.api.enums.ErrorCode;
import cn.xeblog.api.enums.Code;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.util.StringUtils;

/**
 * @author yanpanyi
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response {

    private int code;
    private Object data;
    private String message;

    /**
     * success response
     *
     * @param result
     */
    public Response(Object result) {
        this.code = Code.SUCCESS.getCode();
        this.message = Code.SUCCESS.getMessage();
        if (StringUtils.isEmpty(result)) {
            result = JSONObject.parse("{}");
        }
        this.data = result;
    }

    /**
     * error response
     *
     * @param resp
     */
    public Response(ErrorCode resp) {
        this.code = resp.getCode();
        this.message = resp.getMessage();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Response{" +
                "code=" + code +
                ", data=" + data +
                ", message='" + message + '\'' +
                '}';
    }

    public static Response ok() {
        return new Response(Code.SUCCESS);
    }

    public static Response failed() {
        return new Response(Code.FAILED);
    }

    public static Response failed(ErrorCode errorCode) {
        return new Response(errorCode);
    }

    public static Response what(boolean flag) {
        return flag ? ok() : failed();
    }

    public static Response ok(Object obj) {
        return new Response(obj);
    }
}