package cn.xeblog.api.domain.dto.admin;

import cn.xeblog.api.domain.model.Category;
import org.apache.commons.lang3.time.DateFormatUtils;

/**
 * 文章类目
 *
 * @author yanpanyi
 */
public class CategoryAdminDTO {

    private Integer id;
    private String name;
    private String createTime;
    private String updateTime;

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
        return "CategoryAdminDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }

    public static CategoryAdminDTO toCategoryAdminDTO(Category category) {
        if (null == category) {
            return null;
        }

        CategoryAdminDTO categoryAdminDTO = new CategoryAdminDTO();
        categoryAdminDTO.setId(category.getId());
        categoryAdminDTO.setName(category.getName());
        categoryAdminDTO.setCreateTime(DateFormatUtils.format(category.getCreateTime(), "yyyy-MM-dd HH:mm:ss"));
        categoryAdminDTO.setUpdateTime(DateFormatUtils.format(category.getUpdateTime(), "yyyy-MM-dd HH:mm:ss"));

        return categoryAdminDTO;
    }
}
