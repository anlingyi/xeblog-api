package cn.xeblog.api.util;

import java.util.UUID;

/**
 * uuid工具类
 *
 * @author yanpanyi
 */
public class UUIDUtils {

    /**
     * 生成uuid
     *
     * @return
     */
    public static String createUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
