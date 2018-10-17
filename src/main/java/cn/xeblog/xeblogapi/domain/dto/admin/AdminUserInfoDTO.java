package cn.xeblog.xeblogapi.domain.dto.admin;


import cn.xeblog.xeblogapi.domain.model.AdminUser;
import io.swagger.annotations.ApiModelProperty;

/**
 * 个人信息cms
 *
 * @author yanpanyi
 */
public class AdminUserInfoDTO {

    @ApiModelProperty("id")
    private Integer id;
    @ApiModelProperty("头像")
    private String avatar;
    @ApiModelProperty("昵称")
    private String name;
    @ApiModelProperty("个性签名")
    private String signature;
    @ApiModelProperty("github地址")
    private String githubUrl;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        return "AdminUserInfoDTO{" +
                "id=" + id +
                ", avatar='" + avatar + '\'' +
                ", name='" + name + '\'' +
                ", signature='" + signature + '\'' +
                ", githubUrl='" + githubUrl + '\'' +
                '}';
    }

    public static AdminUserInfoDTO toAdminUserInfoDTO(AdminUser adminUser) {
        if (null == adminUser) {
            return null;
        }

        AdminUserInfoDTO adminUserInfoDTO = new AdminUserInfoDTO();
        adminUserInfoDTO.setAvatar(adminUser.getAvatar());
        adminUserInfoDTO.setName(adminUser.getName());
        adminUserInfoDTO.setSignature(adminUser.getSignature());
        adminUserInfoDTO.setGithubUrl(adminUser.getGithubUrl());
        adminUserInfoDTO.setId(adminUser.getId());

        return adminUserInfoDTO;
    }
}
