package cn.xeblog.xeblogapi.domain.dto;

import cn.xeblog.xeblogapi.domain.model.Menu;
import io.swagger.annotations.ApiModelProperty;

/**
 * 菜单信息
 *
 * @author yanpanyi
 * @date 2018/10/3
 */
public class MenuDTO {

    @ApiModelProperty("菜单id")
    private Integer id;
    @ApiModelProperty("菜单名称")
    private String name;
    @ApiModelProperty("菜单地址")
    private String url;

    public MenuDTO() {
    }

    public MenuDTO(Integer id, String name, String url) {
        this.id = id;
        this.name = name;
        this.url = url;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "MenuDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

    public static MenuDTO toMenuDTO(Menu menu) {
        if (null == menu) {
            return null;
        }

        MenuDTO menuDTO = new MenuDTO();
        menuDTO.setId(menu.getId());
        menuDTO.setName(menu.getName());
        menuDTO.setUrl(menu.getUrl());

        return menuDTO;
    }
}
