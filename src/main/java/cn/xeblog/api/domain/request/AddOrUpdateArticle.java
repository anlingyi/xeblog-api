package cn.xeblog.api.domain.request;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 添加或更新文章
 *
 * @author yanpanyi
 */
@Data
public class AddOrUpdateArticle {

    @ApiModelProperty("文章id")
    private Integer id;
    @ApiModelProperty("文章标题")
    private String title;
    @ApiModelProperty("文章内容")
    private String content;
    @ApiModelProperty("文章封面")
    private String cover;
    @ApiModelProperty("置顶 0否1是")
    private Integer isTop;
    @ApiModelProperty("私有 0否1是")
    private Integer isPrivate;
    @ApiModelProperty("文章类目id")
    private Integer categoryId;
    @ApiModelProperty("文章标签")
    private String tag;
    @ApiModelProperty("文章作者")
    private String author;
    @ApiModelProperty("文章简述")
    private String brief;
    @ApiModelProperty("文章字数")
    private Integer wordCount;

}
