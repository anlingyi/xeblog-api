package cn.xeblog.xeblogapi.controller.admin;

import cn.xeblog.xeblogapi.domain.request.UpdateUserInfo;
import cn.xeblog.xeblogapi.enums.Code;
import cn.xeblog.xeblogapi.service.AdminUserService;
import cn.xeblog.xeblogapi.util.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
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
     * @param updateUserInfo
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "更新用户信息")
    @PutMapping
    public Response updateUserInfo(UpdateUserInfo updateUserInfo) throws Exception {
        return this.adminUserService.updateAdminUser(updateUserInfo) ? new Response(Code.SUCCESS) :
                new Response(Code.FAILED);
    }

    /**
     * 更新用户名或密码
     *
     * @param username 新用户名
     * @param password 新密码
     * @return oldPassword 旧密码
     * @throws Exception
     */
    @ApiOperation(value = "更新用户名或密码")
    @PutMapping("/")
    public Response updateUsernameOrPassword(String username, String password, String oldPassword) throws Exception {
        if (StringUtils.isEmpty(username) && StringUtils.isEmpty(password)) {
            // 用户名和密码都为空不做任何修改
            return new Response(Code.FAILED);
        }

        if (StringUtils.isEmpty(oldPassword)) {
            // 非法参数
            return new Response(Code.INVALID_PARAMETERS);
        }

        if (!this.adminUserService.getPassword().equals(DigestUtils.md5Hex(oldPassword))) {
            // 旧密码错误
            return new Response(Code.OLD_PASSWORD_INPUT_ERROR);
        }

        if (!StringUtils.isEmpty(password)) {
            // 密码md5加密
            password = DigestUtils.md5Hex(password);
        }

        return this.adminUserService.updateUsernameOrPassword(username, password) ?
                new Response(Code.SUCCESS) : new Response(Code.FAILED);
    }

}
