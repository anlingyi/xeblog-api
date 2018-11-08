package cn.xeblog.api.dao;

import cn.xeblog.api.domain.model.Article;
import cn.xeblog.api.domain.request.AddOrUpdateArticle;
import cn.xeblog.api.domain.request.QueryArticle;
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

    /**
     * 获取title和id列表
     *
     * @return
     * @throws Exception
     */
    List<Article> listTitileAndId() throws Exception;

    /**
     * 归档
     *
     * @return
     * @throws Exception
     */
    List<Article> listArchives() throws Exception;

    /**
     * 添加文章
     *
     * @param addOrUpdateArticle
     * @return
     * @throws Exception
     */
    Integer addArticle(@Param("add") AddOrUpdateArticle addOrUpdateArticle) throws Exception;
}
