package cn.xeblog.api.domain.dto;


import cn.xeblog.api.domain.model.Article;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.time.DateFormatUtils;

/**
 * 文章信息
 *
 * @author yanpanyi
 */
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

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Boolean getTop() {
        return top;
    }

    public void setTop(Boolean top) {
        this.top = top;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
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

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
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

    @Override
    public String toString() {
        return "ArticleDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", cover='" + cover + '\'' +
                ", categoryName='" + categoryName + '\'' +
                ", tag='" + tag + '\'' +
                ", pageviews=" + pageviews +
                ", author='" + author + '\'' +
                ", createTime='" + createTime + '\'' +
                ", brief='" + brief + '\'' +
                ", top=" + top +
                ", categoryId='" + categoryId + '\'' +
                '}';
    }

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
        articleDTO.setCreateTime(DateFormatUtils.format(article.getCreateTime(), "yyyy-MM-dd"));
        articleDTO.setTop(article.getIsTop() == 1);
        articleDTO.setCategoryId(article.getCategoryId());

        return articleDTO;
    }
}
