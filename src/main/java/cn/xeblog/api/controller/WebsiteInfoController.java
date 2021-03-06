package cn.xeblog.api.controller;

import cn.xeblog.api.service.WebsiteInfoService;
import cn.xeblog.api.util.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 网站信息
 *
 * @author yanpanyi
 * @date 2018/10/3
 */
@Api(tags = "网站信息")
@RestController
@RequestMapping("/api/website_info")
public class WebsiteInfoController {

    @Resource
    private WebsiteInfoService websiteInfoService;

    /**
     * 获取网站信息
     *
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "获取网站信息")
    @GetMapping
    public Response getWebsiteInfo() throws Exception {
        return new Response(this.websiteInfoService.getWebsiteInfo());
    }

}
