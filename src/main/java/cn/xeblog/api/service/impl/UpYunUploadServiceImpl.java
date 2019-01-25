package cn.xeblog.api.service.impl;

import cn.xeblog.api.domain.config.UpYunConfig;
import cn.xeblog.api.enums.Code;
import cn.xeblog.api.exception.ErrorCodeException;
import cn.xeblog.api.service.UploadService;
import cn.xeblog.api.util.RequestUtils;
import cn.xeblog.api.util.UUIDUtils;
import main.java.com.UpYun;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 又拍云上传
 *
 * @author yanpanyi
 * @date 2019/1/25
 */
@Service
public class UpYunUploadServiceImpl implements UploadService {

    @Resource
    private UpYunConfig upYunConfig;

    private static UpYun upYun;

    /**
     * 初始化
     */
    private void init() {
        if (null != upYun) {
            return;
        }

        upYun = new UpYun(upYunConfig.getBucketName(), upYunConfig.getUserName(), upYunConfig.getPassword());
    }

    @Override
    public Map<String, String> upload(HttpServletRequest request) {
        this.init();

        List<MultipartFile> files = RequestUtils.getFiles(request);
        Map<String, String> map = new HashMap<>(files.size());

        // 文件名
        String fileName;
        // 文件类型
        String type;
        // 返回路径
        String respPath;
        MultipartFile multipartFile;

        for (int i = 0; i < files.size(); i++) {
            multipartFile = files.get(i);

            if (!multipartFile.isEmpty()) {
                try {
                    byte[] bytes = multipartFile.getBytes();

                    type = multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().
                            indexOf("."));
                    fileName = UUIDUtils.createUUID() + type;
                    respPath = upYunConfig.getAccessAddress() + fileName;

                    if (!upYun.writeFile(upYunConfig.getUploadPath() + fileName, bytes, true)) {
                        throw new ErrorCodeException(Code.FAILED);
                    }

                    map.put(multipartFile.getName(), respPath);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        return map;
    }

}
