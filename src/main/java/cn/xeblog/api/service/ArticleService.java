package cn.xeblog.api.service;

import cn.xeblog.api.domain.bo.ArticleDetailsBO;
import cn.xeblog.api.domain.bo.PageList;
import cn.xeblog.api.domain.dto.ArticleDetailsDTO;
import cn.xeblog.api.domain.dto.RecommendArticleListDTO;
import cn.xeblog.api.domain.dto.admin.AdminArticleDetailsDTO;
import cn.xeblog.api.domain.model.Article;
import cn.xeblog.api.domain.request.*;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author yanpanyi
 * @date 2018/10/3
 */
public interface ArticleService extends IService<Article> {

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

    /**
     * 归档
     *
     * @param pagination
     * @return
     * @throws Exception
     */
    PageList listArchives(Pagination pagination) throws Exception;

    /**
     * 添加文章
     *
     * @param addOrUpdateArticle
     * @return
     * @throws Exception
     */
    boolean addArticle(AddOrUpdateArticle addOrUpdateArticle) throws Exception;

    /**
     * 修改文章
     *
     * @param addOrUpdateArticle
     * @return
     * @throws Exception
     */
    boolean updateArticle(AddOrUpdateArticle addOrUpdateArticle) throws Exception;

    /**
     * 删除文章
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteArticle(Integer id) throws Exception;

    /**
     * 文章列表cms
     *
     * @param pagination
     * @return
     * @throws Exception
     */
    PageList listArticleAdmin(Pagination pagination) throws Exception;

    /**
     * 预览文章
     *
     * @param id
     * @return
     * @throws Exception
     */
    ArticleDetailsDTO previewArticle(Integer id) throws Exception;

    /**
     * 文章详情cms
     *
     * @param id
     * @return
     * @throws Exception
     */
    AdminArticleDetailsDTO getArticleDetailsAdmin(Integer id) throws Exception;

    Article getArticleById(Integer articleId);

    Integer randomArticle();

    /**
     * 统计文章字数
     */
    void statsArticleWordCount();

    int getWordCountTotal();

    /**
     * 设置文章推荐
     *
     * @param setRecommend
     * @return
     */
    boolean setRecommend(SetRecommend setRecommend);

    /**
     * 查询推荐文章列表
     *
     * @return
     */
    List<RecommendArticleListDTO> listRecommend();

    /**
     * 设置文章置顶
     *
     * @param setTop
     * @return
     */
    boolean setTop(SetTop setTop);

    /**
     * 设置文章私有
     *
     * @param setPrivate
     * @return
     */
    boolean setPrivate(SetPrivate setPrivate);

}
