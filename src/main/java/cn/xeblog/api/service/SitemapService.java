package cn.xeblog.api.service;

import cn.xeblog.api.domain.request.UpdateSitemapConfig;
import com.baomidou.mybatisplus.extension.service.IService;
import cn.xeblog.api.domain.model.Sitemap;

/**
 * 站点地图(Sitemap)表服务接口
 *
 * @author anlingyi
 * @since 2022-04-09 16:08:34
 */
public interface SitemapService extends IService<Sitemap> {

    /**
     * 更新站点地图配置
     *
     * @param updateSitemapConfig
     * @return
     */
    boolean updateConfig(UpdateSitemapConfig updateSitemapConfig);

    /**
     * 生成站点地图
     *
     * @return
     */
    boolean generate();

}

