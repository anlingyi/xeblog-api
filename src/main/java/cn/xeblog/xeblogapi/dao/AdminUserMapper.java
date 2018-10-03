package cn.xeblog.xeblogapi.dao;

import cn.xeblog.xeblogapi.domain.model.AdminUser;

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
}
