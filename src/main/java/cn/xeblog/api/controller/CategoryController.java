package cn.xeblog.api.controller;

import cn.xeblog.api.service.CategoryService;
import cn.xeblog.api.util.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 分类
 *
 * @author yanpanyi
 * @date 2018/10/11
 */
@Api(tags = "分类")
@RestController
@RequestMapping("/api/categories")
public class CategoryController {

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
