package cn.xeblog.xeblogapi.util;

/**
 * 参数校验工具类
 *
 * @author yanpanyi
 * @date 2018/10/4
 */
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

}
