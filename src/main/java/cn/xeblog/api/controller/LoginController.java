package cn.xeblog.api.controller;

import cn.xeblog.api.enums.Code;
import cn.xeblog.api.service.LoginService;
import cn.xeblog.api.util.Response;
import io.swagger.annotations.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 登陆
 *
 * @author yanpanyi
 * @date 2018/10/17
 */
@Api(tags = "登陆")
@RestController
@RequestMapping("/api/login")
public class LoginController {

    @Resource
    private LoginService loginService;

    /**
     * 登陆
     *
     * @param username
     * @param password
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "登陆")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "query", dataType = "String", name = "username", value = "用户名",
            required = true), @ApiImplicitParam(paramType = "query", dataType = "String", name = "password",
            value = "密码", required = true)})
    @PostMapping
    public Response login(String username, String password) throws Exception {
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            // 非法参数
            return new Response(Code.INVALID_PARAMETERS);
        }

        // 登陆成功
        return new Response(this.loginService.login(username, password));
    }

}
