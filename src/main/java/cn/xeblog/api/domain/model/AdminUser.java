package cn.xeblog.api.domain.model;


import lombok.Data;

import java.util.Date;

/**
 * 管理员用户
 *
 * @author yanpanyi
 */
@Data
public class AdminUser {

    private Integer id;
    private String username;
    private String password;
    private String token;
    private String avatar;
    private String name;
    private String signature;
    private String githubUrl;
    private Date createTime;
    private Date updateTime;
    private String uid;

}
