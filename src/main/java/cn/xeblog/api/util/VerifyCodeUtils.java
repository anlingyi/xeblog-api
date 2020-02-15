package cn.xeblog.api.util;

import cn.xeblog.api.constant.CommonConstant;

import java.util.Random;

/**
 * 验证码生成
 *
 * @author anlingyi
 * @date 2020/2/15
 */
public class VerifyCodeUtils {

    /**
     * 生成随机验证码
     *
     * @return
     */
    public static String generate() {
        String str = "";
        Random random = new Random();
        for (int i = 0; i < CommonConstant.VERIFY_CODE_LENGTH; i++) {
            str += random.nextInt(10);
        }
        return str;
    }
}
