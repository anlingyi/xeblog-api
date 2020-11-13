package cn.xeblog.api.util;

import cn.xeblog.api.constant.CommonConstant;
import cn.xeblog.api.constant.FileConstant;
import cn.xeblog.api.enums.Code;
import cn.xeblog.api.enums.ErrorCode;
import cn.xeblog.api.exception.ErrorCodeException;
import cn.xeblog.api.service.UploadService;
import com.auth0.jwt.interfaces.Claim;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;
import java.util.regex.Pattern;

/**
 * 参数校验工具类
 *
 * @author yanpanyi
 * @date 2018/10/4
 */
@Component
@Slf4j
public class CheckUtils {

    /**
     * 校验id
     *
     * @param id
     * @return
     */
    public static boolean checkId(Integer id) {
        return null == id || 1 > id;
    }

    /**
     * 校验登陆用户token合法性
     *
     * @param uid      uid
     * @param token    登陆用户token
     * @param nowToken 当前用户数据库中的token
     * @return
     * @throws Exception
     */
    public static boolean validateToken(String uid, String token, String nowToken) throws Exception {
        if (StringUtils.isEmpty(token) || StringUtils.isEmpty(uid)) {
            return false;
        }

        // 对比数据库token
        if (token.equals(nowToken)) {
            // 解析token
            Map<String, Claim> claim = JwtUtils.verifyToken(token);
            if (null != claim) {
                String jwtUserId = claim.get(CommonConstant.UID).asString();
                return uid.equals(jwtUserId);
            }
        }

        return false;
    }

    /**
     * 校验邮箱
     *
     * @param email
     */
    public static void checkEmail(String email) {
        if (StringUtils.isEmpty(email)) {
            error(Code.INVALID_PARAMETERS);
        }

        boolean flag = Pattern.matches(CommonConstant.EMAIL_REGEX, email);
        if (!flag) {
            log.info("{}，邮箱不合法！", email);
            error(Code.EMAIL_IS_INVALID);
        }
    }

    /**
     * 校验验证码
     *
     * @param code
     */
    public static void checkVerifyCode(String code) {
        if (StringUtils.isEmpty(code) || code.length() != CommonConstant.VERIFY_CODE_LENGTH) {
            error(Code.INVALID_PARAMETERS);
        }
    }

    /**
     * 抛出错误码异常
     *
     * @param errorCode
     */
    public static void error(ErrorCode errorCode) {
        throw new ErrorCodeException(errorCode);
    }

    /**
     * 检验图片
     *
     * @param file
     */
    public static void checkImageFile(MultipartFile file) {
        if (file == null || file.isEmpty()) {
            error(Code.INVALID_PARAMETERS);
        }

        if (file.getSize() > FileConstant.FILE_MAX_SIZE) {
            error(Code.UPLOADED_FILE_IS_TOO_LARGE);
        }

        if (FileConstant.ACCEPT_IMAGE_FILE_TYPE.indexOf(FileUtils.getFileType(file)) == -1) {
            error(Code.UNSUPPORTED_IMAGE_TYPE);
        }
    }
}
