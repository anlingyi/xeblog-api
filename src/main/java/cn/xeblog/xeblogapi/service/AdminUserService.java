package cn.xeblog.xeblogapi.service;

import cn.xeblog.xeblogapi.domain.dto.UserInfoDTO;

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
}
