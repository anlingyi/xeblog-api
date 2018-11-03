package cn.xeblog.api.domain.request;

import io.swagger.annotations.ApiModelProperty;

/**
 * 更新网站信息
 *
 * @author yanpanyi
 * @date 2018/10/3
 */
public class UpdateWebsiteInfo {
    @ApiModelProperty("网站标题")
    private String title;
    @ApiModelProperty("网站版权")
    private String copyright;
    @ApiModelProperty("网站副标题")
    private String subtitle;

    public UpdateWebsiteInfo() {
    }

    public UpdateWebsiteInfo(String title, String copyright, String subtitle) {
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
}
