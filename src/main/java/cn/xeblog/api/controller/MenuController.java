package cn.xeblog.api.controller;

import cn.xeblog.api.service.MenuService;
import cn.xeblog.api.util.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 菜单
 *
 * @author yanpanyi
 * @date 2018/10/3
 */
@Api(tags = "菜单")
@RestController
@RequestMapping("/api/menu")
public class MenuController {

    @Resource
    private MenuService menuService;

    /**
     * 菜单列表
     *
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "获取菜单列表")
    @GetMapping
    public Response listMenu() throws Exception {
        return new Response(this.menuService.listMenu());
    }

}
