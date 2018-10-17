package cn.xeblog.xeblogapi.controller.admin;

import cn.xeblog.xeblogapi.domain.request.Pagination;
import cn.xeblog.xeblogapi.enums.Code;
import cn.xeblog.xeblogapi.service.CategoryService;
import cn.xeblog.xeblogapi.util.CheckUtils;
import cn.xeblog.xeblogapi.util.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 分类cms端
 *
 * @author yanpanyi
 * @date 2018/10/16
 */
@Api(tags = "分类管理")
@RestController
@RequestMapping("/admin/api/categories")
public class AdminCategoryController {

    @Resource
    private CategoryService categoryService;

    /**
     * 获取分类列表
     *
     * @param pagination
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "分类列表")
    @GetMapping()
    public Response listCategory(Pagination pagination) throws Exception {
        return new Response(this.categoryService.listCategoryAdmin(pagination));
    }

    /**
     * 添加分类
     *
     * @param name
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "添加分类")
    @PostMapping
    public Response addCategory(String name) throws Exception {
        if (StringUtils.isEmpty(name)) {
            // 非法参数
            return new Response(Code.INVALID_PARAMETERS);
        }

        return this.categoryService.addCategory(name) ? new Response(Code.SUCCESS) :
                new Response(Code.FAILED);
    }

    /**
     * 删除分类
     *
     * @param id
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "删除分类")
    @DeleteMapping
    public Response deleteCategory(Integer id) throws Exception {
        if (CheckUtils.checkId(id)) {
            // 非法参数
            return new Response(Code.INVALID_PARAMETERS);
        }

        return this.categoryService.deleteCategoryById(id) ? new Response(Code.SUCCESS) :
                new Response(Code.FAILED);
    }

    /**
     * 修改分类
     *
     * @param id
     * @param name
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "修改分类")
    @PutMapping
    public Response updateCategory(Integer id, String name) throws Exception {
        if (CheckUtils.checkId(id) || StringUtils.isEmpty(name)) {
            // 非法参数
            return new Response(Code.INVALID_PARAMETERS);
        }

        return this.categoryService.updateCategoryById(id, name) ? new Response(Code.SUCCESS) :
                new Response(Code.FAILED);
    }

}
