package cn.xeblog.xeblogapi.controller.admin;

import cn.xeblog.xeblogapi.service.CategoryService;
import cn.xeblog.xeblogapi.util.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "分类列表")
    @GetMapping()
    public Response listCategory() throws Exception {
        return new Response(this.categoryService.listCategory());
    }

}
