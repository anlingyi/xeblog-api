package cn.xeblog.api.domain.request;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

/**
 * 添加足迹
 *
 * @author anlingyi
 */
@Data
public class AddFootprint {

  private String content;
  private MultipartFile image;
  private String tag;
  private String address;
  private Double longitude;
  private Double latitude;
    private String nickname;

}
