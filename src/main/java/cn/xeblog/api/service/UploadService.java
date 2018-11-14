package cn.xeblog.api.service;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 上传
 *
 * @author yanpanyi
 * @date 2018/11/12
 */
public interface UploadService {

    /**
     * 文件上传
     *
     * @param request
     * @return
     * @throws Exception
     */
    Map<String, String> upload(HttpServletRequest request) throws Exception;
}
