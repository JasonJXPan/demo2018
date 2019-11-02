package com.pjx.demo2018.mock;

import com.juqitech.request.BaseParam;
import com.juqitech.service.utils.ParamChecker;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * 取票柜规则详情维护参数
 */
@Data
@ApiModel("取票柜规则详情")
public class CabinetRuleOperateDetailParam extends BaseParam {
    private static final long serialVersionUID = 5506675924686466692L;

    @ApiModelProperty("业务编码")
    private String BizCode;
    @ApiModelProperty("场次id")
    private String showSessionId;
    @ApiModelProperty("场次时间")
    private Date sessionTime;
    @ApiModelProperty("场馆id")
    private String venueId;
    @ApiModelProperty("取票柜开放时间")
    private Date occupyTimeStart;
    @ApiModelProperty("最晚存入时间")
    private Date depositTimeEnd;
    @ApiModelProperty("用户最早取票时间")
    private Date pickUpTimeStart;
    @ApiModelProperty("取票柜释放时间")
    private Date occupyTimeEnd;
    @ApiModelProperty("集合关系类型")
    private RangeType rangeType;
    @ApiModelProperty("受影响卖家， 是剔除还是包含取决于rangeType字段")
    private List<String> sellerIds;


    @Override
    public void checkParam() {
    }
}
