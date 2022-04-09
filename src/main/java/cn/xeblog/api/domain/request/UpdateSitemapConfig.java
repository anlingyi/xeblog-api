package cn.xeblog.api.domain.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 更新站点地图配置
 *
 * @author anlingyi
 * @date 2022/4/9 4:14 下午
 */
@Data
public class UpdateSitemapConfig {

    @ApiModelProperty("访问域名")
    private String domain;

    @ApiModelProperty("站点地图文件输出路径")
    private String outPath;

}
