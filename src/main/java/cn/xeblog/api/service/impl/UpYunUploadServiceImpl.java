package cn.xeblog.api.service.impl;

import cn.xeblog.api.domain.config.UpYunConfig;
import cn.xeblog.api.enums.Code;
import cn.xeblog.api.exception.ErrorCodeException;
import lombok.extern.slf4j.Slf4j;
import main.java.com.UpYun;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * 又拍云上传
 *
 * @author yanpanyi
 * @date 2019/1/25
 */
@Service
@Slf4j
public class UpYunUploadServiceImpl extends AbstractUploadService implements CommandLineRunner {

    @Resource
    private UpYunConfig upYunConfig;

    private static UpYun upYun;

    @Override
    public void run(String... args) throws Exception {
        if (null == upYun) {
            upYun = new UpYun(upYunConfig.getBucketName(), upYunConfig.getUserName(), upYunConfig.getPassword());
        }
    }

    @Override
    public List<String> upload(MultipartFile[] files) {
        return execute(files, false);
    }

    @Override
    public List<String> uploadImageWithWatermark(MultipartFile[] files, boolean watermarked) {
        return execute(files, watermarked);
    }

    @Override
    public String upload(MultipartFile file, boolean watermarked) {
        try {
            FileInfo fileInfo = getFileInfo(file);

            byte[] bytes = watermarked && acceptWatermark(fileInfo.getType()) ? getWatermarkImageBytes(file,
                    fileInfo.getType()) : file.getBytes();
            if (!toUpYun(fileInfo.getFileName(), bytes)) {
                throw new ErrorCodeException(Code.FAILED);
            }

            return fileInfo.getUrl();
        } catch (IOException e) {
            log.error("上传文件出现异常", e);
        }

        throw new ErrorCodeException(Code.FAILED);
    }

    @Override
    protected FileInfo getFileInfo(MultipartFile multipartFile) {
        return super.getFileInfo(multipartFile, upYunConfig.getAccessAddress());
    }

    private boolean toUpYun(String fileName, byte[] bytes) {
        return upYun.writeFile(upYunConfig.getUploadPath() + fileName, bytes, true);
    }

    private byte[] getWatermarkImageBytes(MultipartFile multipartFile, String fileType) throws ErrorCodeException {
        return getWatermarkImageBytes(buildWatermarkImage(multipartFile), fileType);
    }

    private byte[] getWatermarkImageBytes(byte[] bytes, String fileType) throws ErrorCodeException {
        return getWatermarkImageBytes(buildWatermarkImage(bytes), fileType);
    }

    private byte[] getWatermarkImageBytes(BufferedImage image, String fileType) throws ErrorCodeException {
        try {
            // 将BufferedImage转换成byte[]
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ImageIO.write(image, fileType, byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            log.error("上传文件出现异常", e);
        }

        throw new ErrorCodeException(Code.FAILED);
    }

    @Override
    public String upload(byte[] bytes, String fileType, boolean watermarked) {
        String name = createFileName();
        String fileName = name + "." + fileType;

        if (!toUpYun(fileName, getImageBytes(bytes, fileType, watermarked))) {
            throw new ErrorCodeException(Code.FAILED);
        }

        return upYunConfig.getAccessAddress() + fileName;
    }

    private byte[] getImageBytes(byte[] bytes, String fileType, boolean watermarked) {
        return watermarked && acceptWatermark(fileType) ? getWatermarkImageBytes(bytes, fileType) : bytes;
    }

}
