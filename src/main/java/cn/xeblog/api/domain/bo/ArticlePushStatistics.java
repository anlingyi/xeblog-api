package cn.xeblog.api.domain.bo;

import lombok.Data;

/**
 * 文章推送统计
 *
 * @author anlingyi
 * @date 2020/3/17
 */
@Data
public class ArticlePushStatistics {

    private Integer articleId;
    private Integer successTotal;
    private Integer total;
    private Integer failTotal;
}
