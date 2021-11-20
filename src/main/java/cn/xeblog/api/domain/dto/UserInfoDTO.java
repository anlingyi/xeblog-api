package cn.xeblog.api.domain.dto;


import cn.xeblog.api.domain.model.AdminUser;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 个人信息
 *
 * @author yanpanyi
 */
@Data
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
    @ApiModelProperty("总字数")
    private Integer wordCount;

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
