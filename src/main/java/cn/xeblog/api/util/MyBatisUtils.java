package cn.xeblog.api.util;

/**
 * @author anlingyi
 * @date 2020/3/17
 */
public class MyBatisUtils {

    /**
     * 检测返回值是否正确
     *
     * @param result
     * @return
     */
    public static boolean retBool(Integer result) {
        return null != result && result > 0;
    }

}
