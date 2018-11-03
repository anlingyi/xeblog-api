package cn.xeblog.api.service;

import cn.xeblog.api.domain.dto.admin.LoginInfoDTO;

/**
 * 登陆
 *
 * @author yanpanyi
 * @date 2018/10/17
 */
public interface LoginService {

    /**
     * 登陆
     *
     * @param username
     * @param password
     * @return
     * @throws Exception
     */
    LoginInfoDTO login(String username, String password) throws Exception;

}
