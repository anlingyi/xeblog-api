package cn.xeblog.xeblogapi.domain.dto;

import cn.xeblog.xeblogapi.domain.model.WebsiteInfo;

/**
 * 网站信息
 *
 * @author yanpanyi
 * @date 2018/10/3
 */
public class WebsiteInfoDTO {

    private String title;
    private String copyright;

    public WebsiteInfoDTO() {
    }

    public WebsiteInfoDTO(String title, String copyright) {
        this.title = title;
        this.copyright = copyright;
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

        return websiteInfoDTO;
    }
}
