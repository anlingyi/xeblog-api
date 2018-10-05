package cn.xeblog.xeblogapi.service.impl;

import cn.xeblog.xeblogapi.dao.AdminUserMapper;
import cn.xeblog.xeblogapi.domain.dto.UserInfoDTO;
import cn.xeblog.xeblogapi.service.AdminUserService;
import cn.xeblog.xeblogapi.service.ArticleService;
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

        return userInfoDTO;
    }
}
