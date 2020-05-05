package cn.xeblog.api.controller.admin;

import cn.xeblog.api.enums.Code;
import cn.xeblog.api.exception.ErrorCodeException;
import cn.xeblog.api.service.UploadService;
import cn.xeblog.api.util.Response;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * 上传文件
 *
 * @author yanpanyi
 * @date 2018/11/12
 */
@RestController
@RequestMapping("/admin/api/upload")
public class UploadController {

    @Resource(name = "${default.upload.impl}")
    private UploadService uploadService;

    /**
     * 上传
     *
     * @param files
     * @return
     */
    @PostMapping
    public Response upload(MultipartFile[] files) {
        checkFile(files);

        return new Response(uploadService.upload(files));
    }

    /**
     * 上传图片带水印
     *
     * @param files
     * @param watermarked 是否带水印
     * @return
     */
    @PostMapping("/image")
    public Response uploadImageWithWatermark(MultipartFile[] files, @RequestParam(defaultValue = "true") boolean watermarked) {
        checkFile(files);

        return new Response(uploadService.uploadImageWithWatermark(files, watermarked));
    }

    private void checkFile(MultipartFile[] files) {
        if (files == null || files.length == 0) {
            throw new ErrorCodeException(Code.INVALID_PARAMETERS);
        }
    }
}
