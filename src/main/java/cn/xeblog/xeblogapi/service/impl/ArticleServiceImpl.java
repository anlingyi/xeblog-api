package cn.xeblog.xeblogapi.service.impl;

import cn.xeblog.xeblogapi.dao.ArticleMapper;
import cn.xeblog.xeblogapi.domain.bo.PageList;
import cn.xeblog.xeblogapi.domain.dto.ArticleDTO;
import cn.xeblog.xeblogapi.domain.model.Article;
import cn.xeblog.xeblogapi.domain.request.Pagination;
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
    public PageList listArticle(Pagination pagination) throws Exception {
        PageHelper.startPage(pagination.getPageIndex(), pagination.getPageSize());
        List<Article> articleList = this.articleMapper.listArticle();

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
}
