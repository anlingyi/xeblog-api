package cn.xeblog.api.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import cn.xeblog.api.domain.model.Sitemap;
import org.apache.ibatis.annotations.Mapper;

/**
 * 站点地图(Sitemap)表数据库访问层
 *
 * @author anlingyi
 * @since 2022-04-09 16:08:34
 */
@Mapper
public interface SitemapMapper extends BaseMapper<Sitemap> {

}

