package cn.xeblog.api.domain.model;

import cn.xeblog.api.constant.CommonConstant;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 验证码
 *
 * @author anlingyi
 * @date 2020/2/15
 */
@Data
@NoArgsConstructor
public class VerifyCode {

    /**
     * 验证码
     */
    private String code;
    /**
     * 过期时间
     */
    private long expireDate;
    /**
     * 创建时间
     */
    private long createTime;

    public VerifyCode(String code) {
        this.code = code;
        this.createTime = System.currentTimeMillis();
        this.expireDate = this.createTime + CommonConstant.VERIFICATION_CODE_EXPIRATION_TIME;
    }

}
