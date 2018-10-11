package cn.xeblog.xeblogapi.service;

import cn.xeblog.xeblogapi.domain.dto.CategoryDTO;

import java.util.List;

/**
 * 分类
 *
 * @author yanpanyi
 * @date 2018/10/11
 */
public interface CategoryService {

    /**
     * 分类列表
     *
     * @return
     * @throws Exception
     */
    List<CategoryDTO> listCategory() throws Exception;

}
