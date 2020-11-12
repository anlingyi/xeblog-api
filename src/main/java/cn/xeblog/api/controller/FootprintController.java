package cn.xeblog.api.controller;

import cn.xeblog.api.domain.request.AddFootprint;
import cn.xeblog.api.service.FootprintService;
import cn.xeblog.api.util.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 足迹
 *
 * @author anlingyi
 * @date 2020/11/12
 */
@Api(tags = "足迹")
@RestController
@RequestMapping("/api/footprint")
public class FootprintController {

    @Resource
    private FootprintService footprintService;

    @ApiOperation(value = "添加足迹")
    @PostMapping()
    public Response addFootprint(@RequestBody AddFootprint addFootprint) {
        return Response.what(footprintService.addFootprint(addFootprint));
    }

}
