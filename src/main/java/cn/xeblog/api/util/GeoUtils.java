package cn.xeblog.api.util;

/**
 * @author anlingyi
 * @date 2020/11/21 3:03 下午
 */
public class GeoUtils {

    /**
     * 地球半径（赤道，米）
     */
    private final static double EARTH_RADIUS = 6378137;

    /**
     * 根据经纬度计算两点距离
     *
     * @param longitude1
     * @param latitude1
     * @param longitude2
     * @param latitude2
     * @return 距离米
     */
    public static double getDistance(double longitude1, double latitude1, double longitude2, double latitude2) {
        double latR1 = Math.toRadians(latitude1);
        double latR2 = Math.toRadians(latitude2);
        double lngR1 = Math.toRadians(longitude1);
        double lngR2 = Math.toRadians(longitude2);
        double latD = latR1 - latR2;
        double lngD = lngR1 - lngR2;
        double distance = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(latD / 2), 2)
                + Math.cos(latR1) * Math.cos(latR2) * Math.pow(Math.sin(lngD / 2), 2)));
        return distance * EARTH_RADIUS;
    }

}
