package cn.xeblog.xeblogapi.controller;

import cn.xeblog.xeblogapi.service.TagService;
import cn.xeblog.xeblogapi.util.Response;
import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 标签
 *
 * @author yanpanyi
 * @date 2018/10/3
 */
@Api(tags = "标签")
@RestController
@RequestMapping("/api/tags")
public class TagController {

    @Resource
    private TagService tagService;

    /**
     * 获取标签总数
     *
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "获取标签总数")
    @GetMapping("/count")
    public Response getCount() throws Exception {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("tagCount", this.tagService.getCount());

        return new Response(jsonObject);
    }

    /**
     * 获取标签列表
     *
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "获取标签列表")
    @GetMapping()
    public Response listTag() throws Exception {
        return new Response(this.tagService.listTag());
    }
}
