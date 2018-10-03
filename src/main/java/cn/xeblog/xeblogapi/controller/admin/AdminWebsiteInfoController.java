package cn.xeblog.xeblogapi.controller.admin;

import cn.xeblog.xeblogapi.domain.request.UpdateWebsiteInfo;
import cn.xeblog.xeblogapi.enums.Code;
import cn.xeblog.xeblogapi.service.WebsiteInfoService;
import cn.xeblog.xeblogapi.util.Response;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 网站信息cms端
 *
 * @author yanpanyi
 * @date 2018/10/3
 */
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
    @PostMapping
    public Response updateWebsiteInfo(UpdateWebsiteInfo updateWebsiteInfo) throws Exception {
        return websiteInfoService.updateWebsite(updateWebsiteInfo) ? new Response(Code.SUCCESS) :
                new Response(Code.FAILED);
    }

}
