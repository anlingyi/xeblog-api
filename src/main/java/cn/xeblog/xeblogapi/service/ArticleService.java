package cn.xeblog.xeblogapi.service;

import cn.xeblog.xeblogapi.domain.bo.PageList;
import cn.xeblog.xeblogapi.domain.dto.ArticleDTO;
import cn.xeblog.xeblogapi.domain.request.Pagination;

import java.util.List;

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
     * @return
     * @throws Exception
     */
    PageList listArticle(Pagination pagination) throws Exception;
}
