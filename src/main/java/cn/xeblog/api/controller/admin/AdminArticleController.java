package cn.xeblog.api.controller.admin;

import cn.xeblog.api.domain.request.AddOrUpdateArticle;
import cn.xeblog.api.domain.request.Pagination;
import cn.xeblog.api.domain.request.SetRecommend;
import cn.xeblog.api.enums.Code;
import cn.xeblog.api.service.ArticleService;
import cn.xeblog.api.util.CheckUtils;
import cn.xeblog.api.util.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 文章管理
 *
 * @author yanpanyi
 * @date 2018/10/3
 */
@Api(tags = "文章管理")
@RestController
@RequestMapping("/admin/api/articles")
public class AdminArticleController {

    @Resource
    private ArticleService articleService;

    /**
     * 添加文章
     *
     * @param addOrUpdateArticle
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "添加文章")
    @PostMapping
    public Response addArticle(AddOrUpdateArticle addOrUpdateArticle) throws Exception {
        return this.articleService.addArticle(addOrUpdateArticle) ? new Response(Code.SUCCESS) :
                new Response(Code.FAILED);
    }

    /**
     * 修改文章
     *
     * @param addOrUpdateArticle
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "修改文章")
    @PutMapping
    public Response updateArticle(AddOrUpdateArticle addOrUpdateArticle) throws Exception {
        if (CheckUtils.checkId(addOrUpdateArticle.getId())) {
            return new Response(Code.INVALID_PARAMETERS);
        }

        return this.articleService.updateArticle(addOrUpdateArticle) ? new Response(Code.SUCCESS) :
                new Response(Code.FAILED);
    }

    /**
     * 删除文章
     *
     * @param id
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "删除文章")
    @DeleteMapping
    public Response deleteArticle(Integer id) throws Exception {
        if (CheckUtils.checkId(id)) {
            return new Response(Code.INVALID_PARAMETERS);
        }

        return this.articleService.deleteArticle(id) ? new Response(Code.SUCCESS) :
                new Response(Code.FAILED);
    }

    /**
     * 文章列表
     *
     * @param pagination
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "文章列表")
    @GetMapping
    public Response listArticle(Pagination pagination) throws Exception {
        return new Response(this.articleService.listArticleAdmin(pagination));
    }

    /**
     * 文章预览
     *
     * @param id
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "文章预览")
    @GetMapping("/preview/{id}")
    public Response listArticle(@PathVariable Integer id) throws Exception {
        return new Response(this.articleService.previewArticle(id));
    }

    /**
     * 文章详情
     *
     * @param id
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "文章详情")
    @GetMapping("/details")
    public Response getArticleDetails(Integer id) throws Exception {
        if (CheckUtils.checkId(id)) {
            return new Response(Code.INVALID_PARAMETERS);
        }

        return new Response(this.articleService.getArticleDetailsAdmin(id));
    }

    /**
     * 设置推荐
     *
     * @param setRecommend
     * @return
     */
    @ApiOperation(value = "设置推荐")
    @PutMapping("/recommend")
    public Response setRecommend(SetRecommend setRecommend) {
        if (CheckUtils.checkId(setRecommend.getId())) {
            return new Response(Code.INVALID_PARAMETERS);
        }

        return Response.what(this.articleService.setRecommend(setRecommend));
    }

}
