package cn.xeblog.xeblogapi.controller.admin;

import cn.xeblog.xeblogapi.domain.request.AddOrUpdateMenu;
import cn.xeblog.xeblogapi.enums.Code;
import cn.xeblog.xeblogapi.service.MenuService;
import cn.xeblog.xeblogapi.util.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 菜单cms端
 *
 * @author yanpanyi
 * @date 2018/10/3
 */
@Api(tags = "菜单管理")
@RestController
@RequestMapping("/admin/api/menu")
public class AdminMenuController {

    @Resource
    private MenuService menuService;

    /**
     * 添加菜单
     *
     * @param addOrUpdateMenu r
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "添加菜单")
    @PostMapping
    public Response addMenu(AddOrUpdateMenu addOrUpdateMenu) throws Exception {
        return this.menuService.addMenu(addOrUpdateMenu) ? new Response(Code.SUCCESS) :
                new Response(Code.FAILED);
    }

    /**
     * 修改菜单
     *
     * @param addOrUpdateMenu
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "修改菜单")
    @PutMapping
    public Response updateMenu(AddOrUpdateMenu addOrUpdateMenu) throws Exception {
        return this.menuService.updateMenu(addOrUpdateMenu) ? new Response(Code.SUCCESS) :
                new Response(Code.FAILED);
    }

    /**
     * 删除菜单
     *
     * @param id
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "删除菜单")
    @DeleteMapping
    public Response deleteMenu(Integer id) throws Exception {
        return this.menuService.deleteMenu(id) ? new Response(Code.SUCCESS) :
                new Response(Code.FAILED);
    }
}
