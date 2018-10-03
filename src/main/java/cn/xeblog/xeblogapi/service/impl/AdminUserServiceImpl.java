package cn.xeblog.xeblogapi.service.impl;

import cn.xeblog.xeblogapi.dao.AdminUserMapper;
import cn.xeblog.xeblogapi.domain.dto.UserInfoDTO;
import cn.xeblog.xeblogapi.service.AdminUserService;
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

    @Override
    public UserInfoDTO getUserInfo() throws Exception {
        return UserInfoDTO.toUserInfoDTO(this.adminUserMapper.getAdminUser());
    }
}
