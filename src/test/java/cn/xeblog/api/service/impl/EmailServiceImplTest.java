package cn.xeblog.api.service.impl;

import cn.xeblog.api.dao.ArticleMapper;
import cn.xeblog.api.domain.request.SendEmail;
import cn.xeblog.api.service.EmailService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author anlingyi
 * @date 2020/2/13
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Ignore
public class EmailServiceImplTest {

    @Resource
    private EmailService emailService;
    @Resource
    private ArticleMapper articleMapper;

    @Test
    public void sendArticleEmail() throws Exception {
        SendEmail sendEmail = new SendEmail();
        sendEmail.setArticle(articleMapper.getArticleById(29, null));
        List<SendEmail.Subscriber> subscriberList = new ArrayList<>();
        subscriberList.add(new SendEmail.Subscriber(1, "1090172196@qq.com"));
        sendEmail.setSubscriberList(subscriberList);
        emailService.sendArticleEmail(sendEmail);
    }

    @Test
    public void sendVerifyCodeMail() {
        emailService.sendVerifyCodeMail("1090172196@qq.com", "12138");
    }
}