package cn.xeblog.api.domain.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 设置文章推荐
 *
 * @author anlingyi
 * @date 2022/4/3 6:08 下午
 */
@Data
public class SetRecommend {

    @ApiModelProperty("文章id")
    private Integer id;

    @ApiModelProperty("推荐状态 0.不推荐 1.推荐")
    private Integer status;

}
