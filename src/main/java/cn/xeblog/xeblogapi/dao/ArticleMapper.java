package cn.xeblog.xeblogapi.dao;

/**
 * @author yanpanyi
 * @date 2018/10/3
 */
public interface ArticleMapper {

    /**
     * 获取公开文章总数
     *
     * @return
     * @throws Exception
     */
    Integer getCount() throws Exception;
}
