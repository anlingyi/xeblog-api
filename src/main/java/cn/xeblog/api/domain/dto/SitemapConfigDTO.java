package cn.xeblog.api.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 站点地图配置信息
 *
 * @author anlingyi
 * @date 2022/4/9 5:58 下午
 */
@Data
public class SitemapConfigDTO {

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
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private LocalDateTime lastUpdate;

}
