package com.pjx.demo2018.dailytest;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;

/**
 * OrderPO
 *
 * @author zhuhaitao
 * @since 2019-06-28
 */
@Setter
@Getter
@ToString(callSuper = true)
public class OrderPO {
    private String orderOID;
    private String orderNumber;
    private String clientOID;
    private String showOID;
    private String showSessionOID;
    private String ticketOID;
    private String orderStatus;
    private String backendStatus;
    private String orderType;
    private Integer qty;
    private BigDecimal price;
    private BigDecimal discount;
    private String couponOID;
    private BigDecimal total;
    private BigDecimal compensatedPrice;
    private String deliverMethod;
    private BigDecimal deliverFee;
    private String cellphone;
    private String receiver;
    private String locationOID;
    private String address;
    private String payment;
    private String express;
    private String expressNo;
    private Date createTime;
    private Date updateTime;
    private Boolean isDeleted;
    private Boolean committed;
    private Boolean seatSelected;
    private String seatPlanOID;
    private String comments;
    private String ticketPrintType;
    private String source;
    private String grouponGroupOID;
    private BigDecimal ticketPrice;
    private Boolean lockedforVoucher;
    private Date completeTime;
    private String remark;
    private Date receivedTime;
    private String channel;
    private String offlineSource;
    private Date receiveTicketTime;
    private Date commitToDeliveryTime;
    private Date reserveToCommonTime;
    private Boolean is_partial_refunding;
    private Integer printExpressTime;
    private String identity;
    private BigDecimal seat_plan_price;
    private BigDecimal guarantee_fee;
    private Integer alloc_type;
    private Boolean is_hidden;
    private Boolean commented;
    private Boolean commentable;
    private String ticket_form;
    private String product_type;
    private String promotion_id;
    private BigDecimal promotion_amount;
    private BigDecimal mtl_service_fee;
    private BigDecimal allowance;
    private String allowance_type;
    private String extention;
    private Date trade_time;
    private String main_order_id;
    private String goods_type;
}
