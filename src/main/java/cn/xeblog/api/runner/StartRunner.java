package cn.xeblog.api.runner;

import cn.xeblog.api.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author anlingyi
 * @date 2021/11/20 11:47 下午
 */
@Slf4j
@Component
public class StartRunner implements ApplicationRunner {

    @Resource
    private ArticleService articleService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("统计文章字数");
        articleService.statsArticleWordCount();
    }

}
