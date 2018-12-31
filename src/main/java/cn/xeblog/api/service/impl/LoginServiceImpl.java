package cn.xeblog.api.service.impl;

import cn.xeblog.api.dao.AdminUserMapper;
import cn.xeblog.api.domain.dto.admin.LoginInfoDTO;
import cn.xeblog.api.domain.model.AdminUser;
import cn.xeblog.api.enums.Code;
import cn.xeblog.api.exception.ErrorCodeException;
import cn.xeblog.api.service.LoginService;
import cn.xeblog.api.util.JwtUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author yanpanyi
 * @date 2018/10/17
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Resource
    private AdminUserMapper adminUserMapper;

    @Override
    public LoginInfoDTO login(String username, String password) throws Exception {
        AdminUser adminUser = this.adminUserMapper.getAdminUserByUsernameAndPassword(username,
                DigestUtils.md5Hex(password));

        if (null == adminUser) {
            // 用户名或密码错误
            throw new ErrorCodeException(Code.WRONG_USER_NAME_OR_PASSWORD);
        }

        // 创建token
        String token = JwtUtils.createToken(adminUser.getId());
        // 更新用户token信息
        this.adminUserMapper.updateToken(token);

        return new LoginInfoDTO(adminUser.getId(), adminUser.getUsername(), token);
    }
}
