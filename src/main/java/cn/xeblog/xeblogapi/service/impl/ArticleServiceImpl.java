package cn.xeblog.xeblogapi.service.impl;

import cn.xeblog.xeblogapi.dao.ArticleMapper;
import cn.xeblog.xeblogapi.domain.bo.ArticleDetailsBO;
import cn.xeblog.xeblogapi.domain.bo.PageList;
import cn.xeblog.xeblogapi.domain.dto.ArticleDTO;
import cn.xeblog.xeblogapi.domain.dto.ArticleDetailsDTO;
import cn.xeblog.xeblogapi.domain.dto.ArticleNavDTO;
import cn.xeblog.xeblogapi.domain.model.Article;
import cn.xeblog.xeblogapi.domain.request.QueryArticle;
import cn.xeblog.xeblogapi.service.ArticleService;
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

}
