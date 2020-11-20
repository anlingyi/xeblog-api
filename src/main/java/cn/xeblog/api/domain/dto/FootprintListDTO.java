package cn.xeblog.api.domain.dto;

import lombok.Data;

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
    private String createTime;

}
