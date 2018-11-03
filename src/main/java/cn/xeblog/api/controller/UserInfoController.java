package cn.xeblog.api.controller;

import cn.xeblog.api.service.AdminUserService;
import cn.xeblog.api.util.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 用户信息
 *
 * @author yanpanyi
 * @date 2018/10/3
 */
@Api(tags = "用户信息")
@RestController
@RequestMapping("/api/user_info")
public class UserInfoController {

    @Resource
    private AdminUserService adminUserService;

    /**
     * 获取用户信息
     *
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "获取用户信息")
    @GetMapping
    public Response getUserInfo() throws Exception {
        return new Response(this.adminUserService.getUserInfo());
    }
}
