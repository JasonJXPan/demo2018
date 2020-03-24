package com.example.consumer.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 类作用描述
 *
 * @author panjinxin
 * @since 2020/3/24
 */
@ApiModel("userVo")
@Data
public class UserVo {
    @ApiModelProperty("用户id")
    private String userId;
    @ApiModelProperty("用户名")
    private String userName;
    @ApiModelProperty("用户年纪")
    private Integer age;
}
