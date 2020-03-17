package cn.xeblog.api.service;

import cn.xeblog.api.domain.bo.ArticlePushStatistics;

/**
 * @author anlingyi
 * @date 2020/3/17
 */
public interface PushService {

    /**
     * 推送文章
     *
     * @param articleId
     */
    void pushArticle(Integer articleId);

    /**
     * 文章推送统计
     *
     * @param articleId
     * @return
     */
    ArticlePushStatistics articlePushStatistics(Integer articleId);
}
