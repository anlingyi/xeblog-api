package cn.xeblog.api.domain.model;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 足迹
 *
 * @author anlingyi
 */
@Data
@TableName("footprint")
public class Footprint extends Model<Footprint> {

  @TableId
  private Integer id;
  private String content;
  private String image;
  private String tag;
  private String address;
  private String nickname;
  private Double longitude;
  private Double latitude;
  private String geohash;
  private String code;
  private String ip;
  private LocalDateTime createTime;
  private LocalDateTime updateTime;

}
