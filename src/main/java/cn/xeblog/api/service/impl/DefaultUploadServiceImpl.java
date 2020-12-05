package cn.xeblog.api.service.impl;

import cn.xeblog.api.domain.config.FileConfig;
import cn.xeblog.api.enums.Code;
import cn.xeblog.api.exception.ErrorCodeException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import java.io.*;
import java.util.List;

/**
 * 默认文件上传实现
 *
 * @author yanpanyi
 * @date 2018/11/12
 */
@Service
@Slf4j
public class DefaultUploadServiceImpl extends AbstractUploadService {

    @Resource
    private FileConfig fileConfig;

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
        FileInfo fileInfo = getFileInfo(file);

        try {
            File out = createFile(fileInfo.getFileName());
            if (watermarked && acceptWatermark(fileInfo.getType())) {
                ImageIO.write(buildWatermarkImage(file), fileInfo.getType(), out);
            } else {
                file.transferTo(out);
            }

            return fileInfo.getUrl();
        } catch (IOException e) {
            log.error("上传文件出现异常", e);
        }

        throw new ErrorCodeException(Code.FAILED);
    }

    @Override
    protected FileInfo getFileInfo(MultipartFile multipartFile) {
        return super.getFileInfo(multipartFile, fileConfig.getAccessAddress());
    }

    @Override
    public String upload(InputStream inputStream, String fileType, boolean watermarked) {
        String name = createFileName();
        String fileName = name + "." + fileType;

        try {
            File out = createFile(fileName);

            if (watermarked && acceptWatermark(fileType)) {
                ImageIO.write(buildWatermarkImage(inputStream), fileType, out);
            } else {
                try (FileOutputStream fos = new FileOutputStream(out)) {
                    fos.write(IOUtils.toByteArray(inputStream));
                } catch (Exception e) {
                    throw e;
                }
            }

            return fileConfig.getAccessAddress() + fileName;
        } catch (Exception e) {
            log.error("上传文件出现异常", e);
        }

        throw new ErrorCodeException(Code.FAILED);
    }

    private File createFile(String fileName) {
        return new File(fileConfig.getDirectoryMapping().replace("file:", "") +
                fileConfig.getUploadPath() + fileName);
    }

    @Override
    public String upload(byte[] bytes, String fileType, boolean watermarked) {
        String name = createFileName();
        String fileName = name + "." + fileType;

        try {
            File out = createFile(fileName);

            if (watermarked && acceptWatermark(fileType)) {
                ImageIO.write(buildWatermarkImage(bytes), fileType, out);
            } else {
                try (FileOutputStream fos = new FileOutputStream(out)) {
                    fos.write(bytes);
                } catch (Exception e) {
                    throw e;
                }
            }

            return fileConfig.getAccessAddress() + fileName;
        } catch (Exception e) {
            log.error("上传文件出现异常", e);
        }

        throw new ErrorCodeException(Code.FAILED);
    }
}
