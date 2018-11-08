package cn.xeblog.api.domain.request;


import io.swagger.annotations.ApiModelProperty;

/**
 * 添加或更新文章
 *
 * @author yanpanyi
 */
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    @Override
    public String toString() {
        return "AddOrUpdateArticle{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", cover='" + cover + '\'' +
                ", isTop=" + isTop +
                ", isPrivate=" + isPrivate +
                ", categoryId=" + categoryId +
                ", tag='" + tag + '\'' +
                ", author='" + author + '\'' +
                ", brief='" + brief + '\'' +
                '}';
    }
}
