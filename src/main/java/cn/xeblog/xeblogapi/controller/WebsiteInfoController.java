package cn.xeblog.xeblogapi.controller;

import cn.xeblog.xeblogapi.service.WebsiteInfoService;
import cn.xeblog.xeblogapi.util.Response;
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
    @GetMapping
    public Response getWebsiteInfo() throws Exception {
        return new Response(websiteInfoService.getWebsiteInfo());
    }

}
