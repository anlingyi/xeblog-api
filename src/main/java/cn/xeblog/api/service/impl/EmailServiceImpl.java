package cn.xeblog.api.service.impl;

import cn.xeblog.api.domain.model.Article;
import cn.xeblog.api.domain.request.SendEmail;
import cn.xeblog.api.enums.Code;
import cn.xeblog.api.exception.ErrorCodeException;
import cn.xeblog.api.service.EmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
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

    private static final String MAIL_FROM = "xeblog@foxmail.com";

    private static final String SUBJECT_PREFIX = "小毅博客：";

    @Override
    public void sendArticleEmail(SendEmail sendEmail) {
        Article article = sendEmail.getArticle();
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
        try {
            mimeMessageHelper.setFrom(MAIL_FROM);
            mimeMessageHelper.setSubject(SUBJECT_PREFIX + article.getTitle());

            Context context = new Context();
            context.setVariable("articleId", article.getId());
            context.setVariable("articleTitle", article.getTitle());
            String template = templateEngine.process("articleEmail", context);
            mimeMessageHelper.setText(template, true);

            for (SendEmail.Subscriber subscriber : sendEmail.getSubscriberList()) {
                mimeMessageHelper.setTo(subscriber.getEmail());
                try {
                    javaMailSender.send(mimeMessage);
                } catch (Exception e) {
                    log.error("发送文章推送邮件失败！email -> {}", subscriber.getEmail(), e);
                }
            }
        } catch (MessagingException e) {
            log.error("发送文章推送邮件失败！", e);
            throw new ErrorCodeException(Code.MAIL_SEND_FAILED);
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
        } catch (Exception e) {
            log.error("发送验证邮件失败！", e);
            throw new ErrorCodeException(Code.MAIL_SEND_FAILED);
        }
    }
}
