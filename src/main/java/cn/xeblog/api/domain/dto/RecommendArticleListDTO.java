package cn.xeblog.api.domain.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author anlingyi
 * @date 2022/4/3 6:58 下午
 */
@Data
public class RecommendArticleListDTO {

    @ApiModelProperty("文章id")
    private Integer id;
    @ApiModelProperty("文章标题")
    private String title;
    @ApiModelProperty("浏览量")
    private Integer pageviews;

}
