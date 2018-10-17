package cn.xeblog.xeblogapi.service.impl;

import cn.xeblog.xeblogapi.dao.AdminUserMapper;
import cn.xeblog.xeblogapi.domain.dto.admin.LoginInfoDTO;
import cn.xeblog.xeblogapi.domain.model.AdminUser;
import cn.xeblog.xeblogapi.enums.Code;
import cn.xeblog.xeblogapi.exception.CustomException;
import cn.xeblog.xeblogapi.service.LoginService;
import cn.xeblog.xeblogapi.util.JwtUtils;
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
            throw new CustomException(Code.WRONG_USER_NAME_OR_PASSWORD);
        }

        // 创建token
        String token = JwtUtils.createToken(adminUser.getId());
        // 更新用户token信息
        this.adminUserMapper.updateToken(token);

        return new LoginInfoDTO(adminUser.getId(), adminUser.getUsername(), token);
    }
}
