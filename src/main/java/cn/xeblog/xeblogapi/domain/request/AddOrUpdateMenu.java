package cn.xeblog.xeblogapi.domain.request;

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

    public AddOrUpdateMenu() {
    }

    public AddOrUpdateMenu(Integer id, String name, String url, Integer orderId) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.orderId = orderId;
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
                '}';
    }
}
