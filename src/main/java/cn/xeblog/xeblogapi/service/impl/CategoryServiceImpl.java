package cn.xeblog.xeblogapi.service.impl;

import cn.xeblog.xeblogapi.dao.CategoryMapper;
import cn.xeblog.xeblogapi.domain.dto.CategoryDTO;
import cn.xeblog.xeblogapi.domain.model.Category;
import cn.xeblog.xeblogapi.service.CategoryService;
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
}
