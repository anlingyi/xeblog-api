package cn.xeblog.xeblogapi.controller.admin;

import cn.xeblog.xeblogapi.domain.request.UpdateUserInfo;
import cn.xeblog.xeblogapi.enums.Code;
import cn.xeblog.xeblogapi.service.AdminUserService;
import cn.xeblog.xeblogapi.util.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 用户信息cms
 *
 * @author yanpanyi
 * @date 2018/10/3
 */
@Api(tags = "用户信息管理")
@RestController
@RequestMapping("/admin/api/user_info")
public class AdminUserInfoController {

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
        return new Response(this.adminUserService.getUserInfoAdmin());
    }

    /**
     * 更新用户信息
     *
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "更新用户信息")
    @PutMapping
    public Response updateUserInfo(UpdateUserInfo updateUserInfo) throws Exception {
        return this.adminUserService.updateAdminUser(updateUserInfo) ? new Response(Code.SUCCESS) :
                new Response(Code.FAILED);
    }
}
