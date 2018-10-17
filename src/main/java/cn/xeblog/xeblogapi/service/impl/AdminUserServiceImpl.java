package cn.xeblog.xeblogapi.service.impl;

import cn.xeblog.xeblogapi.dao.AdminUserMapper;
import cn.xeblog.xeblogapi.domain.dto.UserInfoDTO;
import cn.xeblog.xeblogapi.domain.dto.admin.AdminUserInfoDTO;
import cn.xeblog.xeblogapi.domain.request.UpdateUserInfo;
import cn.xeblog.xeblogapi.service.AdminUserService;
import cn.xeblog.xeblogapi.service.ArticleService;
import cn.xeblog.xeblogapi.service.CategoryService;
import cn.xeblog.xeblogapi.service.TagService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author yanpanyi
 * @date 2018/10/3
 */
@Service
public class AdminUserServiceImpl implements AdminUserService {

    @Resource
    private AdminUserMapper adminUserMapper;
    @Resource
    private ArticleService articleService;
    @Resource
    private TagService tagService;
    @Resource
    private CategoryService categoryService;

    @Override
    public UserInfoDTO getUserInfo() throws Exception {
        UserInfoDTO userInfoDTO = UserInfoDTO.toUserInfoDTO(this.adminUserMapper.getAdminUser());

        if (null == userInfoDTO) {
            userInfoDTO = new UserInfoDTO();
        }

        // 获取文章数
        userInfoDTO.setArticleCount(this.articleService.getCount());
        // 获取标签数
        userInfoDTO.setTagCount(this.tagService.getCount());
        // 获取分类数
        userInfoDTO.setCategoryCount(this.categoryService.getCategoryCount());

        return userInfoDTO;
    }

    @Override
    public AdminUserInfoDTO getUserInfoAdmin() throws Exception {
        return AdminUserInfoDTO.toAdminUserInfoDTO(this.adminUserMapper.getAdminUserAdmin());
    }

    @Override
    public boolean updateAdminUser(UpdateUserInfo updateUserInfo) throws Exception {
        return 1 == this.adminUserMapper.updateAdminUser(updateUserInfo);
    }

    @Override
    public String getToken() throws Exception {
        return this.adminUserMapper.getToken();
    }

    @Override
    public boolean updateUsernameOrPassword(String username, String password) throws Exception {
        return 1 == this.adminUserMapper.updateUsernameOrPassword(username, password);
    }

    @Override
    public String getPassword() throws Exception {
        return this.adminUserMapper.getPassword();
    }
}
