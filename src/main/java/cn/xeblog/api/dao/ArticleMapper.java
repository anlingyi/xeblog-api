package cn.xeblog.api.dao;

import cn.xeblog.api.domain.model.Article;
import cn.xeblog.api.domain.request.AddOrUpdateArticle;
import cn.xeblog.api.domain.request.Pagination;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author yanpanyi
 * @date 2018/10/3
 */
public interface ArticleMapper extends BaseMapper<Article> {

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
     * @param pagination
     * @return
     * @throws Exception
     */
    List<Article> listArticle(@Param("page") Pagination pagination) throws Exception;

    /**
     * 通过id获取文章信息
     *
     * @param id
     * @param isPrivate
     * @return
     * @throws Exception
     */
    Article getArticleById(@Param("id") Integer id, @Param("isPrivate") Integer isPrivate) throws Exception;

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
    List<Article> listTitleAndId() throws Exception;

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

    /**
     * 修改文章
     *
     * @param addOrUpdateArticle
     * @return
     * @throws Exception
     */
    Integer updateArticle(@Param("update") AddOrUpdateArticle addOrUpdateArticle) throws Exception;

    /**
     * 删除文章
     *
     * @param id
     * @return
     * @throws Exception
     */
    Integer deleteArticle(Integer id) throws Exception;

    /**
     * 文章列表cms
     *
     * @return
     * @throws Exception
     */
    List<Article> listArticleAdmin() throws Exception;

    /**
     * 获取文章详情cms
     *
     * @param id
     * @return
     * @throws Exception
     */
    Article getAdminArticleById(Integer id) throws Exception;

    /**
     * 获取文章信息
     *
     * @param id
     * @return
     * @throws Exception
     */
    Article getArticle(@Param("id") Integer id);

    Integer randomArticle();

    int getWordCountTotal();

}
