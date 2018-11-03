package cn.xeblog.api.controller.admin;

import cn.xeblog.api.enums.Code;
import cn.xeblog.api.service.AdminUserService;
import cn.xeblog.api.util.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 管理员登出
 *
 * @author yanpanyi
 * @date 2018/10/18
 */
@Api(tags = "管理员登出")
@RestController
@RequestMapping("/admin/api")
public class AdminLogoutController {

    @Resource
    private AdminUserService adminUserService;

    /**
     * 登出
     *
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "登出")
    @PutMapping("/logout")
    public Response logout() throws Exception {
        return this.adminUserService.updateToken("") ? new Response(Code.SUCCESS) :
                new Response(Code.FAILED);
    }
}
