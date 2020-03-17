package cn.xeblog.api.controller.admin;

import cn.xeblog.api.enums.Code;
import cn.xeblog.api.service.PushService;
import cn.xeblog.api.util.CheckUtils;
import cn.xeblog.api.util.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 推送管理
 *
 * @author anlingyi
 * @date 2020/3/16
 */
@Api(tags = "推送管理")
@RestController
@RequestMapping("/admin/api/push")
public class AdminPushController {

    @Resource
    private PushService pushService;

    /**
     * 文章推送
     *
     * @param articleId
     * @return
     */
    @ApiOperation(value = "文章推送")
    @PostMapping
    public Response pushArticle(Integer articleId) {
        checkArticleId(articleId);
        pushService.pushArticle(articleId);
        return Response.ok();
    }

    /**
     * 文章推送统计
     *
     * @param articleId
     * @return
     */
    @ApiOperation(value = "文章推送统计")
    @GetMapping("/articlePushStatistics")
    public Response articlePushStatistics(Integer articleId) {
        checkArticleId(articleId);
        return Response.ok(pushService.articlePushStatistics(articleId));
    }

    private void checkArticleId(Integer articleId) {
        if (CheckUtils.checkId(articleId)) {
            CheckUtils.error(Code.INVALID_PARAMETERS);
        }
    }

}
