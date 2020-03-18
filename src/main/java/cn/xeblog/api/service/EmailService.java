package cn.xeblog.api.service;

import cn.xeblog.api.domain.request.SendEmail;

/**
 * 邮件服务
 *
 * @author anlingyi
 * @date 2020/2/13
 */
public interface EmailService {

    /**
     * 发送文章邮件
     *
     * @param sendEmail
     * @param callBackService
     */
    void sendArticleEmail(SendEmail sendEmail, CallBackService callBackService);

    /**
     * 发送验证码邮件
     *
     * @param email 邮箱账号
     * @param code  验证码
     */
    void sendVerifyCodeMail(String email, String code);
}
