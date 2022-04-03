package cn.xeblog.api.controller;

import cn.xeblog.api.domain.request.Pagination;
import cn.xeblog.api.domain.request.QueryArticle;
import cn.xeblog.api.enums.Code;
import cn.xeblog.api.service.ArticleService;
import cn.xeblog.api.util.CheckUtils;
import cn.xeblog.api.util.Response;
import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 文章
 *
 * @author yanpanyi
 * @date 2018/10/3
 */
@Api(tags = "文章")
@RestController
@RequestMapping("/api/articles")
public class ArticleController {

    @Resource
    private ArticleService articleService;

    /**
     * 获取公开文章总数
     *
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "获取公开文章总数")
    @GetMapping("/count")
    public Response getCount() throws Exception {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("articleCount", this.articleService.getCount());

        return new Response(jsonObject);
    }

    /**
     * 文章列表
     *
     * @param queryArticle
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "获取文章列表")
    @GetMapping()
    public Response listArticle(QueryArticle queryArticle) throws Exception {
        return new Response(this.articleService.listArticle(queryArticle));
    }

    /**
     * 获取文章详情
     *
     * @param id
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "获取文章详情")
    @GetMapping("/{id}")
    public Response getArticleDetails(@PathVariable("id") Integer id) throws Exception {
        if (CheckUtils.checkId(id)) {
            // 非法参数
            return new Response(Code.INVALID_PARAMETERS);
        }

        // 增加浏览量
        this.articleService.addPageviews(id);

        return new Response(this.articleService.getArticleDetails(id));
    }

    /**
     * 归档
     *
     * @param pagination
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "归档")
    @GetMapping("/archives")
    public Response archives(Pagination pagination) throws Exception {
        return new Response(articleService.listArchives(pagination));
    }

    @ApiOperation(value = "随机文章")
    @GetMapping("/random")
    public Response randomArticle() {
        return new Response(this.articleService.randomArticle());
    }

    @ApiOperation(value = "获取推荐文章列表")
    @GetMapping("/recommend")
    public Response listRecommend() {
        return new Response(this.articleService.listRecommend());
    }

}
