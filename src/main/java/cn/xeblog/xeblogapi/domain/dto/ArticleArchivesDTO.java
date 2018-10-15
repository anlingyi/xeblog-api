package cn.xeblog.xeblogapi.domain.dto;


import cn.xeblog.xeblogapi.domain.model.Article;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.time.DateFormatUtils;

/**
 * 文章归档
 *
 * @author yanpanyi
 */
public class ArticleArchivesDTO {

    @ApiModelProperty("文章id")
    private Integer id;
    @ApiModelProperty("文章标题")
    private String title;
    @ApiModelProperty("创建时间")
    private String createTime;

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

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public static ArticleArchivesDTO toArticleArchivesDTO(Article article) {
        if (null == article) {
            return null;
        }

        ArticleArchivesDTO articleArchivesDTO = new ArticleArchivesDTO();
        articleArchivesDTO.setId(article.getId());
        articleArchivesDTO.setTitle(article.getTitle());
        articleArchivesDTO.setCreateTime(DateFormatUtils.format(article.getCreateTime(), "yyyy-MM-dd"));

        return articleArchivesDTO;
    }

    @Override
    public String toString() {
        return "ArticleArchivesDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", createTime='" + createTime + '\'' +
                '}';
    }
}
