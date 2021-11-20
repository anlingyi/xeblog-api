package cn.xeblog.api.domain.dto;


import cn.xeblog.api.domain.model.Article;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.apache.commons.lang3.time.DateFormatUtils;

/**
 * 文章详情信息
 *
 * @author yanpanyi
 */
@Data
public class ArticleDetailsDTO {

    @ApiModelProperty("文章id")
    private Integer id;
    @ApiModelProperty("文章标题")
    private String title;
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
    @ApiModelProperty("文章内容")
    private String content;
    @ApiModelProperty("更新时间")
    private String updateTime;
    @ApiModelProperty("文章类目id")
    private Integer categoryId;
    @ApiModelProperty("文章封面")
    private String cover;
    @ApiModelProperty("文章简述")
    private String brief;
    @ApiModelProperty("是否置顶")
    private Boolean top;
    @ApiModelProperty("文章字数")
    private Integer wordCount;

    public static ArticleDetailsDTO toArticleDetailsDTO(Article article) {
        if (null == article) {
            return null;
        }

        ArticleDetailsDTO articleDetailsDTO = new ArticleDetailsDTO();
        articleDetailsDTO.setUpdateTime(DateFormatUtils.format(article.getUpdateTime(), "yyyy/MM/dd"));
        articleDetailsDTO.setContent(article.getContent());
        articleDetailsDTO.setId(article.getId());
        articleDetailsDTO.setTitle(article.getTitle());
        articleDetailsDTO.setCategoryName(article.getCategoryName());
        articleDetailsDTO.setTag(article.getTag());
        articleDetailsDTO.setPageviews(article.getPageviews());
        articleDetailsDTO.setAuthor(article.getAuthor());
        articleDetailsDTO.setCreateTime(DateFormatUtils.format(article.getCreateTime(), "yyyy/MM/dd"));
        articleDetailsDTO.setCategoryName(article.getCategoryName());
        articleDetailsDTO.setCategoryId(article.getCategoryId());
        articleDetailsDTO.setCover(article.getCover());
        articleDetailsDTO.setBrief(article.getBrief());
        articleDetailsDTO.setTop(article.getIsTop() == 1);
        articleDetailsDTO.setWordCount(article.getWordCount());

        return articleDetailsDTO;
    }
}
