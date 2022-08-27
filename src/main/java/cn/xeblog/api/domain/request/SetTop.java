package cn.xeblog.api.domain.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 设置文章置顶
 *
 * @author anlingyi
 * @date 2022/8/27 4:52 PM
 */
@Data
public class SetTop {

    @ApiModelProperty("文章id")
    private Integer id;

    @ApiModelProperty("置顶状态 0.不置顶 1.置顶")
    private Integer status;

}
