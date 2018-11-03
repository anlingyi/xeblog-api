package cn.xeblog.api.domain.dto;


import cn.xeblog.api.domain.model.Category;
import io.swagger.annotations.ApiModelProperty;

/**
 * 文章类目
 *
 * @author yanpanyi
 */
public class CategoryDTO {

    @ApiModelProperty("类目id")
    private Integer id;
    @ApiModelProperty("类目名称")
    private String name;
    @ApiModelProperty("文章数")
    private Integer articleCount;

    public CategoryDTO() {
    }

    public CategoryDTO(Integer id, String name, Integer articleCount) {
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
        return "CategoryDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", articleCount=" + articleCount +
                '}';
    }

    public static CategoryDTO toCategoryDTO(Category category) {
        if (null == category) {
            return null;
        }

        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(category.getId());
        categoryDTO.setName(category.getName());
        categoryDTO.setArticleCount(category.getArticleCount());

        return categoryDTO;
    }

}
