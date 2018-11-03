package cn.xeblog.api.controller.admin;

import cn.xeblog.api.domain.request.UpdateWebsiteInfo;
import cn.xeblog.api.enums.Code;
import cn.xeblog.api.service.WebsiteInfoService;
import cn.xeblog.api.util.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 网站信息cms端
 *
 * @author yanpanyi
 * @date 2018/10/3
 */
@Api(tags = "网站信息管理")
@RestController
@RequestMapping("admin/api/website_info")
public class AdminWebsiteInfoController {

    @Resource
    private WebsiteInfoService websiteInfoService;

    /**
     * 更新网站信息
     *
     * @param updateWebsiteInfo
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "网站信息更新", notes = "更新网站标题、副标题、版权信息")
    @PostMapping
    public Response updateWebsiteInfo(UpdateWebsiteInfo updateWebsiteInfo) throws Exception {
        return this.websiteInfoService.updateWebsite(updateWebsiteInfo) ? new Response(Code.SUCCESS) :
                new Response(Code.FAILED);
    }

}
