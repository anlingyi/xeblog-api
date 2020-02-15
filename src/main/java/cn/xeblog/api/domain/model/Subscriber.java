package cn.xeblog.api.domain.model;

import lombok.Data;

import java.util.Date;

/**
 * 订阅者
 *
 * @author anlingyi
 * @date 2020/2/13
 */
@Data
public class Subscriber {

    /**
     * 主键
     */
    private Integer id;
    /**
     * 邮箱账号
     */
    private String email;
    /**
     * uid
     */
    private String uid;
    /**
     * 订阅状态，0未验证 1已订阅 2.未订阅/取消订阅
     */
    private Integer status;
    private Date createTime;
    private Date updateTime;
}
