package cn.xeblog.api.domain.dto;

import cn.xeblog.api.domain.model.Article;
import io.swagger.annotations.ApiModelProperty;

/**
 * 文章导航（上一篇，下一篇）
 *
 * @author yanpanyi
 * @date 2018/10/8
 */
public class ArticleNavDTO {
    @ApiModelProperty("文章id")
    private Integer id;
    @ApiModelProperty("文章标题")
    private String title;

    public ArticleNavDTO() {
    }

    public ArticleNavDTO(Integer id, String title) {
        this.id = id;
        this.title = title;
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

    @Override
    public String toString() {
        return "ArticleNavDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }

    public static ArticleNavDTO toArticleNavDTO(Article article) {
        if (null == article) {
            return null;
        }

        ArticleNavDTO articleNavDTO = new ArticleNavDTO();
        articleNavDTO.setId(article.getId());
        articleNavDTO.setTitle(article.getTitle());

        return articleNavDTO;
    }
}
