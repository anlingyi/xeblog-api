package cn.xeblog.api.dao;

import cn.xeblog.api.domain.model.WebsiteInfo;
import cn.xeblog.api.domain.request.UpdateWebsiteInfo;
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

    /**
     * 获取网站信息cms
     *
     * @return
     * @throws Exception
     */
    WebsiteInfo getWebsiteInfoAdmin() throws Exception;
}
