package cn.xeblog.xeblogapi.controller.admin;

import cn.xeblog.xeblogapi.enums.Code;
import cn.xeblog.xeblogapi.service.TagService;
import cn.xeblog.xeblogapi.util.CheckUtils;
import cn.xeblog.xeblogapi.util.Response;
import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 标签cms端
 *
 * @author yanpanyi
 * @date 2018/10/3
 */
@Api(tags = "标签管理")
@RestController
@RequestMapping("admin/api/tags")
public class AdminTagController {

    @Resource
    private TagService tagService;

    /**
     * 添加标签
     *
     * @param name
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "添加标签")
    @PostMapping
    public Response addTag(String name) throws Exception {
        if (StringUtils.isEmpty(name)) {
            // 非法参数
            return new Response(Code.INVALID_PARAMETERS);
        }

        return this.tagService.addTag(name) ? new Response(Code.SUCCESS) :
                new Response(Code.FAILED);
    }

    /**
     * 删除标签
     *
     * @param id
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "删除标签")
    @DeleteMapping
    public Response deleteTag(Integer id) throws Exception {
        if (CheckUtils.checkId(id)) {
            // 非法参数
            return new Response(Code.INVALID_PARAMETERS);
        }

        return this.tagService.deleteTagById(id) ? new Response(Code.SUCCESS) :
                new Response(Code.FAILED);
    }
}
