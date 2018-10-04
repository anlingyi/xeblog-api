package cn.xeblog.xeblogapi.domain.dto;

import cn.xeblog.xeblogapi.domain.model.Tag;

import java.util.Date;

/**
 * 标签
 *
 * @author yanpanyi
 */
public class TagDTO {

    private Integer id;
    private String name;

    public TagDTO() {
    }

    public TagDTO(Integer id, String name) {
        this.id = id;
        this.name = name;
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
                '}';
    }

    public static TagDTO toTagDTO(Tag tag) {
        if (null == tag) {
            return null;
        }

        TagDTO tagDTO = new TagDTO();
        tagDTO.setId(tag.getId());
        tagDTO.setName(tag.getName());

        return tagDTO;
    }
}
