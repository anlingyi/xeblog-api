package cn.xeblog.api.service.impl;

import cn.xeblog.api.dao.ArticleMapper;
import cn.xeblog.api.domain.bo.ArticleDetailsBO;
import cn.xeblog.api.domain.bo.PageList;
import cn.xeblog.api.domain.dto.*;
import cn.xeblog.api.domain.dto.admin.ArticleAdminDTO;
import cn.xeblog.api.domain.model.Article;
import cn.xeblog.api.domain.request.AddOrUpdateArticle;
import cn.xeblog.api.domain.request.Pagination;
import cn.xeblog.api.domain.request.QueryArticle;
import cn.xeblog.api.service.ArticleService;
import cn.xeblog.api.service.TagService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Resource
    private TagService tagService;

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
        ArticleDetailsDTO articleDetailsDTO = ArticleDetailsDTO.toArticleDetailsDTO(this.articleMapper
                .getArticleById(id, 0));

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

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean addArticle(AddOrUpdateArticle addOrUpdateArticle) throws Exception {
        this.addTags(addOrUpdateArticle.getTag());
        return 1 == this.articleMapper.addArticle(addOrUpdateArticle);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateArticle(AddOrUpdateArticle addOrUpdateArticle) throws Exception {
        this.addTags(addOrUpdateArticle.getTag());
        return 1 == this.articleMapper.updateArticle(addOrUpdateArticle);
    }

    @Override
    public boolean deleteArticle(Integer id) throws Exception {
        return 1 == this.articleMapper.deleteArticle(id);
    }

    /**
     * 添加标签，标签以,分割
     *
     * @param tags
     * @throws Exception
     */
    private void addTags(String tags) throws Exception {
        if (StringUtils.isEmpty(tags)) {
            return;
        }

        // 如果标签不为空则添加标签到标签表
        String[] strings = tags.split(",");

        for (String str : strings) {
            this.tagService.addTag(str);
        }
    }

    @Override
    public PageList listArticleAdmin(Pagination pagination) throws Exception {
        PageHelper.startPage(pagination.getPageIndex(), pagination.getPageSize());
        List<Article> articleList = articleMapper.listArticleAdmin();

        if (articleList.isEmpty()) {
            return null;
        }

        PageInfo pageInfo = new PageInfo(articleList);

        List<ArticleAdminDTO> articleAdminDTOList = new ArrayList<>(articleList.size());
        for (Article article : articleList) {
            articleAdminDTOList.add(ArticleAdminDTO.toArticleAdminDTO(article));
        }

        return new PageList(articleAdminDTOList, pageInfo.getPageNum(), pageInfo.getPages(), pageInfo.getTotal());
    }

    @Override
    public ArticleDetailsDTO previewArticle(Integer id) throws Exception {
        return ArticleDetailsDTO.toArticleDetailsDTO(this.articleMapper.getArticleById(id, null));
    }
}
