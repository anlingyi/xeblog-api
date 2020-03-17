package cn.xeblog.api.service;

import cn.xeblog.api.domain.bo.PageList;
import cn.xeblog.api.domain.model.Subscriber;
import cn.xeblog.api.domain.request.Pagination;
import cn.xeblog.api.domain.request.SendEmail;
import cn.xeblog.api.enums.SubscribeStatus;

import java.util.List;

/**
 * @author anlingyi
 * @date 2020/2/15
 */
public interface SubscriberService {

    /**
     * 判断邮箱是否已订阅
     *
     * @param email
     * @return
     */
    boolean isSubscribed(String email);

    /**
     * 添加订阅邮箱
     *
     * @param email
     * @return
     */
    boolean addSubscriber(String email);

    /**
     * 更新订阅者状态
     *
     * @param id
     * @param subscribeStatus
     * @return
     */
    boolean updateSubscriberStatus(int id, SubscribeStatus subscribeStatus);

    /**
     * 通过邮箱获取订阅者
     *
     * @param email
     * @return
     */
    Subscriber getSubscriberByEmail(String email);

    /**
     * 添加订阅者
     *
     * @param email
     * @param subscribeStatus
     * @return
     */
    boolean addSubscriber(String email, SubscribeStatus subscribeStatus);

    /**
     * 订阅者列表
     *
     * @param pagination
     * @return
     */
    PageList listSubscriber(Pagination pagination);

    /**
     * 查询出该文章未发送邮件的订阅者列表
     *
     * @param articleId
     * @return
     */
    List<SendEmail.Subscriber> listSendMailSubscriber(Integer articleId);

    /**
     * 通过订阅状态统计订阅人数
     *
     * @param subscribeStatus
     * @return
     */
    Integer getTotalByStatus(SubscribeStatus subscribeStatus);
}
