package cn.xeblog.api.service.impl;

import cn.xeblog.api.domain.model.Article;
import cn.xeblog.api.domain.request.SendEmail;
import cn.xeblog.api.enums.Code;
import cn.xeblog.api.exception.ErrorCodeException;
import cn.xeblog.api.service.CallBackService;
import cn.xeblog.api.service.EmailSendStatusService;
import cn.xeblog.api.service.EmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.ITemplateEngine;
import org.thymeleaf.context.Context;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * @author anlingyi
 * @date 2020/2/13
 */
@Service
@Slf4j
public class EmailServiceImpl implements EmailService {

    @Resource
    private JavaMailSender javaMailSender;
    @Resource
    private ITemplateEngine templateEngine;
    @Resource
    private EmailSendStatusService emailSendStatusService;

    private static final String MAIL_FROM = "xeblog@foxmail.com";

    private static final String SUBJECT_PREFIX = "小毅博客：";

    @Async
    @Override
    public void sendArticleEmail(SendEmail sendEmail, CallBackService callBackService) {
        try {
            log.info("待推送人数：{}", sendEmail.getSubscriberList().size());
            Article article = sendEmail.getArticle();

            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
            mimeMessageHelper.setFrom(MAIL_FROM);
            mimeMessageHelper.setSubject(SUBJECT_PREFIX + article.getTitle());

            Context context = new Context();
            context.setVariable("articleId", article.getId());
            context.setVariable("articleTitle", article.getTitle());
            context.setVariable("articleBrief", article.getBrief());
            context.setVariable("articleCover", article.getCover());
            String template = templateEngine.process("articleEmail", context);
            mimeMessageHelper.setText(template, true);

            int status;
            for (SendEmail.Subscriber subscriber : sendEmail.getSubscriberList()) {
                mimeMessageHelper.setTo(subscriber.getEmail());

                try {
                    javaMailSender.send(mimeMessage);
                    // 发送成功
                    status = 1;
                    log.info("发送文章推送邮件成功！email -> {}", subscriber.getEmail());
                } catch (Exception e) {
                    // 发送失败
                    status = 2;
                    log.error("发送文章推送邮件失败！email -> {}", subscriber.getEmail(), e);
                }

                // 添加发送状态
                emailSendStatusService.addEmailSendStatus(subscriber.getId(), article.getId(), status);
            }
        } catch (MessagingException e) {
            log.error("发送文章推送邮件失败！", e);
            throw new ErrorCodeException(Code.MAIL_SEND_FAILED);
        } finally {
            // 执行回调方法
            callBackService.exec();
        }
    }

    @Override
    public void sendVerifyCodeMail(String email, String code) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
        try {
            mimeMessageHelper.setFrom(MAIL_FROM);
            mimeMessageHelper.setSubject(SUBJECT_PREFIX + "验证邮件");
            mimeMessageHelper.setTo(email);

            Context context = new Context();
            context.setVariable("verifyCode", code);
            String template = templateEngine.process("verifyCodeEmail", context);
            mimeMessageHelper.setText(template, true);
            javaMailSender.send(mimeMessage);
            log.info("发送验证邮件成功！email -> {}", email);
        } catch (Exception e) {
            log.error("发送验证邮件失败！email -> {}", email, e);
            throw new ErrorCodeException(Code.MAIL_SEND_FAILED);
        }
    }
}
