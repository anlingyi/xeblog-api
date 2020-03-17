package cn.xeblog.api.service.impl;

import cn.xeblog.api.domain.bo.ArticlePushStatistics;
import cn.xeblog.api.domain.model.Article;
import cn.xeblog.api.domain.request.SendEmail;
import cn.xeblog.api.enums.Code;
import cn.xeblog.api.enums.SubscribeStatus;
import cn.xeblog.api.service.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.util.List;

import static cn.xeblog.api.util.CheckUtils.error;

/**
 * @author anlingyi
 * @date 2020/3/17
 */
@Service
public class PushServiceImpl implements PushService {

    @Resource
    private SubscriberService subscriberService;
    @Resource
    private ArticleService articleService;
    @Resource
    private EmailService emailService;
    @Resource
    private EmailSendStatusService emailSendStatusService;

    @Override
    public void pushArticle(Integer articleId) {
        Article article = articleService.getArticleById(articleId);
        if (article == null) {
            error(Code.ARTICLE_DOES_NOT_EXIST);
        }
        if (article.getIsPrivate() == 1) {
            error(Code.ARTICLE_NOT_PUBLIC);
        }

        List<SendEmail.Subscriber> subscriberList = subscriberService.listSendMailSubscriber(articleId);
        if (subscriberList == null) {
            error(Code.NO_SUBSCRIBER_NEED_TO_PUSH);
        }

        SendEmail sendEmail = new SendEmail();
        sendEmail.setArticle(article);
        sendEmail.setSubscriberList(subscriberList);

        emailService.sendArticleEmail(sendEmail);
    }

    @Override
    public ArticlePushStatistics articlePushStatistics(Integer articleId) {
        int successTotal = 0;
        int failTotal = 0;
        List<Integer> sendStatusList = emailSendStatusService.listSendStatusByArticleId(articleId);
        if (!sendStatusList.isEmpty()) {
            for (Integer status : sendStatusList) {
                switch (status) {
                    case 1:
                        successTotal++;
                        break;
                    case 2:
                        failTotal++;
                        break;
                    default:
                        break;
                }
            }
        }

        ArticlePushStatistics articlePushStatistics = new ArticlePushStatistics();
        articlePushStatistics.setArticleId(articleId);
        // 已订阅人数
        articlePushStatistics.setTotal(subscriberService.getTotalByStatus(SubscribeStatus.SUBSCRIBED));
        // 推送成功人数
        articlePushStatistics.setSuccessTotal(successTotal);
        // 推送失败人数
        articlePushStatistics.setFailTotal(failTotal);

        return articlePushStatistics;
    }
}
