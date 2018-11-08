package cn.xeblog.api.controller.admin;

import cn.xeblog.api.domain.request.AddOrUpdateArticle;
import cn.xeblog.api.enums.Code;
import cn.xeblog.api.service.ArticleService;
import cn.xeblog.api.util.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
