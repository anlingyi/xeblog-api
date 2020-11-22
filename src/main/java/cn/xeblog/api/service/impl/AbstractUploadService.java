package cn.xeblog.api.service.impl;

import cn.xeblog.api.service.UploadService;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

/**
 * @author anlingyi
 * @date 2020/11/13
 */
public abstract class AbstractUploadService implements UploadService {

    public List<String> execute(MultipartFile[] files, boolean watermarked) {
        List<String> list = new ArrayList<>(files.length);

        for (MultipartFile multipartFile : files) {
            if (multipartFile.isEmpty()) {
                continue;
            }

            list.add(uploadImage(multipartFile, watermarked));
        }

        return list;
    }

}
