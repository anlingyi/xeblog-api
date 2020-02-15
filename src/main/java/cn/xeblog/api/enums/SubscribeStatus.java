package cn.xeblog.api.enums;

/**
 * 订阅状态
 *
 * @author anlingyi
 * @date 2020/2/15
 */
public enum SubscribeStatus {

    /**
     * 未订阅
     */
    NOT_SUBSCRIBED(2),
    /**
     * 已订阅
     */
    SUBSCRIBED(1),
    /**
     * 未验证
     */
    UNVERIFIED(0);

    int status;

    SubscribeStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }
}
