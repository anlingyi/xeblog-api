package cn.xeblog.xeblogapi.util;

import cn.xeblog.xeblogapi.constant.CommonConstant;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * jwt token工具类
 *
 * @author yanpanyi
 * @date 2018/10/16
 */
public class JwtUtils {

    private final static Logger logger = LoggerFactory.getLogger(JwtUtils.class);

    /**
     * 生成token
     *
     * @param id
     * @return
     * @throws Exception
     */
    public static String createToken(int id) throws Exception {
        // 签发日期
        Date iatDate = new Date();
        // 过期时间一周
        Calendar nowTime = Calendar.getInstance();
        nowTime.add(Calendar.DATE, CommonConstant.JWT_EXPIRE_DATE);
        Date expireDate = nowTime.getTime();

        Map<String, Object> map = new HashMap<>(2);
        map.put("alg", "HS256");
        map.put("typ", "JWT");
        String token = JWT.create()
                .withHeader(map)
                .withClaim(CommonConstant.USER_ID, id)
                .withExpiresAt(expireDate)
                .withIssuedAt(iatDate)
                .sign(Algorithm.HMAC256(CommonConstant.JWT_PUBLIC_KEY));

        return token;
    }

    /**
     * 解密token
     *
     * @param token
     * @return
     * @throws Exception
     */
    public static Map<String, Claim> verifyToken(String token) throws Exception {
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(CommonConstant.JWT_PUBLIC_KEY))
                .build();
        DecodedJWT jwt;

        try {
            jwt = verifier.verify(token);
        } catch (Exception e) {
            logger.error("token解密失败或已过期！", e);
            return null;
        }

        return jwt.getClaims();
    }
}
