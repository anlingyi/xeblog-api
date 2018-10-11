package cn.xeblog.xeblogapi.dao;

import cn.xeblog.xeblogapi.domain.model.Category;

import java.util.List;

/**
 * 文章分类
 *
 * @author yanpanyi
 * @date 2018/10/11
 */
public interface CategoryMapper {

    /**
     * 分类列表
     *
     * @return
     * @throws Exception
     */
    List<Category> listCategory() throws Exception;
}
