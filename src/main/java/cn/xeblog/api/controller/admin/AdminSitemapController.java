package cn.xeblog.api.controller.admin;


import cn.xeblog.api.domain.request.UpdateSitemapConfig;
import cn.xeblog.api.service.SitemapService;
import cn.xeblog.api.util.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 站点地图(Sitemap)管理
 *
 * @author anlingyi
 * @since 2022-04-09 16:08:34
 */
@Api(tags = "站点地图管理")
@RestController
@RequestMapping("/admin/api/sitemap")
public class AdminSitemapController {

    @Resource
    private SitemapService sitemapService;

    @ApiOperation(value = "站点地图配置")
    @PostMapping("/config")
    public Response updateConfig(UpdateSitemapConfig updateSitemapConfig) {
        return Response.what(sitemapService.updateConfig(updateSitemapConfig));
    }

    @ApiOperation(value = "生成站点地图")
    @PostMapping("/generate")
    public Response generate() {
        return Response.what(sitemapService.generate());
    }

    @ApiOperation(value = "获取站点地图配置信息")
    @GetMapping()
    public Response getInfo() {
        return Response.ok(sitemapService.getSitemapConfig());
    }

}

