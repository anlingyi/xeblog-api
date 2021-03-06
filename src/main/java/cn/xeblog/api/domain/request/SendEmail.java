package cn.xeblog.api.domain.request;

import cn.xeblog.api.domain.model.Article;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 发送邮件请求
 *
 * @author anlingyi
 * @date 2020/2/13
 */
@Data
public class SendEmail {

    /**
     * 文章
     */
    private Article article;
    /**
     * 订阅者列表
     */
    private List<Subscriber> subscriberList;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Subscriber {

        /**
         * 订阅者id
         */
        private Integer id;
        /**
         * 订阅者邮箱
         */
        private String email;
    }
}
