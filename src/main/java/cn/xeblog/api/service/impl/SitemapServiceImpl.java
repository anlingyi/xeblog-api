package cn.xeblog.api.service.impl;

import cn.xeblog.api.domain.bo.SitemapBO;
import cn.xeblog.api.domain.model.Article;
import cn.xeblog.api.domain.request.UpdateSitemapConfig;
import cn.xeblog.api.service.ArticleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.xeblog.api.dao.SitemapMapper;
import cn.xeblog.api.domain.model.Sitemap;
import cn.xeblog.api.service.SitemapService;
import com.thoughtworks.xstream.XStream;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 站点地图(Sitemap)表服务实现类
 *
 * @author anlingyi
 * @since 2022-04-09 16:08:34
 */
@Service("sitemapService")
public class SitemapServiceImpl extends ServiceImpl<SitemapMapper, Sitemap> implements SitemapService {

    @Resource
    private ArticleService articleService;

    @Override
    public boolean updateConfig(UpdateSitemapConfig updateSitemapConfig) {
        Sitemap origin = super.lambdaQuery().last("limit 1").one();
        Sitemap sitemap = new Sitemap();
        sitemap.setDomain(updateSitemapConfig.getDomain());
        sitemap.setOutPath(updateSitemapConfig.getOutPath());
        if (origin == null) {
            return super.save(sitemap);
        }

        sitemap.setId(origin.getId());
        return super.updateById(sitemap);
    }

    @Override
    public boolean generate() {
        Sitemap sitemap = super.lambdaQuery().last("limit 1").one();
        if (sitemap == null) {
            return false;
        }

        List<Article> articleList = articleService.lambdaQuery()
                .eq(Article::getDeleteFlag, 0)
                .eq(Article::getIsPrivate, 0)
                .orderByDesc(Article::getUpdateTime)
                .list();
        if (articleList == null || articleList.isEmpty()) {
            return false;
        }

        XStream xStream = new XStream();
        xStream.processAnnotations(SitemapBO.class);
        SitemapBO sitemapBO = new SitemapBO();
        articleList.forEach(article -> {
            SitemapBO.Url url = new SitemapBO.Url();
            url.setChangefreq("daily");
            url.setLastmod(DateFormatUtils.format(article.getUpdateTime(), "yyyy-MM-dd"));
            url.setPriority("0.8");
            url.setLoc(sitemap.getDomain() + "/articles/" + article.getId());
            sitemapBO.addUrl(url);
        });

        String xml = xStream.toXML(sitemapBO);
        String filePath = sitemap.getOutPath() + "/sitemap.xml";
        try (BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(filePath))) {
            outputStream.write(xml.getBytes(StandardCharsets.UTF_8));
            Sitemap up = new Sitemap();
            up.setId(sitemap.getId());
            up.setLastUpdate(LocalDateTime.now());
            super.updateById(up);
            return true;
        } catch (Exception e) {
            log.error("生成站点地图异常", e);
        }

        return false;
    }

}

