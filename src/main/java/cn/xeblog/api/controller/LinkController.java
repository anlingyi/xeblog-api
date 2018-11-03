package cn.xeblog.api.controller;

import cn.xeblog.api.service.LinkService;
import cn.xeblog.api.util.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 链接
 *
 * @author yanpanyi
 * @date 2018/10/3
 */
@Api(tags = "链接")
@RestController
@RequestMapping("/api/links")
public class LinkController {

    @Resource
    private LinkService linkService;

    /**
     * 获取链接列表
     *
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "链接列表")
    @GetMapping()
    public Response listLink() throws Exception {
        return new Response(this.linkService.listLink());
    }
}
