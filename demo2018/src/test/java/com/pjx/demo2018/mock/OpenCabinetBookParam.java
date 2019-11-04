package com.pjx.demo2018.mock;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * OpenCabinetBookParam
 *
 * @author zhuhaitao
 * @since 2019-06-11
 */
@Data
@ApiModel("预定取票柜param")
public class OpenCabinetBookParam {
    /**
     * 场馆id
     */
    private String venueId;
    /**
     * 采购单id
     */
    private String purchaseOrderId;
    /**
     * 订单id
     */
    private String orderId;
    /**
     * 预定时间 ,  改用occupyTimeStart 和 occupyTimeEnd
     */
    @Deprecated
    private Date bookTime;
    /**
     * 票品张数
     */
    private Integer ticketQty;
    /**
     * 寄件码开始时间
     */
    private Date deliveryCodeStartTime;
    /**
     * 寄件码结束时间
     */
    private Date deliveryCodeEndTime;
    /**
     * 取件码开始时时间
     */
    private Date pickupCodeStartTime;
    /**
     * 取件码结束时间
     */
    private Date pickupCodeEndTime;

    /**
     * 场次
     */
    private String sessionId;

    @ApiModelProperty("占用取票柜-起始时间")
    private Date occupyTimeStart;
    @ApiModelProperty("占用取票柜-截止时间")
    private Date occupyTimeEnd;
}
