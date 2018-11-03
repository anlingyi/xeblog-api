package cn.xeblog.api.controller.admin;

import cn.xeblog.api.domain.request.AddOrUpdateLink;
import cn.xeblog.api.domain.request.Pagination;
import cn.xeblog.api.enums.Code;
import cn.xeblog.api.service.LinkService;
import cn.xeblog.api.util.CheckUtils;
import cn.xeblog.api.util.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 链接管理
 *
 * @author yanpanyi
 * @date 2018/10/17
 */
@Api(tags = "链接管理")
@RestController
@RequestMapping("/admin/api/links")
public class AdminLinkController {

    @Resource
    private LinkService linkService;

    /**
     * 获取链接列表
     *
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "链接列表")
    @GetMapping()
    public Response listLink(Pagination pagination) throws Exception {
        return new Response(this.linkService.listLinkAdmin(pagination));
    }

    /**
     * 添加链接
     *
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "添加链接")
    @PostMapping()
    public Response addLink(AddOrUpdateLink addOrUpdateLink, BindingResult bindingResult) throws Exception {
        // 校验参数
        if (bindingResult.hasErrors()) {
            // 非法参数
            return new Response(Code.INVALID_PARAMETERS);
        }

        return this.linkService.addLink(addOrUpdateLink) ? new Response(Code.SUCCESS) :
                new Response(Code.FAILED);
    }

    /**
     * 删除链接
     *
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "删除链接")
    @DeleteMapping()
    public Response deleteLink(Integer id) throws Exception {
        if (CheckUtils.checkId(id)) {
            // 非法参数
            return new Response(Code.INVALID_PARAMETERS);
        }
        return this.linkService.deleteLinkById(id) ? new Response(Code.SUCCESS) :
                new Response(Code.FAILED);
    }

    /**
     * 修改链接
     *
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "修改链接")
    @PutMapping()
    public Response updateLink(AddOrUpdateLink addOrUpdateLink, BindingResult bindingResult) throws Exception {
        if (CheckUtils.checkId(addOrUpdateLink.getId()) || bindingResult.hasErrors()) {
            // 非法参数
            return new Response(Code.INVALID_PARAMETERS);
        }

        return this.linkService.updateLink(addOrUpdateLink) ? new Response(Code.SUCCESS) :
                new Response(Code.FAILED);
    }
}
