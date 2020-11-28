package cn.xeblog.api.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author anlingyi
 * @date 2020/11/13
 */
@Data
public class FootprintListDTO {

    private Integer id;
    private String content;
    private String image;
    private String tag;
    private String address;
    private Integer distance;
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss")
    private LocalDateTime createTime;
    private String nickname;

}
