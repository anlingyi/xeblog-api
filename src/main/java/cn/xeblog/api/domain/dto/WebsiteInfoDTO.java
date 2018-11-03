package cn.xeblog.api.domain.dto;

import cn.xeblog.api.domain.model.WebsiteInfo;

/**
 * 网站信息
 *
 * @author yanpanyi
 * @date 2018/10/3
 */
public class WebsiteInfoDTO {

    private String title;
    private String copyright;
    private String subtitle;

    public WebsiteInfoDTO() {
    }

    public WebsiteInfoDTO(String title, String copyright, String subtitle) {
        this.title = title;
        this.copyright = copyright;
        this.subtitle = subtitle;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    @Override
    public String toString() {
        return "UpdateWebsiteInfo{" +
                "title='" + title + '\'' +
                ", copyright='" + copyright + '\'' +
                '}';
    }

    public static WebsiteInfoDTO toWebsiteInfoDTO(WebsiteInfo websiteInfo) {
        if (null == websiteInfo) {
            return null;
        }

        WebsiteInfoDTO websiteInfoDTO = new WebsiteInfoDTO();
        websiteInfoDTO.setTitle(websiteInfo.getTitle());
        websiteInfoDTO.setCopyright(websiteInfo.getCopyright());
        websiteInfoDTO.setSubtitle(websiteInfo.getSubtitle());

        return websiteInfoDTO;
    }
}
