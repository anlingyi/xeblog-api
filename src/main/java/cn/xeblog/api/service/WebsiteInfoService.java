package cn.xeblog.api.service;

import cn.xeblog.api.domain.dto.WebsiteInfoDTO;
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
     * @return
     * @throws Exception
     */
    boolean updateWebsite(UpdateWebsiteInfo updateWebsiteInfo) throws Exception;
}
