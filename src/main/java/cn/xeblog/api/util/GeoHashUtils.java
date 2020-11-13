package cn.xeblog.api.util;

/**
 * GeoHash
 *
 * @author anlingyi
 * @date 2020/11/12
 */
public class GeoHashUtils {

    private final static double LONGITUDE_MAX = 180d;
    private final static double LONGITUDE_MIN = -180d;
    private final static double LATITUDE_MAX = 90d;
    private final static double LATITUDE_MIN = -90d;
    private final static int LENGTH = 20;

    private final static char[] BASE32_CHARS = {
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'b', 'c', 'd', 'e', 'f', 'g',
            'h', 'j', 'k', 'm', 'n', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'
    };

    public static String getHash(double lng, double lat) {
        StringBuilder sb = new StringBuilder();

        double lngMax = LONGITUDE_MAX, lngMin = LONGITUDE_MIN;
        double latMax = LATITUDE_MAX, latMin = LATITUDE_MIN;
        double lngMid, latMid;
        for (int i = 0; i < LENGTH; i++) {
            lngMid = (lngMin + lngMax) / 2;
            if (lng > lngMid) {
                lngMin = lngMid;
                sb.append("1");
            } else {
                lngMax = lngMid;
                sb.append("0");
            }

            latMid = (latMin + latMax) / 2;
            if (lat > latMid) {
                latMin = latMid;
                sb.append("1");
            } else {
                latMax = latMid;
                sb.append("0");
            }
        }

        return base32Encode(sb.toString());
    }

    private static String base32Encode(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i = i + 5) {
            sb.append(BASE32_CHARS[Integer.parseInt(str.substring(i, i + 5), 2)]);
        }
        return sb.toString();
    }

}
