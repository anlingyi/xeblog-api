package cn.xeblog.xeblogapi.dao;

import cn.xeblog.xeblogapi.domain.model.WebsiteInfo;
import cn.xeblog.xeblogapi.domain.request.UpdateWebsiteInfo;
import org.apache.ibatis.annotations.Param;

/**
 * @author yanpanyi
 * @date 2018/10/3
 */
public interface WebsiteInfoMapper {

    /**
     * 获取网站信息
     *
     * @return
     * @throws Exception
     */
    WebsiteInfo getWebsiteInfo() throws Exception;

    /**
     * 更新网站信息
     *
     * @param updateWebsiteInfo
     * @return
     * @throws Exception
     */
    Integer updateWebsite(@Param("info") UpdateWebsiteInfo updateWebsiteInfo) throws Exception;
}
