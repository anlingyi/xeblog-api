package cn.xeblog.api.service;

import cn.xeblog.api.domain.dto.WebsiteInfoDTO;
import cn.xeblog.api.domain.dto.admin.AdminWebsiteInfoDTO;
import cn.xeblog.api.domain.request.UpdateWebsiteInfo;

/**
 * @author yanpanyi
 * @date 2018/10/3
 */
public interface WebsiteInfoService {

    /**
     * 获取网站信息
     *
     * @return
     * @throws Exception
     */
    WebsiteInfoDTO getWebsiteInfo() throws Exception;

    /**
     * 更新网站信息
     *
     * @param updateWebsiteInfo
     * @return
     * @throws Exception
     */
    boolean updateWebsite(UpdateWebsiteInfo updateWebsiteInfo) throws Exception;

    /**
     * 获取网站信息cms
     *
     * @return
     * @throws Exception
     */
    AdminWebsiteInfoDTO getWebsiteInfoAdmin() throws Exception;
}
