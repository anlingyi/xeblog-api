package cn.xeblog.api.domain.model;

import java.time.LocalDateTime;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

/**
 * 站点地图(Sitemap)表实体类
 *
 * @author anlingyi
 * @since 2022-04-09 16:08:34
 */
@Data
public class Sitemap extends Model<Sitemap> {

    /**
     * 主键
     */
    private Integer id;
    /**
     * 访问域名
     */
    private String domain;
    /**
     * 站点地图文件输出路径
     */
    private String outPath;
    /**
     * 最近更新时间
     */
    private LocalDateTime lastUpdate;
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

}

