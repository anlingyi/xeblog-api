package cn.xeblog.api.service;

import cn.xeblog.api.util.UUIDUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 上传
 *
 * @author yanpanyi
 * @date 2018/11/12
 */
public interface UploadService {

    /**
     * 文件上传
     *
     * @param files
     * @return
     */
    List<String> upload(MultipartFile[] files);

    /**
     * 上传图片带水印
     *
     * @param files
     * @param watermarked 是否带水印
     * @return
     */
    List<String> uploadImageWithWatermark(MultipartFile[] files, boolean watermarked);

    default String createFileName(MultipartFile multipartFile) {
        return UUIDUtils.createUUID() + "." + getFileType(multipartFile);
    }

    default String getFileType(MultipartFile multipartFile) {
        return multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename()
                .lastIndexOf(".") + 1);
    }
}
