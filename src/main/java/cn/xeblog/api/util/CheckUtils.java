package cn.xeblog.api.util;

import cn.xeblog.api.constant.CommonConstant;
import cn.xeblog.api.service.AdminUserService;
import com.auth0.jwt.interfaces.Claim;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Map;

/**
 * 参数校验工具类
 *
 * @author yanpanyi
 * @date 2018/10/4
 */
@Component
public class CheckUtils {

    /**
     * 校验id
     *
     * @param id
     * @return
     */
    public static boolean checkId(Integer id) {
        return null == id || 1 > id;
    }

    /**
     * 校验登陆用户token合法性
     *
     * @param userId   登陆用户id
     * @param token    登陆用户token
     * @param nowToken 当前用户数据库中的token
     * @return
     * @throws Exception
     */
    public static boolean validateToken(String userId, String token, String nowToken) throws Exception {
        if (token == null || userId == null) {
            return false;
        }

        // 对比数据库token
        if (token.equals(nowToken)) {
            // 解析token
            Map<String, Claim> claim = JwtUtils.verifyToken(token);
            if (null != claim) {
                int jwtUserId = claim.get(CommonConstant.USER_ID).asInt();

                if (jwtUserId == Integer.parseInt(userId)) {
                    return true;
                }
            }
        }

        return false;
    }

}
