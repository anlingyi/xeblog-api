package cn.xeblog.api.service.impl;

import cn.xeblog.api.dao.SubscriberMapper;
import cn.xeblog.api.domain.model.Subscriber;
import cn.xeblog.api.enums.SubscribeStatus;
import cn.xeblog.api.service.SubscriberService;
import cn.xeblog.api.util.UUIDUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author anlingyi
 * @date 2020/2/15
 */
@Service
public class SubscriberServiceImpl implements SubscriberService {

    @Resource
    private SubscriberMapper subscriberMapper;

    @Override
    public boolean isSubscribed(String email) {
        Subscriber subscriber = subscriberMapper.getSubscriberByEmail(email);
        return null != subscriber && SubscribeStatus.SUBSCRIBED.getStatus() == subscriber.getStatus();
    }

    @Override
    public boolean addSubscriber(String email) {
        return 1 == subscriberMapper.addSubscriber(email, createUid());
    }

    @Override
    public boolean updateSubscriberStatus(int id, SubscribeStatus subscribeStatus) {
        return 1 == subscriberMapper.updateSubscriberStatus(id, subscribeStatus.getStatus());
    }

    @Override
    public Subscriber getSubscriberByEmail(String email) {
        return subscriberMapper.getSubscriberByEmail(email);
    }

    @Override
    public boolean addSubscriber(String email, SubscribeStatus subscribeStatus) {
        return 1 == subscriberMapper.addSubscriber(email, createUid(), subscribeStatus.getStatus());
    }

    /**
     * 创建uid
     *
     * @return
     */
    private String createUid() {
        return UUIDUtils.createUUID();
    }

}
