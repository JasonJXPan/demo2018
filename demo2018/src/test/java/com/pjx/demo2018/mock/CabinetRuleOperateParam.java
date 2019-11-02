package com.pjx.demo2018.mock;

import com.juqitech.request.BaseParam;
import com.juqitech.service.utils.ParamChecker;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * 取票柜规则维护参数
 */
@Data
@ApiModel("取票柜规则")
public class CabinetRuleOperateParam extends BaseParam {
    private static final long serialVersionUID = 2669089601145062581L;

    @ApiModelProperty("业务编码")
    private String BizCode;
    @ApiModelProperty("演出id")
    private String showId;

    @ApiModelProperty("取票柜规则详情")
    private List<CabinetRuleOperateDetailParam> operateDetailParams;

    @ApiModelProperty("不使用取票柜的场次id")
    private List<String> excludeShowSessionIds;


    @Override
    public void checkParam() {
        ParamChecker.notBlank(showId, "演出id不能为空");
    }
}
