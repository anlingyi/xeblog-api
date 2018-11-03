package cn.xeblog.api.dao;

import cn.xeblog.api.domain.model.AdminUser;
import cn.xeblog.api.domain.request.UpdateUserInfo;
import org.apache.ibatis.annotations.Param;

/**
 * @author yanpanyi
 * @date 2018/10/3
 */
public interface AdminUserMapper {

    /**
     * 获取用户信息
     *
     * @return
     * @throws Exception
     */
    AdminUser getAdminUser() throws Exception;

    /**
     * 获取用户信息cms
     *
     * @return
     * @throws Exception
     */
    AdminUser getAdminUserAdmin() throws Exception;

    /**
     * 更新个人信息
     *
     * @param updateUserInfo
     * @return
     * @throws Exception
     */
    Integer updateAdminUser(@Param("info") UpdateUserInfo updateUserInfo) throws Exception;

    /**
     * 通过用户名和密码获取用户
     *
     * @param username
     * @param password
     * @return
     * @throws Exception
     */
    AdminUser getAdminUserByUsernameAndPassword(@Param("username") String username,
                                                @Param("password") String password) throws Exception;

    /**
     * 获取token
     *
     * @return
     * @throws Exception
     */
    String getToken() throws Exception;

    /**
     * 更新token
     *
     * @return
     * @throws Exception
     */
    Integer updateToken(@Param("token") String token) throws Exception;

    /**
     * 更新用户名或密码
     *
     * @param username
     * @param password
     * @return
     * @throws Exception
     */
    Integer updateUsernameOrPassword(@Param("username") String username,
                                     @Param("password") String password) throws Exception;

    /**
     * 获取密码
     *
     * @return
     * @throws Exception
     */
    String getPassword() throws Exception;
}
