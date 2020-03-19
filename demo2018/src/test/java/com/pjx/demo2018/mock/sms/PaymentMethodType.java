package com.pjx.demo2018.mock.sms;

public enum PaymentMethodType {
	
	BANKCARD(1, "BankCard", "银联"),
	ALIPAY(2, "AliPay", "支付宝-驹旗"),
	WEIXIN(3, "WeiXin", "微信-驹旗"),
	ONDELIVERY(4, "OnDelivery", "货到付款"),
	DEFAULT_ONLINE(5, "Default_online", "线上支付"),
	ENTERPRISE(6, "Enterprise", "企业支付"),
	CASH_COUPON(7, "CashCoupon", "现金券"),
	UNDEFINED(8, "Undefined", "未定义"),
	CASH(9, "Cash", "现金"),
	EXPRESS(10, "Express", "快递代收"),
	BANK_TRANSFER(11, "Bank_transfer", "银行转账"),
	WEIXIN_WEB(12, "WeiXin_web", "微信网站支付-驹旗"),
	WEIXIN_APP(14, "WeiXin_app", "微信app支付-驹旗"),
	POS(13, "POS", "POS机"),
	CHANNEL_MAOYAN(15, "Channel_maoyan", "猫眼支付"),
	CHANNEL_JINGDONG(16, "Channel_jingdong", "京东支付"),
	CHANNEL_CTRIP(17, "Channel_xiecheng", "携程支付"),
	CHANNEL_JINGDONGOS(18, "Channel_jingdong_os", "京东宙斯支付"),
	CHANNEL_PIAOFAN(19, "Channel_piaofan", "票贩支付"),
	CHANNEL_JUCHENG(20, "Channel_jucheng", "聚橙支付"),
	CHANNEL_MTLTEST(21, "Channel_mtltest", "摩天轮测试支付"),
	CHANNEL_TKING(22, "Channel_tking", "摩天轮支付"),
	CHANNEL_VICTORIASECRET(22, "Channel_VictoriaSecret", "维密支付"),
	CHANNEL_GUOMEI(23,"Channel_guomei","国美支付"),
	CHANNEL_YOUYU(24,"Channel_youyu","友娱支付"),
	CHANNEL_ANYIHUA(25,"Channel_anyihua","安逸花支付"),
	CHANNEL_ZOUQI(26,"Channel_zouqi","走起支付"),
	ALIPAY_RUISHANG(27, "AliPay|RuiShang", "支付宝-锐赏"),
	WEIXIN_WEB_RUISHANG(28, "WeiXin_web|RuiShang", "微信网站支付-锐赏"),
	WEIXIN_APP_RUISHANG(29, "WeiXin_app|RuiShang", "微信app支付-锐赏"),
	WEIXIN_RUISHANG(30, "WeiXin|RuiShang", "微信-锐赏"),
	CHANNEL_WANZHOUMO(31, "Channel_wanzhoumo", "玩周末支付"),
	CHANNEL_WEIBO(32,"Channel_weibo","微博支付"),
	CHANNEL_JIANSHENGHUO(33,"Channel_jianlife","简生活支付"),
	CHANNEL_MIAOTE(34,"Channel_miaote","喵特支付"),
	MINI_PROGRAM_GROUPON(35, "MiniPrmGroupon", "小程序团购"),
	CHANNEL_VERTU(36, "Channel_vertu", "vertu支付"),
	CHANNEL_PIAOXINGQIU(37,"Channel_piaoxingqiu","票星球支付"),
	CHANNEL_AGENT(38, "Channel_agent", "代理下单支付"),
	CHANNEL_DUMOVIE(39, "Channel_dumovie", "dumovie支付"),
	CHANNEL_IQIYI(40, "Channel_iqiyi", "爱奇艺支付"),
	CHANNEL_QIHU(41, "Channel_qihu", "奇虎360支付"),
	CHANNEL_CCB(42, "Channel_ccb", "建行支付"),
	CHANNEL_QIANGPIAO(43, "Channel_qiangpiao", "抢票支付"),
	CHANNEL_HUYU(44, "Channel_xianchanghuyu", "互娱支付"),
	CHANNEL_GAT(45,"Channel_guanaitong","关爱通支付"),
    CHANNEL_TIANMAO(46,"Channel_tianmao","天猫支付"),
	HUI_FU_PAY(47,"HUI_FU_PAY","汇付-支付"),
	CHANNEL_CHINA_PIAO(48,"Channel_chinapiao","中国票务支付"),
	ALIPAY_MINI_PROGRAM(49, "ALIPAY_MINI_PROGRAM", "支付宝小程序"),
	ALIPAY_ZHIMA_CREDIT_APP(50, "ALIPAY_ZHIMA_CREDIT_APP", "芝麻信用"),
	CHANNEL_ZHIYIXING(51, "Channel_zhiyixing", "知亦行支付"),
	ALIPAY_XUANYI(52, "ALIPAY_XUANYI", "支付宝-烜奕"),
	WEIXIN_XUANYI(53, "WEIXIN_XUANYI", "微信-烜奕"),
	CHANNEL_PIAOLAOBAN(54, "CHANNEL_PIAOLAOBAN", "票老板支付"),
	CHANNEL_GCB(55, "CHANNEL_GCB", "广发银行支付"),
	ALIPAY_PCREDIT(56, "ALIPAY_PCREDIT", "花呗支付"),
	CHANNEL_JUYOUQU(57, "CHANNEL_JUYOUQU", "聚友趣支付"),
	ICBC(58,"ICBC","工商银行支付"),
	CHANNEL_SHOWNOW(59,"CHANNEL_SHOWNOW","SHOWNOW支付"),
	CHANNEL_YAOCHUFA(60,"CHANNEL_YAOCHUFA","要出发支付"),
	CHANNEL_CGB(61, "CHANNEL_CGB", "广发银行支付"),
	CMB(62, "CMB", "招商银行支付"),

	CHANNEL_NXQ_BALAXQ(63, "CHANNEL_NXQ_BALAXQ", "NXQ-巴啦啦星球"),
	CHANNEL_NXQ_WEICHUANG(64, "CHANNEL_NXQ_WEICHUANG", "NXQ-伟创票务"),
	CHANNEL_NXQ_XUANZHUANMM(65, "CHANNEL_NXQ_XUANZHUANMM", "NXQ-旋转木马票务"),
	CHANNEL_NXQ_ZHUIPIAO(66, "CHANNEL_NXQ_ZHUIPIAO", "NXQ-追票"),
	CHANNEL_NXQ_XIAOZHU(67, "CHANNEL_NXQ_XIAOZHU", "NXQ-小猪票务"),
	CHANNEL_NXQ_QA(69, "CHANNEL_NXQ_QA", "NXQ-QA票务"),
	CHANNEL_NXQ_QA2(70, "CHANNEL_NXQ_QA2", "NXQ-QA2票务"),
	CHANNEL_BILIBILI(71,"CHANNEL_BILIBILI","哔哩哔哩支付"),
	/**
	 * 淘宝系支付 - 目前为淘票票-后台下单
	 */
	TAOBAO(72,"TAOBAO","淘宝支付")
	;


	private int code;
	private String name;
	private String displayName;

	private PaymentMethodType(int code, String name, String displayName) {
		this.code = code;
		this.name = name;
		this.displayName = displayName;
	}

	public int getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public String getDisplayName() {
		return displayName;
	}

	public static int findCode(String name) {
		int code = -1;
		for (PaymentMethodType type : values()) {
			if (type.getName().equals(name)) {
				code = type.getCode();
				break;
			}
		}
		return code;
	}

	public static String findName(int code) {
		String name = "";
		for (PaymentMethodType type : values()) {
			if (type.getCode() == code) {
				name = type.getName();
				break;
			}
		}
		return name;
	}

	public static PaymentMethodType getPaymentMethodType(int code) {
		for (PaymentMethodType type : values()) {
			if (type.getCode() == code) {
				return type;
			}
		}
		return UNDEFINED;
	}

	public static PaymentMethodType getPaymentMethodType(String name) {
		for (PaymentMethodType type : values()) {
			if (type.getName().equals(name)) {
				return type;
			}
		}
		return UNDEFINED;
	}

}
