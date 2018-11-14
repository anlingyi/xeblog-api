package cn.xeblog.api.controller.admin;

import cn.xeblog.api.service.UploadService;
import cn.xeblog.api.util.Response;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 上传文件
 *
 * @author yanpanyi
 * @date 2018/11/12
 */
@RestController
@RequestMapping("/admin/api/upload")
public class UploadController {

    @Resource
    private UploadService uploadService;

    /**
     * 上传
     *
     * @param request
     * @return
     * @throws Exception
     */
    @PostMapping
    public Response upload(HttpServletRequest request) throws Exception {
        return new Response(uploadService.upload(request));
    }

}
