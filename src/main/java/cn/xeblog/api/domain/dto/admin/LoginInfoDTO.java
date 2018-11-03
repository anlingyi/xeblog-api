package cn.xeblog.api.domain.dto.admin;

import io.swagger.annotations.ApiModelProperty;

/**
 * 登陆信息
 *
 * @author yanpanyi
 * @date 2018/10/17
 */
public class LoginInfoDTO {

    @ApiModelProperty("id")
    private Integer id;
    @ApiModelProperty("用户名")
    private String username;
    @ApiModelProperty("token")
    private String token;

    public LoginInfoDTO() {
    }

    public LoginInfoDTO(Integer id, String username, String token) {
        this.id = id;
        this.username = username;
        this.token = token;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "LoginInfoDTO{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", token='" + token + '\'' +
                '}';
    }

}
