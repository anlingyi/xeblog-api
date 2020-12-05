package cn.xeblog.api.service.impl;

import cn.xeblog.api.domain.config.UpYunConfig;
import cn.xeblog.api.enums.Code;
import cn.xeblog.api.exception.ErrorCodeException;
import lombok.extern.slf4j.Slf4j;
import main.java.com.UpYun;
import org.apache.commons.io.IOUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
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

            byte[] bytes = watermarked && acceptWatermark(fileInfo.getType()) ? getWatermarkImageBytes(file, fileInfo) : file.getBytes();
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

    private byte[] getWatermarkImageBytes(MultipartFile multipartFile, FileInfo fileInfo) throws ErrorCodeException {
        try {
            return getWatermarkImageBytes(multipartFile.getInputStream(), fileInfo.getType());
        } catch (IOException e) {
            log.error("上传文件出现异常", e);
        }

        throw new ErrorCodeException(Code.FAILED);
    }

    private byte[] getWatermarkImageBytes(InputStream inputStream, String fileType) throws ErrorCodeException {
        try {
            // 将BufferedImage转换成byte[]
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ImageIO.write(buildWatermarkImage(inputStream), fileType, byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            log.error("上传文件出现异常", e);
        }

        throw new ErrorCodeException(Code.FAILED);
    }

    private byte[] getWatermarkImageBytes(byte[] bytes, String fileType) throws ErrorCodeException {
        try {
            // 将BufferedImage转换成byte[]
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ImageIO.write(buildWatermarkImage(bytes), fileType, byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            log.error("上传文件出现异常", e);
        }

        throw new ErrorCodeException(Code.FAILED);
    }

    @Override
    public String upload(InputStream inputStream, String fileType, boolean watermarked) {
        String name = createFileName();
        String fileName = name + "." + fileType;

        try {
            byte[] bytes = watermarked && acceptWatermark(fileType) ? getWatermarkImageBytes(inputStream, fileType)
                    : IOUtils.toByteArray(inputStream);
            if (!toUpYun(fileName, bytes)) {
                throw new ErrorCodeException(Code.FAILED);
            }

            return upYunConfig.getAccessAddress() + fileName;
        } catch (IOException e) {
            log.error("上传文件出现异常", e);
        }

        throw new ErrorCodeException(Code.FAILED);
    }

    @Override
    public String upload(byte[] bytes, String fileType, boolean watermarked) {
        String name = createFileName();
        String fileName = name + "." + fileType;

        byte[] bts = watermarked && acceptWatermark(fileType) ? getWatermarkImageBytes(bytes, fileType) : bytes;
        if (!toUpYun(fileName, bts)) {
            throw new ErrorCodeException(Code.FAILED);
        }

        return upYunConfig.getAccessAddress() + fileName;
    }
}
