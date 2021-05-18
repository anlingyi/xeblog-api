package cn.xeblog.api.domain.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 查询文章列表
 *
 * @author yanpanyi
 * @date 2018/10/4
 */
@Data
public class QueryArticle extends Pagination {

    @ApiModelProperty("查询关键字")
    private String query;
    @ApiModelProperty("标签")
    private String tag;
    @ApiModelProperty("类目id")
    private Integer categoryId;
    @ApiModelProperty("排序")
    private Integer sort;

}
