package cn.xeblog.api.controller;

import cn.xeblog.api.constant.CommonConstant;
import cn.xeblog.api.domain.request.AddFootprint;
import cn.xeblog.api.enums.Code;
import cn.xeblog.api.service.FootprintService;
import cn.xeblog.api.util.CheckUtils;
import cn.xeblog.api.util.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
    public Response addFootprint(AddFootprint addFootprint, @RequestParam(value = "image", required = false) MultipartFile image) {
        if (!CheckUtils.checkLatitude(addFootprint.getLatitude()) || !CheckUtils.checkLongitude(addFootprint.getLongitude())
                || StringUtils.isBlank(addFootprint.getContent()) || addFootprint.getContent().length() > 100
                || StringUtils.isBlank(addFootprint.getAddress())
                || StringUtils.length(addFootprint.getNickname()) > 8
                || StringUtils.length(addFootprint.getTag()) > 6) {
            return Response.failed(Code.INVALID_PARAMETERS);
        }

        if (StringUtils.length(addFootprint.getAddress()) > 120) {
            addFootprint.setAddress(addFootprint.getAddress().substring(0, 120));
        }
        if (StringUtils.isBlank(addFootprint.getNickname())) {
            addFootprint.setNickname(CommonConstant.DEFAULT_NICKNAME);
        }
        if (image != null) {
            CheckUtils.checkImageFile(image);
            addFootprint.setImage(image);
        }

        return Response.what(footprintService.addFootprint(addFootprint));
    }

    @ApiOperation(value = "足迹列表")
    @GetMapping("/list")
    public Response listFootprint(Double longitude, Double latitude) {
        if (!CheckUtils.checkLatitude(latitude) || !CheckUtils.checkLongitude(longitude)) {
            return Response.failed(Code.INVALID_PARAMETERS);
        }

        return Response.ok(footprintService.getFootprintListInfo(longitude, latitude));
    }

}
