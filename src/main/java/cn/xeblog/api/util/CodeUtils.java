package cn.xeblog.api.util;

import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * @author anlingyi
 * @date 2020/12/5 2:27 下午
 */
public class CodeUtils {

    private final static String DIGITS64 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789$.";
    private final static String DIGITS32 = "abcdefghijklmnopqrstuvwxyz246789";

    private final static long TIMESTAMP_MIN = 1601481600000L;
    private final static long TIMESTAMP_MAX = 9999999999999L;

    public static String generateCode() {
        return generateCode(System.currentTimeMillis());
    }

    public static String generateCode(long timestamp) {
        int random = RandomUtils.nextInt(0, 32);
        StringBuilder sb = new StringBuilder();
        sb.append(base64(timestamp))
                .append(DIGITS32.charAt(random))
                .append(getCheck(timestamp, random));
        return sb.toString();
    }

    public static int getCheck(long timestamp, int random) {
        return (int) ((timestamp - timestamp / 1000) * random % 10);
    }

    public static boolean checkCode(String code) {
        int len = StringUtils.length(code);
        if (len < 9 || len > 10) {
            return false;
        }

        long timestamp = base64ToDec(code.substring(0, len - 2));
        if (timestamp < TIMESTAMP_MIN || timestamp > TIMESTAMP_MAX) {
            return false;
        }

        int rdm = DIGITS32.indexOf(code.charAt(len - 2));
        if (rdm < 0) {
            return false;
        }

        return getCheck(timestamp, rdm) == Character.getNumericValue(code.charAt(len - 1));
    }

    public static String base64(long lng) {
        StringBuilder sb = new StringBuilder();
        do {
            sb.append(DIGITS64.charAt((int) (lng & 63)));
            lng >>>= 6;
        } while (lng > 0);
        return sb.reverse().toString();
    }

    public static long base64ToDec(String str) {
        long val = 0;
        int len = str.length();
        for (int i = 0; i < len; i++) {
            val += (long) DIGITS64.indexOf(str.charAt(len - i - 1)) << 6 * i;
        }
        return val;
    }

}
