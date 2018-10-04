package cn.xeblog.xeblogapi.domain.dto;

import cn.xeblog.xeblogapi.domain.model.Tag;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * 标签
 *
 * @author yanpanyi
 */
public class TagDTO {

    @ApiModelProperty("标签id")
    private Integer id;
    @ApiModelProperty("标签名称")
    private String name;
    @ApiModelProperty("文章数")
    private Integer articleCount;

    public TagDTO() {
    }

    public TagDTO(Integer id, String name, Integer articleCount) {
        this.id = id;
        this.name = name;
        this.articleCount = articleCount;
    }

    public Integer getArticleCount() {
        return articleCount;
    }

    public void setArticleCount(Integer articleCount) {
        this.articleCount = articleCount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TagDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", articleCount=" + articleCount +
                '}';
    }

    public static TagDTO toTagDTO(Tag tag) {
        if (null == tag) {
            return null;
        }

        TagDTO tagDTO = new TagDTO();
        tagDTO.setId(tag.getId());
        tagDTO.setName(tag.getName());
        tagDTO.setArticleCount(tag.getArticleCount());

        return tagDTO;
    }
}
