package cn.xeblog.xeblogapi.controller;

import cn.xeblog.xeblogapi.domain.request.QueryArticle;
import cn.xeblog.xeblogapi.enums.Code;
import cn.xeblog.xeblogapi.service.ArticleService;
import cn.xeblog.xeblogapi.util.CheckUtils;
import cn.xeblog.xeblogapi.util.Response;
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
     * 文章列表
     *
     * @param id
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "获取文章详情")
    @GetMapping("/{id}")
    public Response listArticle(@PathVariable("id") Integer id) throws Exception {
        if (CheckUtils.checkId(id)) {
            // 非法参数
            return new Response(Code.INVALID_PARAMETERS);
        }

        // 增加浏览量
        this.articleService.addPageviews(id);

        return new Response(this.articleService.getArticleDetails(id));
    }
}
