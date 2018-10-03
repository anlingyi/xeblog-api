package cn.xeblog.xeblogapi.domain.dto;

import cn.xeblog.xeblogapi.domain.model.Link;

/**
 * 链接
 *
 * @author yanpanyi
 */
public class LinkDTO {

    private String name;
    private String url;
    private String brief;

    public LinkDTO() {
    }

    public LinkDTO(String name, String url, String brief) {
        this.name = name;
        this.url = url;
        this.brief = brief;
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

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    @Override
    public String toString() {
        return "LinkDTO{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", brief='" + brief + '\'' +
                '}';
    }

    public static LinkDTO toLinkDTO(Link link) {
        if (null == link) {
            return null;
        }

        LinkDTO linkDTO = new LinkDTO();
        linkDTO.setName(link.getName());
        linkDTO.setUrl(link.getUrl());
        linkDTO.setBrief(link.getBrief());

        return linkDTO;
    }
}
