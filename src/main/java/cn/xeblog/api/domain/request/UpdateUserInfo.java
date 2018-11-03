package cn.xeblog.api.domain.request;


import io.swagger.annotations.ApiModelProperty;

/**
 * 更新个人信息
 *
 * @author yanpanyi
 */
public class UpdateUserInfo {

    @ApiModelProperty("头像")
    private String avatar;
    @ApiModelProperty("昵称")
    private String name;
    @ApiModelProperty("个性签名")
    private String signature;
    @ApiModelProperty("github地址")
    private String githubUrl;

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getGithubUrl() {
        return githubUrl;
    }

    public void setGithubUrl(String githubUrl) {
        this.githubUrl = githubUrl;
    }

    @Override
    public String toString() {
        return "UpdateUserInfo{" +
                ", avatar='" + avatar + '\'' +
                ", name='" + name + '\'' +
                ", signature='" + signature + '\'' +
                ", githubUrl='" + githubUrl + '\'' +
                '}';
    }
}
