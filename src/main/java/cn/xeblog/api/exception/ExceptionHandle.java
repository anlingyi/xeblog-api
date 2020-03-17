package cn.xeblog.api.exception;

import cn.xeblog.api.enums.Code;
import cn.xeblog.api.util.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author yanpanyi
 */
@ControllerAdvice
public class ExceptionHandle {
    private final static Logger LOGGER = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Response handle(Exception e) {
        LOGGER.error("error：", e);
        return new Response(Code.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = ErrorCodeException.class)
    @ResponseBody
    public Response invalidParameterErrorHandler(ErrorCodeException e) {
        LOGGER.error("error：", e);
        return new Response(e.getErrorCode());
    }


}
