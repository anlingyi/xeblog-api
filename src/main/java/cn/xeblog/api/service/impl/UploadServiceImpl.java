package cn.xeblog.api.service.impl;

import cn.xeblog.api.domain.config.FileConfig;
import cn.xeblog.api.service.UploadService;
import cn.xeblog.api.util.RequestUtils;
import cn.xeblog.api.util.UUIDUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yanpanyi
 * @date 2018/11/12
 */
@Service
public class UploadServiceImpl implements UploadService {

    @Resource
    private FileConfig fileConfig;

    @Override
    public Map<String, String> upload(HttpServletRequest request) throws Exception {
        List<MultipartFile> files = RequestUtils.getFiles(request);
        Map<String, String> map = new HashMap<>(files.size());

        // 文件名
        String fileName;
        // 文件类型
        String type;
        // 保存到数据库的路径
        String savePath;
        // 上传路径
        String uploadPath;
        MultipartFile multipartFile;
        BufferedOutputStream stream = null;

        for (int i = 0; i < files.size(); i++) {
            multipartFile = files.get(i);

            if (!multipartFile.isEmpty()) {
                try {
                    byte[] bytes = multipartFile.getBytes();

                    type = multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().
                            indexOf("."));
                    fileName = UUIDUtils.createUUID() + type;
                    savePath = fileConfig.getUploadPath() + fileName;
                    uploadPath = fileConfig.getDirectoryMapping().replace("file:", "") + savePath;

                    File file = new File(uploadPath);

                    if (!file.getParentFile().exists()) {
                        file.getParentFile().mkdirs();
                    }

                    stream = new BufferedOutputStream(new FileOutputStream(file));
                    stream.write(bytes);

                    map.put(multipartFile.getName(), savePath);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (null != stream) {
                        stream.close();
                        stream = null;
                    }
                }
            }
        }

        return map;
    }

}
