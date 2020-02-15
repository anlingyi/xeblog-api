package cn.xeblog.api.constant;

/**
 * 常量类
 *
 * @author yanpanyi
 * @date 2018/10/3
 */
public class CommonConstant {

    /**
     * 用户id
     */
    public static final String USER_ID = "userId";
    /**
     * jwt过期时间，单位（天）
     */
    public static final int JWT_EXPIRE_DATE = 7;
    /**
     * token
     */
    public static final String TOKEN = "token";

    /**
     * email正则表达式
     */
    public static final String EMAIL_REGEX = "^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";

    /**
     * 验证码长度
     */
    public static final int VERIFY_CODE_LENGTH = 6;

    /**
     * 验证码有效期，30分钟
     */
    public static final long VERIFICATION_CODE_EXPIRATION_TIME = 30 * 60 * 1000;

    /**
     * 发送验证码间隔时间，60s
     */
    public static final long SEND_VERIFICATION_CODE_INTERVAL_TIME = 60 * 1000;
}
