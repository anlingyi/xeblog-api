package cn.xeblog.xeblogapi.service.impl;

import cn.xeblog.xeblogapi.dao.ArticleMapper;
import cn.xeblog.xeblogapi.service.ArticleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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
}
