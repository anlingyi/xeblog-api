package cn.xeblog.xeblogapi.domain.dto;


import cn.xeblog.xeblogapi.domain.model.AdminUser;
import io.swagger.annotations.ApiModelProperty;

/**
 * 个人信息
 *
 * @author yanpanyi
 */
public class UserInfoDTO {

    @ApiModelProperty("头像")
    private String avatar;
    @ApiModelProperty("昵称")
    private String name;
    @ApiModelProperty("个性签名")
    private String signature;
    @ApiModelProperty("github地址")
    private String githubUrl;
    @ApiModelProperty("文章数")
    private Integer articleCount;
    @ApiModelProperty("标签数")
    private Integer tagCount;
    @ApiModelProperty("分类数")
    private Integer categoryCount;

    public Integer getCategoryCount() {
        return categoryCount;
    }

    public void setCategoryCount(Integer categoryCount) {
        this.categoryCount = categoryCount;
    }

    public Integer getArticleCount() {
        return articleCount;
    }

    public void setArticleCount(Integer articleCount) {
        this.articleCount = articleCount;
    }

    public Integer getTagCount() {
        return tagCount;
    }

    public void setTagCount(Integer tagCount) {
        this.tagCount = tagCount;
    }

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
        return "UserInfoDTO{" +
                "avatar='" + avatar + '\'' +
                ", name='" + name + '\'' +
                ", signature='" + signature + '\'' +
                ", githubUrl='" + githubUrl + '\'' +
                ", articleCount=" + articleCount +
                ", tagCount=" + tagCount +
                ", categoryCount=" + categoryCount +
                '}';
    }

    public static UserInfoDTO toUserInfoDTO(AdminUser adminUser) {
        if (null == adminUser) {
            return null;
        }

        UserInfoDTO userInfoDTO = new UserInfoDTO();
        userInfoDTO.setAvatar(adminUser.getAvatar());
        userInfoDTO.setName(adminUser.getName());
        userInfoDTO.setSignature(adminUser.getSignature());
        userInfoDTO.setGithubUrl(adminUser.getGithubUrl());

        return userInfoDTO;
    }
}
