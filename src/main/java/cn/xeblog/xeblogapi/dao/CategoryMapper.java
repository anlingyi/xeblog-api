package cn.xeblog.xeblogapi.dao;

import cn.xeblog.xeblogapi.domain.model.Category;
import org.apache.ibatis.annotations.Param;

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
     * @return
     * @throws Exception
     */
    List<Category> listCategoryAdmin() throws Exception;

    /**
     * 添加分类
     *
     * @param name
     * @return
     * @throws Exception
     */
    Integer addCategory(String name) throws Exception;

    /**
     * 通过id删除分类
     *
     * @param id
     * @return
     * @throws Exception
     */
    Integer deleteCategoryById(Integer id) throws Exception;

    /**
     * 通过id更新分类
     *
     * @param id
     * @param name
     * @return
     * @throws Exception
     */
    Integer updateCategoryById(@Param("id") Integer id, @Param("name") String name) throws Exception;
}
