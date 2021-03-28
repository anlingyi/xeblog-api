package cn.xeblog.api.util;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author anlingyi
 * @date 2020/11/12
 */
@Slf4j
public class IPUtils {

    private final static String UNKNOWN = "unknown";

    private final static String LOCALHOST = "127.0.0.1,0:0:0:0:0:0:0:1";

    public static String getIp(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if (isEmpty(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (isEmpty(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (isEmpty(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (isEmpty(ip)) {
            ip = request.getHeader("X-Real-IP");
        }
        if (isEmpty(ip)) {
            ip = request.getRemoteAddr();

            log.info("RemoteAddr -> {}", ip);

            if (LOCALHOST.indexOf(ip) > -1) {
                try {
                    ip = InetAddress.getLocalHost().getHostAddress();
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                }
            }
        }

        log.info("IP -> {}", ip);

        if (!isEmpty(ip)) {
            int idx = ip.indexOf(",");
            if (idx > -1) {
                ip = ip.substring(0, idx);
            }
        }

        return ip;
    }

    public static boolean isEmpty(String ip) {
        return ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip);
    }

}
