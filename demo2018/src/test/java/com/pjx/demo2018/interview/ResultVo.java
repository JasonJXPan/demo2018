package com.pjx.demo2018.interview;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 结果Vo
 * Created by juqi on 19/9/10.
 */
@ApiModel("结果Vo")
@Data
public class ResultVo {
    @ApiModelProperty("档位价格")
    private BigDecimal price;
    @ApiModelProperty("和前一档位差价， 第一档为0")
    private BigDecimal diff;
}
