package cn.xeblog.api.util;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author yanpanyi
 */
public class RequestUtils {

    /**
     * 获取request中的file
     *
     * @param request
     * @return
     * @throws Exception
     */
    public static List<MultipartFile> getFiles(HttpServletRequest request) {
        List<MultipartFile> list = new ArrayList<>();

        //将当前上下文初始化给  CommonsMutipartResolver （多部分解析器）
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
                request.getSession().getServletContext());

        //检查form中是否有enctype="multipart/form-data"
        if (multipartResolver.isMultipart(request)) {
            //将request变成多部分request
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
            //获取multiRequest 中所有的文件名
            Iterator iter = multiRequest.getFileNames();

            while (iter.hasNext()) {
                //遍历所有文件
                MultipartFile file = multiRequest.getFile(iter.next().toString());

                if (null != file) {
                    list.add(file);
                }
            }
        }

        return list;
    }

}
