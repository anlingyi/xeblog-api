package cn.xeblog.xeblogapi.dao;

import cn.xeblog.xeblogapi.domain.model.AdminUser;
import cn.xeblog.xeblogapi.domain.request.UpdateUserInfo;
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
}
