package cn.xeblog.api.domain.dto.admin;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 登陆信息
 *
 * @author yanpanyi
 * @date 2018/10/17
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginInfoDTO {

    @ApiModelProperty("id")
    private Integer id;
    @ApiModelProperty("用户名")
    private String username;
    @ApiModelProperty("token")
    private String token;
    @ApiModelProperty("uid")
    private String uid;

}
