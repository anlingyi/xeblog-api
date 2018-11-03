package cn.xeblog.api.domain.dto.admin;

import cn.xeblog.api.domain.model.Menu;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.time.DateFormatUtils;

/**
 * 菜单列表cms
 *
 * @author yanpanyi
 * @date 2018/10/16
 */
public class MenuAdminDTO {

    @ApiModelProperty("id")
    private Integer id;
    @ApiModelProperty("菜单名称")
    private String name;
    @ApiModelProperty("跳转地址")
    private String url;
    @ApiModelProperty("排序id")
    private Integer orderId;
    @ApiModelProperty("创建时间")
    private String createTime;
    @ApiModelProperty("更新时间")
    private String updateTime;
    @ApiModelProperty("图标")
    private String icon;

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
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

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
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
        return "MenuAdminDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", orderId=" + orderId +
                ", createTime='" + createTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", icon='" + icon + '\'' +
                '}';
    }

    public static MenuAdminDTO toMenuAdminDTO(Menu menu) {
        if (null == menu) {
            return null;
        }

        MenuAdminDTO menuAdminDTO = new MenuAdminDTO();
        menuAdminDTO.setIcon(menu.getIcon());
        menuAdminDTO.setId(menu.getId());
        menuAdminDTO.setName(menu.getName());
        menuAdminDTO.setUrl(menu.getUrl());
        menuAdminDTO.setOrderId(menu.getOrderId());
        menuAdminDTO.setCreateTime(DateFormatUtils.format(menu.getCreateTime(), "yyyy-MM-dd HH:mm:ss"));
        menuAdminDTO.setUpdateTime(DateFormatUtils.format(menu.getUpdateTime(), "yyyy-MM-dd HH:mm:ss"));

        return menuAdminDTO;
    }
}
