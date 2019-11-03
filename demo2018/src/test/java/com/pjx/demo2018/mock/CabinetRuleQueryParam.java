package com.pjx.demo2018.mock;

import com.juqitech.request.BaseParam;
import com.juqitech.service.enums.BizCodeEnum;
import com.juqitech.service.utils.ParamChecker;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * 取票柜规则查询param
 */
@ApiModel("取票柜规则查询param")
@Data
public class CabinetRuleQueryParam extends BaseParam {

    @ApiModelProperty("业务编码")
    private BizCodeEnum bizCode;

    @ApiModelProperty("是否需要默认值")
    private Boolean needDefault;

    @ApiModelProperty("详细信息参数")
    private List<CabinetRuleDetailQueryParam> detailQueryParams;


    @Override
    public void checkParam() {
        ParamChecker.notNull(this.bizCode,"业务编码不能为空");
        ParamChecker.notEmpty(this.detailQueryParams, "查询信息不能为空");
    }
}
