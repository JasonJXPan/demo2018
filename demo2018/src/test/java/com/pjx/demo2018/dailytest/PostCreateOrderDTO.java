package com.pjx.demo2018.dailytest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 创建订单后，处理数据DTO
 *
 * @author panjinxin
 * @since 2020/3/19
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostCreateOrderDTO implements Serializable {
    private static final long serialVersionUID = -9162814977479239018L;

    /**
     * 渠道id
     */
    private String channelId;
    /**
     * 订单id
     */
    private String orderId;
    /**
     * 推广活动id
     */
    private String campaignId;
    /**
     * 第三方返回
     */
    private String feedback;
    /**
     * 第三方订单id
     */
    private String thirdPartyId;
    /**
     * 提交时间
     */
    private Date clickTime;
    /**
     * 来源链接
     */
    private String cpsRefer;

    /**
     * 下单协议id
     */
    private String orderAgreementId;
    /**
     * 协议同意时间
     */
    private Date agreeTime;
    /**
     * 票面id
     */
    private String seatPlanId;

    /**
     * 供应商订单id
     */
    private String sponsorOrderId;
    /**
     * 供应商id
     */
    private String sponsorId;
    
    private Boolean updateChannelOrder;
    
    private Boolean updateSponsorOrder;
    
    private Boolean updateOrderAgreement;
}
