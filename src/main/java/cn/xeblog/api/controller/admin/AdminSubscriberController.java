package cn.xeblog.api.controller.admin;

import cn.xeblog.api.domain.request.Pagination;
import cn.xeblog.api.service.SubscriberService;
import cn.xeblog.api.util.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 订阅用户管理
 *
 * @author anlingyi
 * @date 2020/3/16
 */
@Api(tags = "订阅用户管理")
@RestController
@RequestMapping("/admin/api/subscriber")
public class AdminSubscriberController {

    @Resource
    private SubscriberService subscriberService;

    /**
     * 订阅用户列表
     *
     * @param pagination
     * @return
     */
    @ApiOperation(value = "订阅用户列表")
    @GetMapping
    public Response listSubscriber(Pagination pagination) {
        return Response.ok(subscriberService.listSubscriber(pagination));
    }
}
