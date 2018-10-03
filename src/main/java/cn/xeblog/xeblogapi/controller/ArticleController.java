package cn.xeblog.xeblogapi.controller;

import cn.xeblog.xeblogapi.service.ArticleService;
import cn.xeblog.xeblogapi.util.Response;
import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
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
@RequestMapping("/api/article")
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
}
