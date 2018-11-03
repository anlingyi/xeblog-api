package cn.xeblog.api.domain.request;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * 添加或更新链接信息
 *
 * @author yanpanyi
 * @date 2018/10/17
 */
public class AddOrUpdateLink {

    @ApiModelProperty("id")
    private Integer id;

    @NotNull
    @ApiModelProperty("链接名")
    private String name;

    @NotNull
    @ApiModelProperty("链接地址")
    private String url;

    @ApiModelProperty("排序")
    private Integer orderId;

    @ApiModelProperty("简述")
    private String brief;

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

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    @Override
    public String toString() {
        return "AddOrUpdateLink{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", orderId=" + orderId +
                ", brief='" + brief + '\'' +
                '}';
    }
}
