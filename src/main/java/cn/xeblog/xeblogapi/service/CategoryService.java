package cn.xeblog.xeblogapi.service;

import cn.xeblog.xeblogapi.domain.bo.PageList;
import cn.xeblog.xeblogapi.domain.dto.CategoryDTO;
import cn.xeblog.xeblogapi.domain.request.Pagination;

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

    /**
     * 获取分类数量
     *
     * @return
     * @throws Exception
     */
    Integer getCategoryCount() throws Exception;

    /**
     * 分类列表cms
     *
     * @param pagination
     * @return
     * @throws Exception
     */
    PageList listCategoryAdmin(Pagination pagination) throws Exception;

    /**
     * 添加分类
     *
     * @param name
     * @return
     * @throws Exception
     */
    boolean addCategory(String name) throws Exception;

    /**
     * 删除分类
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteCategoryById(Integer id) throws Exception;

    /**
     * 更新分类
     *
     * @param id
     * @param name
     * @return
     * @throws Exception
     */
    boolean updateCategoryById(Integer id, String name) throws Exception;
}
