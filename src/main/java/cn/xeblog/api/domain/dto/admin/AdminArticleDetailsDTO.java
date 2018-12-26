package cn.xeblog.api.domain.dto.admin;


import cn.xeblog.api.domain.model.Article;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.time.DateFormatUtils;

/**
 * 文章
 *
 * @author yanpanyi
 */
public class AdminArticleDetailsDTO {

    @ApiModelProperty("文章封面")
    private String cover;
    @ApiModelProperty("置顶")
    private Integer isTop;
    @ApiModelProperty("私有")
    private Integer isPrivate;
    @ApiModelProperty("文章简述")
    private String brief;
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

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public Integer getIsTop() {
        return isTop;
    }

    public void setIsTop(Integer isTop) {
        this.isTop = isTop;
    }

    public Integer getIsPrivate() {
        return isPrivate;
    }

    public void setIsPrivate(Integer isPrivate) {
        this.isPrivate = isPrivate;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
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

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "AdminArticleDetailsDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", cover='" + cover + '\'' +
                ", isTop=" + isTop +
                ", isPrivate=" + isPrivate +
                ", categoryId=" + categoryId +
                ", tag='" + tag + '\'' +
                ", pageviews=" + pageviews +
                ", author='" + author + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", brief='" + brief + '\'' +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }

    public static AdminArticleDetailsDTO toAdminArticleDetailsDTO(Article article) {
        if (null == article) {
            return null;
        }

        AdminArticleDetailsDTO adminArticleDetailsDTO = new AdminArticleDetailsDTO();
        adminArticleDetailsDTO.setCategoryName(article.getCategoryName());
        adminArticleDetailsDTO.setBrief(article.getBrief());
        adminArticleDetailsDTO.setId(article.getId());
        adminArticleDetailsDTO.setTitle(article.getTitle());
        adminArticleDetailsDTO.setContent(article.getContent());
        adminArticleDetailsDTO.setCover(article.getCover());
        adminArticleDetailsDTO.setIsTop(article.getIsTop());
        adminArticleDetailsDTO.setIsPrivate(article.getIsPrivate());
        adminArticleDetailsDTO.setCategoryId(article.getCategoryId());
        adminArticleDetailsDTO.setTag(article.getTag());
        adminArticleDetailsDTO.setPageviews(article.getPageviews());
        adminArticleDetailsDTO.setAuthor(article.getAuthor());
        adminArticleDetailsDTO.setCreateTime(DateFormatUtils.format(article.getCreateTime(),
                "yyyy-MM-dd HH:mm:ss"));
        adminArticleDetailsDTO.setUpdateTime(DateFormatUtils.format(article.getUpdateTime(),
                "yyyy-MM-dd HH:mm:ss"));

        return adminArticleDetailsDTO;
    }
}
