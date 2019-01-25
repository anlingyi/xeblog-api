package cn.xeblog.api.domain.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 文件相关
 *
 * @author yanpanyi
 * @date 2019/1/4
 */
@Component
@ConfigurationProperties(prefix = "file")
public class FileConfig {

    /**
     * 上传文件路径
     */
    private String uploadPath;
    /**
     * 静态资源访问路径
     */
    private String staticAccessPath;
    /**
     * 文件目录映射
     */
    private String directoryMapping;
    /**
     * 访问地址
     */
    private String accessAddress;

    public String getAccessAddress() {
        return accessAddress;
    }

    public void setAccessAddress(String accessAddress) {
        this.accessAddress = accessAddress;
    }

    public String getDirectoryMapping() {
        return directoryMapping;
    }

    public void setDirectoryMapping(String directoryMapping) {
        this.directoryMapping = directoryMapping;
    }

    public String getUploadPath() {
        return uploadPath;
    }

    public void setUploadPath(String uploadPath) {
        this.uploadPath = uploadPath;
    }

    public String getStaticAccessPath() {
        return staticAccessPath;
    }

    public void setStaticAccessPath(String staticAccessPath) {
        this.staticAccessPath = staticAccessPath;
    }
}
