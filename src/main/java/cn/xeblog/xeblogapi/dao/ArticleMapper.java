package cn.xeblog.xeblogapi.dao;

import cn.xeblog.xeblogapi.domain.model.Article;
import cn.xeblog.xeblogapi.domain.request.QueryArticle;
import org.apache.ibatis.annotations.Param;

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
     * @param queryArticle
     * @return
     * @throws Exception
     */
    List<Article> listArticle(@Param("query") QueryArticle queryArticle) throws Exception;

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
