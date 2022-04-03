package cn.xeblog.api.domain.dto;


import cn.xeblog.api.domain.model.Article;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.apache.commons.lang3.time.DateFormatUtils;

/**
 * 文章信息
 *
 * @author yanpanyi
 */
@Data
public class ArticleDTO {

    @ApiModelProperty("文章id")
    private Integer id;
    @ApiModelProperty("文章标题")
    private String title;
    @ApiModelProperty("文章封面")
    private String cover;
    @ApiModelProperty("文章类目")
    private String categoryName;
    @ApiModelProperty("文章标签")
    private String tag;
    @ApiModelProperty("浏览量")
    private Integer pageviews;
    @ApiModelProperty("文章作者")
    private String author;
    @ApiModelProperty("创建时间")
    private String createTime;
    @ApiModelProperty("文章简述")
    private String brief;
    @ApiModelProperty("置顶")
    private Boolean top;
    @ApiModelProperty("文章类目id")
    private Integer categoryId;
    @ApiModelProperty("推荐状态 0.不推荐 1.推荐")
    private Integer isRcmd;

    public static ArticleDTO toArticleDTO(Article article) {
        if (null == article) {
            return null;
        }

        ArticleDTO articleDTO = new ArticleDTO();
        articleDTO.setBrief(article.getBrief());
        articleDTO.setId(article.getId());
        articleDTO.setTitle(article.getTitle());
        articleDTO.setCover(article.getCover());
        articleDTO.setCategoryName(article.getCategoryName());
        articleDTO.setTag(article.getTag());
        articleDTO.setPageviews(article.getPageviews());
        articleDTO.setAuthor(article.getAuthor());
        articleDTO.setCreateTime(DateFormatUtils.format(article.getCreateTime(), "yyyy/MM/dd"));
        articleDTO.setTop(article.getIsTop() == 1);
        articleDTO.setCategoryId(article.getCategoryId());
        articleDTO.setIsRcmd(article.getIsRcmd());

        return articleDTO;
    }
}
