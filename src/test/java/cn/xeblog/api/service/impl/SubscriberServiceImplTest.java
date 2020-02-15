package cn.xeblog.api.service.impl;

import cn.xeblog.api.service.SubscriberService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * @author anlingyi
 * @date 2020/2/15
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SubscriberServiceImplTest {

    @Resource
    private SubscriberService subscriberService;

    @Test
    public void isSubscribed() {
        assertTrue(subscriberService.isSubscribed("1090172196@qq.com"));
    }

    @Test
    public void addSubscriber() {
        assertTrue(subscriberService.addSubscriber("1090172196@qq.com"));
    }
}