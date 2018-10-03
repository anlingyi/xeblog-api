package cn.xeblog.xeblogapi.domain.request;

/**
 * 更新网站信息
 *
 * @author yanpanyi
 * @date 2018/10/3
 */
public class UpdateWebsiteInfo {

    private String title;
    private String copyright;

    public UpdateWebsiteInfo() {
    }

    public UpdateWebsiteInfo(String title, String copyright) {
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
}
