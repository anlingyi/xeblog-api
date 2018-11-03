package cn.xeblog.api.domain.dto.admin;

import cn.xeblog.api.domain.model.Tag;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.time.DateFormatUtils;

/**
 * 标签列表cms
 *
 * @author yanpanyi
 */
public class TagAdminDTO {

    @ApiModelProperty("id")
    private Integer id;
    @ApiModelProperty("标签名称")
    private String name;
    @ApiModelProperty("创建时间")
    private String createTime;
    @ApiModelProperty("更新时间")
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
        return "TagAdminDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createTime='" + createTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                '}';
    }

    public static TagAdminDTO toTagAdminDTO(Tag tag) {
        if (null == tag) {
            return null;
        }

        TagAdminDTO tagAdminDTO = new TagAdminDTO();
        tagAdminDTO.setId(tag.getId());
        tagAdminDTO.setName(tag.getName());
        tagAdminDTO.setCreateTime(DateFormatUtils.format(tag.getCreateTime(), "yyyy-MM-dd HH:mm:ss"));
        tagAdminDTO.setUpdateTime(DateFormatUtils.format(tag.getUpdateTime(), "yyyy-MM-dd HH:mm:ss"));

        return tagAdminDTO;

    }
}
