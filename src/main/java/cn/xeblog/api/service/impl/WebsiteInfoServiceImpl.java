package cn.xeblog.api.service.impl;

import cn.xeblog.api.dao.WebsiteInfoMapper;
import cn.xeblog.api.domain.dto.WebsiteInfoDTO;
import cn.xeblog.api.domain.request.UpdateWebsiteInfo;
import cn.xeblog.api.service.WebsiteInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author yanpanyi
 * @date 2018/10/3
 */
@Service
public class WebsiteInfoServiceImpl implements WebsiteInfoService {

    @Resource
    private WebsiteInfoMapper websiteInfoMapper;

    @Override
    public WebsiteInfoDTO getWebsiteInfo() throws Exception {
        return WebsiteInfoDTO.toWebsiteInfoDTO(this.websiteInfoMapper.getWebsiteInfo());
    }

    @Override
    public boolean updateWebsite(UpdateWebsiteInfo updateWebsiteInfo) throws Exception {
        return 1 == this.websiteInfoMapper.updateWebsite(updateWebsiteInfo);
    }
}
