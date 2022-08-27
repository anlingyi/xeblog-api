package cn.xeblog.api.domain.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 设置文章私有
 *
 * @author anlingyi
 * @date 2022/8/27 4:52 PM
 */
@Data
public class SetPrivate {

    @ApiModelProperty("文章id")
    private Integer id;

    @ApiModelProperty("私有状态 0.不私有 1.私有")
    private Integer status;

}
