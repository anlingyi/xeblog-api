package cn.xeblog.api.domain.dto.admin;


import cn.xeblog.api.domain.model.Article;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.time.DateFormatUtils;

/**
 * 文章列表cms
 *
 * @author yanpanyi
 */
public class ArticleAdminDTO {

    @ApiModelProperty("文章id")
    private Integer id;
    @ApiModelProperty("文章标题")
    private String title;
    @ApiModelProperty("文章类目")
    private String categoryName;
    @ApiModelProperty("浏览量")
    private Integer pageviews;
    @ApiModelProperty("创建时间")
    private String createTime;
    @ApiModelProperty("置顶 0否1是")
    private Integer isTop;
    @ApiModelProperty("私有 0否1是")
    private Integer isPrivate;

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

    public Integer getPageviews() {
        return pageviews;
    }

    public void setPageviews(Integer pageviews) {
        this.pageviews = pageviews;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
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

    @Override
    public String toString() {
        return "ArticleAdminDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", categoryName='" + categoryName + '\'' +
                ", pageviews=" + pageviews +
                ", createTime='" + createTime + '\'' +
                ", isTop=" + isTop +
                ", isPrivate=" + isPrivate +
                '}';
    }

    public static ArticleAdminDTO toArticleAdminDTO(Article article) {
        if (null == article) {
            return null;
        }

        ArticleAdminDTO articleAdminDTO = new ArticleAdminDTO();
        articleAdminDTO.setId(article.getId());
        articleAdminDTO.setTitle(article.getTitle());
        articleAdminDTO.setCategoryName(article.getCategoryName());
        articleAdminDTO.setPageviews(article.getPageviews());
        articleAdminDTO.setCreateTime(DateFormatUtils.format(article.getCreateTime(), "yyyy-MM-dd HH:mm:ss"));
        articleAdminDTO.setIsPrivate(article.getIsPrivate());
        articleAdminDTO.setIsTop(article.getIsTop());

        return articleAdminDTO;
    }


}
