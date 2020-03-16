package cn.xeblog.api.domain.dto.admin;

import cn.xeblog.api.constant.DateFormatConstant;
import cn.xeblog.api.domain.model.Subscriber;
import lombok.Data;
import org.apache.commons.lang3.time.DateFormatUtils;

/**
 * 订阅者列表
 *
 * @author anlingyi
 * @date 2020/2/13
 */
@Data
public class SubscriberListDTO {

    /**
     * 主键
     */
    private Integer id;
    /**
     * 邮箱账号
     */
    private String email;
    /**
     * 订阅状态，0未验证 1已订阅 2.未订阅/取消订阅
     */
    private Integer status;
    /**
     * 订阅时间
     */
    private String subscribeTime;

    public static SubscriberListDTO toSubscriberListDTO(Subscriber subscriber) {
        if (null == subscriber) {
            return null;
        }

        SubscriberListDTO subscriberListDTO = new SubscriberListDTO();
        subscriberListDTO.setId(subscriber.getId());
        subscriberListDTO.setEmail(subscriber.getEmail());
        subscriberListDTO.setStatus(subscriber.getStatus());
        subscriberListDTO.setSubscribeTime(DateFormatUtils.format(subscriber.getCreateTime(), DateFormatConstant.NORMAL));

        return subscriberListDTO;
    }
}
