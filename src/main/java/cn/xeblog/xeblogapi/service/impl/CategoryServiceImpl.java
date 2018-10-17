package cn.xeblog.xeblogapi.service.impl;

import cn.xeblog.xeblogapi.dao.CategoryMapper;
import cn.xeblog.xeblogapi.domain.bo.PageList;
import cn.xeblog.xeblogapi.domain.dto.CategoryDTO;
import cn.xeblog.xeblogapi.domain.dto.admin.CategoryAdminDTO;
import cn.xeblog.xeblogapi.domain.model.Category;
import cn.xeblog.xeblogapi.domain.request.Pagination;
import cn.xeblog.xeblogapi.service.CategoryService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yanpanyi
 * @date 2018/10/11
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Resource
    private CategoryMapper categoryMapper;

    @Override
    public List<CategoryDTO> listCategory() throws Exception {
        List<Category> categoryList = this.categoryMapper.listCategory();
        if (categoryList.isEmpty()) {
            return null;
        }

        List<CategoryDTO> categoryDTOList = new ArrayList<>(categoryList.size());
        for (Category category : categoryList) {
            categoryDTOList.add(CategoryDTO.toCategoryDTO(category));
        }

        return categoryDTOList;
    }

    @Override
    public Integer getCategoryCount() throws Exception {
        return this.categoryMapper.getCategoryCount();
    }

    @Override
    public PageList listCategoryAdmin(Pagination pagination) throws Exception {
        PageHelper.startPage(pagination.getPageIndex(), pagination.getPageSize());
        List<Category> categoryList = this.categoryMapper.listCategoryAdmin();

        if (categoryList.isEmpty()) {
            return null;
        }

        PageInfo pageInfo = new PageInfo(categoryList);
        List<CategoryAdminDTO> categoryAdminDTOList = new ArrayList<>(categoryList.size());
        for (Category category : categoryList) {
            categoryAdminDTOList.add(CategoryAdminDTO.toCategoryAdminDTO(category));
        }

        return new PageList(categoryAdminDTOList, pageInfo.getPageNum(), pageInfo.getPages());
    }

    @Override
    public boolean addCategory(String name) throws Exception {
        return 1 == this.categoryMapper.addCategory(name);
    }

    @Override
    public boolean deleteCategoryById(Integer id) throws Exception {
        return 1 == this.categoryMapper.deleteCategoryById(id);
    }

    @Override
    public boolean updateCategoryById(Integer id, String name) throws Exception {
        return 1 == this.categoryMapper.updateCategoryById(id, name);
    }
}
