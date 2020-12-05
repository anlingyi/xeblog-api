package cn.xeblog.api.service;

import cn.xeblog.api.util.FileUtils;
import cn.xeblog.api.util.UUIDUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
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

    /**
     * 上传文件
     *
     * @param file
     * @param watermarked 是否带水印
     * @return 上传后的文件地址
     */
    String upload(MultipartFile file, boolean watermarked);

    /**
     * 通过流上传
     *
     * @param inputStream
     * @param fileType
     * @param watermarked
     * @return
     */
    String upload(InputStream inputStream, String fileType, boolean watermarked);

    String upload(byte[] bytes, String fileType, boolean watermarked);

    /**
     * 使用异步的方式上传文件
     *
     * @param inputStream
     * @param watermarked
     * @param callback
     * @return
     */
    void uploadWithAsync(InputStream inputStream, String fileType, boolean watermarked, UploadCallback callback);

    void uploadWithAsync(byte[] bytes, String fileType, boolean watermarked, UploadCallback callback);

    default String createFileName(MultipartFile multipartFile) {
        return createFileName() + "." + FileUtils.getFileType(multipartFile);
    }

    default String createFileName() {
        return UUIDUtils.createUUID();
    }

}
