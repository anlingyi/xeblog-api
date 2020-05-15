package cn.xeblog.api.interceptor;

import cn.xeblog.api.constant.CommonConstant;
import cn.xeblog.api.enums.Code;
import cn.xeblog.api.exception.ErrorCodeException;
import cn.xeblog.api.service.AdminUserService;
import cn.xeblog.api.util.CheckUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录拦截器
 *
 * @author yanpanyi
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Resource
    private AdminUserService adminUserService;

    private final static Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.debug("登陆拦截");
        String token = request.getHeader(CommonConstant.TOKEN);
        String uid = request.getHeader(CommonConstant.UID);

        logger.debug("token {}", token);
        logger.debug("uid {}", uid);

        if (CheckUtils.validateToken(uid, token, adminUserService.getToken())) {
            return true;
        }

        // token无效
        throw new ErrorCodeException(Code.INVALID_TOKEN);
    }
}
