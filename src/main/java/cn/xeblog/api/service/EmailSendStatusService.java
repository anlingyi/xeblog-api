package cn.xeblog.api.service;

import java.util.List;

/**
 * @author anlingyi
 * @date 2020/3/17
 */
public interface EmailSendStatusService {

    /**
     * 添加邮件发送状态
     *
     * @param subId     订阅者id
     * @param articleId 文章id
     * @param status    发送状态
     * @return
     */
    boolean addEmailSendStatus(Integer subId, Integer articleId, Integer status);

    /**
     * 通过文章ID查询发送状态列表
     *
     * @param articleId
     * @return
     */
    List<Integer> listSendStatusByArticleId(Integer articleId);
}
