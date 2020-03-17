package cn.xeblog.api.service.impl;

import cn.xeblog.api.dao.SubscriberMapper;
import cn.xeblog.api.domain.bo.PageList;
import cn.xeblog.api.domain.dto.admin.SubscriberListDTO;
import cn.xeblog.api.domain.model.Subscriber;
import cn.xeblog.api.domain.request.Pagination;
import cn.xeblog.api.domain.request.SendEmail;
import cn.xeblog.api.enums.SubscribeStatus;
import cn.xeblog.api.service.SubscriberService;
import cn.xeblog.api.util.UUIDUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public PageList listSubscriber(Pagination pagination) {
        PageHelper.startPage(pagination.getPageIndex(), pagination.getPageSize());

        List<Subscriber> subscriberList = subscriberMapper.listSubscriber();
        if (subscriberList.isEmpty()) {
            return null;
        }

        PageInfo pageInfo = new PageInfo(subscriberList);
        List<SubscriberListDTO> subscriberListDTOList = new ArrayList<>(subscriberList.size());
        for (Subscriber subscriber : subscriberList) {
            subscriberListDTOList.add(SubscriberListDTO.toSubscriberListDTO(subscriber));
        }

        return PageList.create(subscriberListDTOList, pageInfo);
    }

    @Override
    public List<SendEmail.Subscriber> listSendMailSubscriber(Integer articleId) {
        List<Subscriber> subscriberList = subscriberMapper.listSendMailSubscriber(articleId);
        if (subscriberList.isEmpty()) {
            return null;
        }

        List<SendEmail.Subscriber> sendEmailSubscriberList = new ArrayList<>(subscriberList.size());
        for (Subscriber subscriber : subscriberList) {
            sendEmailSubscriberList.add(new SendEmail.Subscriber(subscriber.getId(), subscriber.getEmail()));
        }

        return sendEmailSubscriberList;
    }

    @Override
    public Integer getTotalByStatus(SubscribeStatus subscribeStatus) {
        Integer total = subscriberMapper.getTotalByStatus(subscribeStatus.getStatus());
        return total == null ? 0 : total;
    }
}
