package cn.xeblog.api.domain.request;

import io.swagger.annotations.ApiModelProperty;

/**
 * 添加或更新菜单
 *
 * @author yanpanyi
 * @date 2018/10/3
 */
public class AddOrUpdateMenu {

    @ApiModelProperty("菜单id")
    private Integer id;
    @ApiModelProperty("菜单名称")
    private String name;
    @ApiModelProperty("菜单地址")
    private String url;
    @ApiModelProperty("菜单排序")
    private Integer orderId;
    @ApiModelProperty("菜单图标")
    private String icon;

    public AddOrUpdateMenu() {
    }

    public AddOrUpdateMenu(Integer id, String name, String url, Integer orderId, String icon) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.orderId = orderId;
        this.icon = icon;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
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
        return "AddOrUpdateMenu{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", orderId=" + orderId +
                ", icon='" + icon + '\'' +
                '}';
    }
}
