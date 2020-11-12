package cn.xeblog.api.controller;

import cn.xeblog.api.cache.CacheService;
import cn.xeblog.api.constant.CommonConstant;
import cn.xeblog.api.domain.bo.VerifyCode;
import cn.xeblog.api.domain.model.Subscriber;
import cn.xeblog.api.enums.Code;
import cn.xeblog.api.enums.SubscribeStatus;
import cn.xeblog.api.service.EmailService;
import cn.xeblog.api.service.SubscriberService;
import cn.xeblog.api.util.CheckUtils;
import cn.xeblog.api.util.Response;
import cn.xeblog.api.util.VerifyCodeUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author anlingyi
 * @date 2020/2/15
 */
@Api(tags = "订阅")
@RestController
@RequestMapping("/api/subscribe")
public class SubscriberController {

    @Resource
    private SubscriberService subscriberService;
    @Resource(name = "verifyCodeCacheServiceImpl")
    private CacheService<String, VerifyCode> cacheService;
    @Resource
    private EmailService emailService;

    /**
     * 订阅
     *
     * @param email
     * @param code
     * @return
     */
    @ApiOperation(value = "订阅")
    @PostMapping()
    public Response subscribe(String email, String code) {
        CheckUtils.checkEmail(email);
        CheckUtils.checkVerifyCode(code);

        String key = getVerifyCodeKey(email);
        VerifyCode verifyCode = cacheService.get(key);
        if (verifyCode == null) {
            // 请发送验证邮件
            return Response.failed(Code.PLEASE_SEND_VERIFICATION_EMAIL);
        }
        if (System.currentTimeMillis() > verifyCode.getExpireDate()) {
            // 验证码已过期
            return Response.failed(Code.VERIFICATION_CODE_HAS_EXPIRED);
        }
        if (!code.equals(verifyCode.getCode())) {
            // 验证码不正确
            return Response.failed(Code.INCORRECT_VERIFICATION_CODE);
        }

        // 移除验证码
        cacheService.remove(key);
        Subscriber subscriber = subscriberService.getSubscriberByEmail(email);
        if (null == subscriber) {
            // 添加订阅者
            return Response.what(subscriberService.addSubscriber(email, SubscribeStatus.SUBSCRIBED));
        }

        if (SubscribeStatus.SUBSCRIBED.getStatus() == subscriber.getStatus()) {
            // 该邮箱已订阅
            return Response.failed(Code.THIS_EMAIL_IS_SUBSCRIBED);
        }

        // 更新订阅者状态为已订阅
        return Response.what(subscriberService.updateSubscriberStatus(subscriber.getId(), SubscribeStatus.SUBSCRIBED));
    }

    /**
     * 发送验证码到邮箱
     *
     * @param email
     * @return
     */
    @ApiOperation(value = "发送验证码到邮箱")
    @GetMapping("/sendVerifyCode")
    public Response sendVerifyCode(String email) {
        CheckUtils.checkEmail(email);
        String key = getVerifyCodeKey(email);
        VerifyCode verifyCode = cacheService.get(key);
        if (verifyCode != null && System.currentTimeMillis() - CommonConstant.SEND_VERIFICATION_CODE_INTERVAL_TIME < verifyCode.getCreateTime()) {
            // 操作频繁
            return Response.failed(Code.FREQUENT_OPERATIONS);
        }

        Subscriber subscriber = subscriberService.getSubscriberByEmail(email);
        boolean exist = subscriber != null;
        if (exist && SubscribeStatus.SUBSCRIBED.getStatus() == subscriber.getStatus()) {
            // 该邮箱已订阅
            return Response.failed(Code.THIS_EMAIL_IS_SUBSCRIBED);
        }

        String code = VerifyCodeUtils.generate();
        // 缓存验证码
        cacheService.add(key, new VerifyCode(code));
        // 发送验证码
        emailService.sendVerifyCodeMail(email, code);

        if (!exist) {
            // 添加订阅用户，状态为未验证
            subscriberService.addSubscriber(email);
        }

        return Response.ok();
    }

    private static final String VERIFY_CODE_KEY_PREFIX = "verify_code_";

    private static String getVerifyCodeKey(String email) {
        return VERIFY_CODE_KEY_PREFIX + email;
    }
}
