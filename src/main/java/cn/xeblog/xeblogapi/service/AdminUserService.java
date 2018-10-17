package cn.xeblog.xeblogapi.service;

import cn.xeblog.xeblogapi.domain.dto.UserInfoDTO;
import cn.xeblog.xeblogapi.domain.dto.admin.AdminUserInfoDTO;
import cn.xeblog.xeblogapi.domain.request.UpdateUserInfo;

/**
 * @author yanpanyi
 * @date 2018/10/3
 */
public interface AdminUserService {

    /**
     * 获取用户信息
     *
     * @return
     * @throws Exception
     */
    UserInfoDTO getUserInfo() throws Exception;

    /**
     * 获取用户信息cms
     *
     * @return
     * @throws Exception
     */
    AdminUserInfoDTO getUserInfoAdmin() throws Exception;

    /**
     * 更新用户信息
     *
     * @param updateUserInfo
     * @return
     * @throws Exception
     */
    boolean updateAdminUser(UpdateUserInfo updateUserInfo) throws Exception;
}
