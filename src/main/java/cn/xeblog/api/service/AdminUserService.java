package cn.xeblog.api.service;

import cn.xeblog.api.domain.dto.UserInfoDTO;
import cn.xeblog.api.domain.dto.admin.AdminUserInfoDTO;
import cn.xeblog.api.domain.request.UpdateUserInfo;

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

    /**
     * 获取token
     *
     * @return
     * @throws Exception
     */
    String getToken() throws Exception;

    /**
     * 更新用户名或密码
     *
     * @param username
     * @param password
     * @return
     * @throws Exception
     */
    boolean updateUsernameOrPassword(String username, String password) throws Exception;

    /**
     * 获取密码
     *
     * @return
     * @throws Exception
     */
    String getPassword() throws Exception;

    /**
     * 更新token
     *
     * @param token
     * @return
     * @throws Exception
     */
    boolean updateToken(String token) throws Exception;
}
