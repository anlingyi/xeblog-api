package cn.xeblog.api.controller.admin;

import cn.xeblog.api.domain.request.AddOrUpdateMenu;
import cn.xeblog.api.domain.request.Pagination;
import cn.xeblog.api.enums.Code;
import cn.xeblog.api.service.MenuService;
import cn.xeblog.api.util.CheckUtils;
import cn.xeblog.api.util.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
     * @param addOrUpdateMenu
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
        if (CheckUtils.checkId(id)) {
            // 非法参数
            return new Response(Code.INVALID_PARAMETERS);
        }

        return this.menuService.deleteMenu(id) ? new Response(Code.SUCCESS) :
                new Response(Code.FAILED);
    }

    /**
     * 菜单列表
     *
     * @param pagination
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "获取菜单列表")
    @GetMapping
    public Response listMenu(Pagination pagination) throws Exception {
        return new Response(this.menuService.listMenuAdmin(pagination));
    }
}
