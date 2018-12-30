package cn.xeblog.api.domain.dto.admin;

import cn.xeblog.api.domain.model.WebsiteInfo;
import org.apache.commons.lang3.time.DateFormatUtils;

/**
 * 网站信息cms
 *
 * @author yanpanyi
 */
public class AdminWebsiteInfoDTO {

    private String title;
    private String copyright;
    private String createTime;
    private String updateTime;
    private String subtitle;

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
        return "AdminWebsiteInfoDTO{" +
                "title='" + title + '\'' +
                ", copyright='" + copyright + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", subtitle='" + subtitle + '\'' +
                '}';
    }

    public static AdminWebsiteInfoDTO toAdminWebsiteInfoDTO(WebsiteInfo websiteInfo) {
        if (null == websiteInfo) {
            return null;
        }

        AdminWebsiteInfoDTO adminWebsiteInfoDTO = new AdminWebsiteInfoDTO();
        adminWebsiteInfoDTO.setSubtitle(websiteInfo.getSubtitle());
        adminWebsiteInfoDTO.setTitle(websiteInfo.getTitle());
        adminWebsiteInfoDTO.setCopyright(websiteInfo.getCopyright());
        adminWebsiteInfoDTO.setCreateTime(DateFormatUtils.format(websiteInfo.getCreateTime(), "yyyy-MM-dd HH:mm:ss"));
        adminWebsiteInfoDTO.setUpdateTime(DateFormatUtils.format(websiteInfo.getCreateTime(), "yyyy-MM-dd HH:mm:ss"));

        return adminWebsiteInfoDTO;
    }
}
