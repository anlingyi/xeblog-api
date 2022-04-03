package cn.xeblog.api.domain.dto.admin;


import cn.xeblog.api.domain.model.Article;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.apache.commons.lang3.time.DateFormatUtils;

/**
 * 文章列表cms
 *
 * @author yanpanyi
 */
@Data
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
    @ApiModelProperty("是否推荐，0否|1是")
    private Integer isRcmd;

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
        articleAdminDTO.setIsRcmd(article.getIsRcmd());

        return articleAdminDTO;
    }


}
