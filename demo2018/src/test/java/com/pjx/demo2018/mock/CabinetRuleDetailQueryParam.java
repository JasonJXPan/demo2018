package com.pjx.demo2018.mock;

import com.juqitech.request.BaseParam;
import com.juqitech.service.enums.BizCodeEnum;
import com.juqitech.service.utils.ParamChecker;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * 取票柜规则详细查询param
 */
@ApiModel("取票柜规则详细查询param")
@Data
public class CabinetRuleDetailQueryParam extends BaseParam {

    @ApiModelProperty("业务编码")
    private BizCodeEnum bizCode;
    @ApiModelProperty("场次id")
    private String sessionId;
    @ApiModelProperty("场次时间")
    private Date sessionTime;
    @ApiModelProperty("场馆id")
    private String venueId;

    @Override
    public void checkParam() {
        ParamChecker.notBlank(this.sessionId, "场次id不能为空");
    }
}
