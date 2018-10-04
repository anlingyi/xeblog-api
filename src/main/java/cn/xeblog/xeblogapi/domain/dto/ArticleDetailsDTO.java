package cn.xeblog.xeblogapi.domain.dto;


import cn.xeblog.xeblogapi.domain.model.Article;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.time.DateFormatUtils;

/**
 * 文章详情信息
 *
 * @author yanpanyi
 */
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

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Integer getPageviews() {
        return pageviews;
    }

    public void setPageviews(Integer pageviews) {
        this.pageviews = pageviews;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "ArticleDetailsDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", categoryName='" + categoryName + '\'' +
                ", tag='" + tag + '\'' +
                ", pageviews=" + pageviews +
                ", author='" + author + '\'' +
                ", createTime='" + createTime + '\'' +
                ", content='" + content + '\'' +
                ", updateTime='" + updateTime + '\'' +
                '}';
    }

    public static ArticleDetailsDTO toArticleDetailsDTO(Article article) {
        if (null == article) {
            return null;
        }

        ArticleDetailsDTO articleDetailsDTO = new ArticleDetailsDTO();
        articleDetailsDTO.setUpdateTime(DateFormatUtils.format(article.getUpdateTime(), "yyyy-MM-dd"));
        articleDetailsDTO.setContent(article.getContent());
        articleDetailsDTO.setId(article.getId());
        articleDetailsDTO.setTitle(article.getTitle());
        articleDetailsDTO.setCategoryName(article.getCategoryName());
        articleDetailsDTO.setTag(article.getTag());
        articleDetailsDTO.setPageviews(article.getPageviews());
        articleDetailsDTO.setAuthor(article.getAuthor());
        articleDetailsDTO.setCreateTime(DateFormatUtils.format(article.getCreateTime(), "yyyy-MM-dd"));

        return articleDetailsDTO;
    }
}
