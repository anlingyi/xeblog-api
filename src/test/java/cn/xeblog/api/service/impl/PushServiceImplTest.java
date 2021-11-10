package cn.xeblog.api.service.impl;

import cn.xeblog.api.service.PushService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * @author anlingyi
 * @date 2020/3/17
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Ignore
public class PushServiceImplTest {

    @Resource
    private PushService pushService;

    @Test
    public void pushArticle() {
        pushService.pushArticle(20);
    }

    @Test
    public void articlePushStatistics() {
        System.out.println(pushService.articlePushStatistics(5));
        System.out.println(pushService.articlePushStatistics(6));
        System.out.println(pushService.articlePushStatistics(7));
    }
}
