package cn.xeblog.api.controller;

import cn.xeblog.api.enums.Code;
import cn.xeblog.api.util.ImageSynthesisUtils;
import cn.xeblog.api.util.Response;
import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.io.InputStream;

/**
 * 工具
 *
 * @author anlingyi
 * @date 2020/2/10
 */
@Api(tags = "工具")
@RestController
@RequestMapping("/api/tools")
public class ToolsController {

    private static final String ACCEPT_FILE_TYPE = "jpg,jpeg,png";

    /**
     * 图像合成
     *
     * @param file 待合成图片
     * @param systemType 系统类型 1.安卓 2.iPhone
     */
    @ApiOperation(value = "图像合成")
    @PostMapping("/imageSynthesis")
    public Response imageSynthesis(MultipartFile file, @RequestParam(defaultValue = "1") Integer systemType) {
        if (file == null || file.isEmpty()) {
            return new Response(Code.INVALID_PARAMETERS);
        }

        String fileName = file.getOriginalFilename();
        String fileType = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
        if (ACCEPT_FILE_TYPE.indexOf(fileType) == -1) {
            return new Response(Code.CAN_ONLY_UPLOAD_IMAGES);
        }

        try (InputStream inputStream = file.getInputStream()) {
            BASE64Encoder base64Encoder = new BASE64Encoder();
            String str = base64Encoder.encode(ImageSynthesisUtils.synthesis(inputStream, systemType));
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("image", str);
            return new Response(jsonObject);
        } catch (IOException e) {
            return new Response(Code.IMAGE_SYNTHESIS_FAILED);
        }
    }
}
