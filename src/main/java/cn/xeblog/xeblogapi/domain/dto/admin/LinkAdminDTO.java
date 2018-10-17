package cn.xeblog.xeblogapi.domain.dto.admin;

import cn.xeblog.xeblogapi.domain.model.Link;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.time.DateFormatUtils;

/**
 * 链接
 *
 * @author yanpanyi
 */
public class LinkAdminDTO {

    @ApiModelProperty("id")
    private Integer id;
    @ApiModelProperty("链接名")
    private String name;
    @ApiModelProperty("链接地址")
    private String url;
    @ApiModelProperty("排序")
    private Integer orderId;
    @ApiModelProperty("简述")
    private String brief;
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
        return "LinkAdminDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", orderId=" + orderId +
                ", brief='" + brief + '\'' +
                ", createTime='" + createTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                '}';
    }

    public static LinkAdminDTO toLinkAdminDTO(Link link) {
        if (null == link) {
            return null;
        }

        LinkAdminDTO linkAdminDTO = new LinkAdminDTO();
        linkAdminDTO.setId(link.getId());
        linkAdminDTO.setName(link.getName());
        linkAdminDTO.setUrl(link.getUrl());
        linkAdminDTO.setOrderId(link.getOrderId());
        linkAdminDTO.setBrief(link.getBrief());
        linkAdminDTO.setCreateTime(DateFormatUtils.format(link.getCreateTime(), "yyyy-MM-dd HH:mm:ss"));
        linkAdminDTO.setUpdateTime(DateFormatUtils.format(link.getUpdateTime(), "yyyy-MM-dd HH:mm:ss"));

        return linkAdminDTO;
    }
}
