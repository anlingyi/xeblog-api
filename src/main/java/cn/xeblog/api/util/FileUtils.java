package cn.xeblog.api.util;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author anlingyi
 * @date 2020/11/13
 */
public class FileUtils {

    public static String getFileType(MultipartFile multipartFile) {
        return multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename()
                .lastIndexOf(".") + 1).toLowerCase();
    }

}
