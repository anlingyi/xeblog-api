package cn.xeblog.xeblogapi.dao;

import cn.xeblog.xeblogapi.domain.model.Article;

import java.util.List;

/**
 * @author yanpanyi
 * @date 2018/10/3
 */
public interface ArticleMapper {

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
     * @return
     * @throws Exception
     */
    List<Article> listArticle() throws Exception;

    /**
     * 通过id获取文章信息
     *
     * @param id
     * @return
     * @throws Exception
     */
    Article getArticleById(Integer id) throws Exception;

    /**
     * 增加浏览量
     *
     * @param id
     * @return
     * @throws Exception
     */
    Integer addPageviews(Integer id) throws Exception;

}
