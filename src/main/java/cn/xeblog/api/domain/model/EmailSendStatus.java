package cn.xeblog.api.domain.model;

import lombok.Data;

import java.util.Date;

/**
 * 邮件发送状态
 *
 * @author anlingyi
 * @date 2020/2/13
 */
@Data
public class EmailSendStatus {

    /**
     * 主键
     */
    private Integer id;
    /**
     * 订阅者id
     */
    private Integer subId;
    /**
     * 文章id
     */
    private Integer articleId;
    /**
     * 发送状态，0未发送 1发送成功 2发送失败
     */
    private Integer status;
    private Date createTime;
    private Date updateTime;
}
