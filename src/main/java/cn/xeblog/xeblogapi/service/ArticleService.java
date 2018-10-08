package cn.xeblog.xeblogapi.service;

import cn.xeblog.xeblogapi.domain.bo.ArticleDetailsBO;
import cn.xeblog.xeblogapi.domain.bo.PageList;
import cn.xeblog.xeblogapi.domain.request.QueryArticle;

/**
 * @author yanpanyi
 * @date 2018/10/3
 */
public interface ArticleService {

    /**
     * 获取公开文章总数
     *
     * @return
     * @throws Exception
     */
    Integer getCount() throws Exception;

    /**
     * 文章列表
     *
     * @param queryArticle
     * @return
     * @throws Exception
     */
    PageList listArticle(QueryArticle queryArticle) throws Exception;

    /**
     * 获取文章详情
     *
     * @param id
     * @return
     * @throws Exception
     */
    ArticleDetailsBO getArticleDetails(Integer id) throws Exception;

    /**
     * 增加浏览量
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean addPageviews(Integer id) throws Exception;

}
