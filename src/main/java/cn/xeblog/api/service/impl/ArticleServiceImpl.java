package cn.xeblog.api.service.impl;

import cn.xeblog.api.dao.ArticleMapper;
import cn.xeblog.api.domain.bo.ArticleDetailsBO;
import cn.xeblog.api.domain.bo.PageList;
import cn.xeblog.api.domain.dto.*;
import cn.xeblog.api.domain.model.Article;
import cn.xeblog.api.domain.request.Pagination;
import cn.xeblog.api.domain.request.QueryArticle;
import cn.xeblog.api.service.ArticleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yanpanyi
 * @date 2018/10/3
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Resource
    private ArticleMapper articleMapper;

    @Override
    public Integer getCount() throws Exception {
        return this.articleMapper.getCount();
    }

    @Override
    public PageList listArticle(QueryArticle queryArticle) throws Exception {
        PageHelper.startPage(queryArticle.getPageIndex(), queryArticle.getPageSize());
        List<Article> articleList = this.articleMapper.listArticle(queryArticle);

        if (articleList.isEmpty()) {
            return null;
        }

        PageInfo pageInfo = new PageInfo(articleList);

        List<ArticleDTO> articleDTOList = new ArrayList<>(articleList.size());
        for (Article article : articleList) {
            articleDTOList.add(ArticleDTO.toArticleDTO(article));
        }

        return new PageList(articleDTOList, pageInfo.getPageNum(), pageInfo.getPages());
    }

    @Override
    public ArticleDetailsBO getArticleDetails(Integer id) throws Exception {
        // 文章详情
        ArticleDetailsDTO articleDetailsDTO = ArticleDetailsDTO.toArticleDetailsDTO(this.articleMapper.getArticleById(id));

        List<Article> articleList = articleMapper.listTitileAndId();
        // 上一篇
        ArticleNavDTO previous = null;
        // 下一篇
        ArticleNavDTO next = null;
        int len = articleList.size();

        for (int i = 0; i < len; i++) {
            if (id.equals(articleList.get(i).getId())) {
                if (i > 0) {
                    // 获取上一篇文章
                    previous = ArticleNavDTO.toArticleNavDTO(articleList.get(i - 1));
                }
                if (i < len - 1) {
                    // 获取下一篇文章
                    next = ArticleNavDTO.toArticleNavDTO(articleList.get(i + 1));
                }

                break;
            }
        }

        return new ArticleDetailsBO(articleDetailsDTO, previous, next);
    }

    @Override
    public boolean addPageviews(Integer id) throws Exception {
        return 1 == this.articleMapper.addPageviews(id);
    }

    @Override
    public PageList listArchives(Pagination pagination) throws Exception {
        PageHelper.startPage(pagination.getPageIndex(), pagination.getPageSize());
        List<Article> articleList = articleMapper.listArchives();

        if (articleList.isEmpty()) {
            return null;
        }

        PageInfo pageInfo = new PageInfo(articleList);

        List<ArticleArchivesDTO> articleArchivesDTOList = new ArrayList<>(articleList.size());
        for (Article article : articleList) {
            articleArchivesDTOList.add(ArticleArchivesDTO.toArticleArchivesDTO(article));
        }

        return new PageList(articleArchivesDTOList, pageInfo.getPageNum(), pageInfo.getPages());
    }
}
