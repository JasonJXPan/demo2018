package com.pjx.demo2018.dailytest.enums;

public enum ResponseCode {

    SUCCESS("200", "成功"), PURCHASE_LIMIT_REACHED("1009", "这个渠道已经订购了超过上限的票"),ORDER_PURCHASE_LIMIT_REACHED("1001", "这个渠道已经订购了超过上限的票"),
    DELIVER_METHOD_ERROR("1005", "配送方式错误"), ORDER_DELIVER_METHOD_ERROR("1001", "配送方式错误"), ORDER_SHOW_INFO_ERROR("1001", "演出信息错误"), SHOW_INFO_ERROR("1006", "演出信息错误"), DISCOUNT_INFO_ERROR("1007", "打折信息错误"),COUPON_USE_ERROR("1008", "优惠券已使用"),ORDER_DISCOUNT_INFO_ERROR("1001", "打折信息错误"),
    DUPLICATE_THIRDPARTORDERID("1014", "第三方订单号重复"),THIRDPARTORDER_CREATE_ERROR("1020", "第三方订单下单失败"),STOCK_NOT_ENOUGH("1012","该价格的票已售完，请重新选择票面"), TICKET_NOT_FOUND("1004", "不存在的票类"),ERROR_OF_SELL_TYPE("1003","不存在的卖法"), SUMBIT_ORDER_FAIL("1013", "创建订单失败"),
    NO_ORDERAGREEMENT("1001", "请勾选下单协议后提交"), OTHER_ERROR("1011", "其它错误，具体的错误信息是:"),
    INVALID_MOBILE("1002", "无效的手机号"), USER_NOT_FOUND("1001", "不存在的渠道商或者用户"), CHANNEL_NOT_FOUND("1001", "不存在的渠道商"), INVALID_IDENTITY("1001", "身份证格式不合法"),
    ORDER_AGREEMENT_NOT_ACCEPTED("1001", "请勾选下单协议后提交"), PARAM_INVALID("1000", "参数不正确"), SERVER_ERROR("500", "内部错误"), INVALID_REQUEST("1001", "请求数据格式不对"),
    OPERATION_FAIL("514", ""), TICKET_SOLDOUT("1102", "该价格的票已售完，请重新选择票面"), REFUND_NOT_ALLOWED_BEFORE_TICKET_ACCEPT("1103", "您的订单卖家已接单啦！"),
    REFUND_NOT_ALLOWED("1107", "此订单不能退款"), ORDER_NOT_FOUND("1104", "订单不存在"), REFUND_FAIL("1105", "退款失败"), SYSTEM_BUSY("1106", "系统繁忙，请稍后再试。"),
    PAYMENT_TYPE_INVALID("1005", "请提供有效的支付方式"), ORDER_NOT_FOUND_FOR_OPENAPI_CONFIRM_PAYMENT("1003", "不存在的订单"), ORDER_CANCELED("1001", "订单已被取消"),
    ORDER_PAID("1001", "订单已支付，请联系客服人员取消"), ORDER_NOT_FOUND_FOR_CANCEL_ORDER("1001", "没有相关订单"), ORDER_STATUS_INCORRECT("3001", "订单状态不正确"), USER_CONFIRMED("5001", "已确认收票"),
    AWARD_POINT_INFO_ERROR("10007", "积分信息错误"), NOT_ALLOW_PURCHASE("10008", "没有权限购买"), NOT_EXIST_ORDER("11001","不存在该订单"),NOT_EXIST_ORDER_AUDIENCES("11002","该订单下不存在观演人信息"),PALCE_ORDER_IDENTITY_INFO_REPEAT("11003","观演人身份证信息重复，请核对后再提交"),
    SHOW_PROMOTION_NOT_USE("11004","订单提交失败，请重新购买"),
    PRIME_CARD_NOT_MATCH("11005","会员卡不匹配，请重新下单"),
	CREATE_ORDER_RATE_LIMIT("1021","操作过于频繁，请稍后再试。"),
	UNPAID_COUNT_EXCEED_THRESHHOLD("1022","待支付订单数量超过上限。")
	;

	private String code;
	private String msg;

	private ResponseCode(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public static String getMsgBycode(String code) {
		for (ResponseCode resp : values()) {
			if (resp.getCode().equals(code)) {
				return resp.getMsg();
			}
		}
		return null;
	}
}
