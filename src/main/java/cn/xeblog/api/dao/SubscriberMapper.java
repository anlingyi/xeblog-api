package cn.xeblog.api.dao;

import cn.xeblog.api.domain.model.Subscriber;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author anlingyi
 * @date 2020/2/15
 */
public interface SubscriberMapper {


    /**
     * 添加订阅者
     *
     * @param email
     * @param uid
     * @param status
     * @return
     */
    Integer addSubscriber(@Param("email") String email, @Param("uid") String uid, @Param("status") int status);

    /**
     * 添加订阅者
     *
     * @param email
     * @param uid
     * @return
     */
    default Integer addSubscriber(String email, String uid) {
        return addSubscriber(email, uid, 0);
    }

    /**
     * 更新订阅者订阅状态
     *
     * @param id
     * @param status
     * @return
     */
    Integer updateSubscriberStatus(@Param("id") Integer id, @Param("status") Integer status);

    /**
     * 通过UUID获取订阅用户
     *
     * @param uid
     * @return
     */
    Subscriber getSubscriberByUid(String uid);

    /**
     * 通过status获取订阅用户
     *
     * @param status
     * @return
     */
    List<Subscriber> listSubscriberByStatus(Integer status);

    /**
     * 通过email获取订阅用户
     *
     * @param email
     * @return
     */
    Subscriber getSubscriberByEmail(String email);

}
