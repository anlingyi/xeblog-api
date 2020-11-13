package cn.xeblog.api.controller;

import cn.xeblog.api.enums.Code;
import cn.xeblog.api.exception.ErrorCodeException;
import cn.xeblog.api.util.CheckUtils;
import cn.xeblog.api.util.ImageSynthesisUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
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

    private final static Logger LOGGER = LoggerFactory.getLogger(ToolsController.class);

    /**
     * 图像合成
     *
     * @param file 待合成图片
     * @param systemType 系统类型 1.安卓 2.iPhone
     * @param response HttpServletResponse
     */
    @ApiOperation(value = "图像合成")
    @PostMapping("/imageSynthesis")
    public void imageSynthesis(MultipartFile file, @RequestParam(defaultValue = "1") Integer systemType, HttpServletResponse response) {
        try {
            CheckUtils.checkImageFile(file);
        } catch (ErrorCodeException e) {
            response.setStatus(e.getErrorCode().getCode());
            return;
        }

        response.resetBuffer();
        response.setContentType("image/png");
        // 先设置图片合成失败的状态码
        response.setStatus(Code.IMAGE_SYNTHESIS_FAILED.getCode());

        try (InputStream inputStream = file.getInputStream();
             ServletOutputStream outputStream = response.getOutputStream()) {
            byte[] bytes = ImageSynthesisUtils.synthesis(inputStream, systemType);
            // 图片合成成功
            response.setStatus(Code.SUCCESS.getCode());
            outputStream.write(bytes);
        } catch (Exception e) {
            LOGGER.error("图片合成失败！", e);
        }
    }
}
