package com.pjx.demo2018.dailytest;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.TemporalField;
import java.util.*;
import java.util.concurrent.TimeUnit;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import lombok.Data;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

/**
 * Created by juqi on 18/11/1.
 */
public class JDK7 {
    private Logger logger = LoggerFactory.getLogger(JDK7.class);
    @Test
    public void test(){
        int a = 1_000_000;
        System.out.println(a);
        String x = "ab";
        switch (x) {
            case "a":
                System.out.println("wow");
                break;
            case "ab":
                System.out.println("yee");
                break;
            default:
                break;
        }
        Date date1 = new Date(1541088000000L);
        Date date2 = new Date(1541127600000L);
        System.out.println(date1.compareTo(date2));
    }
    @Test
    public void test2(){
        String x = "";
        List<String> list = new ArrayList<>();
        list.add(x);
        list.remove(x);
        System.out.println(String.join("-", "A", "B"));
        DecimalFormat addressFormat = new DecimalFormat("00");
        String locationId = StringUtils
                .join(addressFormat.format(9), addressFormat.format(5), addressFormat.format(11));
        System.out.println(locationId);
    }

    @Test
    public void test3() {
        final List<String> list = new ArrayList<>();
        List<String> data = new ArrayList<>();
        data.add("u1");
        data.add("2");
        data.add("3");
        data.stream().filter(item -> StringUtils.equals(item, "1")).forEach(item-> list.add(item));
        System.out.println(list);
        List<String> excludePurchaseOrderIds = new ArrayList<>();
        List<DemandMarketVO> demandByMetaDataOIDs = new ArrayList<>();
        DemandMarketVO demandMarketVO1 = new DemandMarketVO();
        demandMarketVO1.setOrderOID("o1");
        demandMarketVO1.setUserOID("u1");
        DemandMarketVO demandMarketVO2 = new DemandMarketVO();
        demandMarketVO2.setOrderOID("o2");
        demandMarketVO2.setUserOID("u2");
        demandByMetaDataOIDs.add(demandMarketVO1);
        demandByMetaDataOIDs.add(demandMarketVO2);
//        if (CollectionUtils.isEmpty(demandByMetaDataOIDs)) {
            //黑名单卖家不能使用取票柜
//            List<PurchaseOrderVo> purchaseOrderVos = orderService.findPurchaseOrderByIDs(purchaseOrderIds);
        demandByMetaDataOIDs.stream().filter(item -> data.contains(item.getUserOID()))
                    .forEach(item -> excludePurchaseOrderIds.add(item.getOrderOID()));
//            logger.debug("woca list={}", apolloConfig.getCabinetSellerBlackList());
//            logger.debug("woca contains={}", apolloConfig.getCabinetSellerBlackList().contains(purchaseOrderVos.get(0).getUserOID()));
            logger.debug("woca list={}", excludePurchaseOrderIds);
//            venueDTO.setExcludeToUseCabinetPoIds(excludePurchaseOrderIds);
//            return venueDTO;
//        }
        System.out.println(excludePurchaseOrderIds);

    }

    @Test
    public void  test123() {
        SellerCertificationQueryDTO queryDTO = new SellerCertificationQueryDTO();
        queryDTO.setSellerOID("sellerId");
        queryDTO.setShowOID("showId");
        queryDTO.setNeedPersonalRandomSeller(true);

        String bizId = StringUtils.join(Arrays.asList(queryDTO.getSellerOID(), queryDTO.getShowOID(), queryDTO.getNeedPersonalRandomSeller()), "");

        System.out.println(bizId);

        System.out.println(Boolean.valueOf("null"));
        System.out.println(Boolean.valueOf(null));
    }

    @Test
    public void test432() {
        Instant now = Instant.now();
//        System.out.println(now.get(new TemporalField().));
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDateTime minTime = localDateTime.with(LocalTime.MIN);
        LocalDateTime maxTime = localDateTime.with(LocalTime.MAX);
        System.out.println(minTime);
        System.out.println(maxTime);
        System.out.println(minTime.getYear());
        System.out.println(minTime.getMonthValue());
        System.out.println(minTime.getDayOfMonth());

    }

    @Test
    public void test3456() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try {
            Date parse = sdf.parse("2020-03-17 13:00:00");
            System.out.println(parse);
            Date now = sdf.parse("2020-03-17 13:10:00");
            long diff = sdf.parse(sdf.format(now)).getTime()-parse.getTime();
            System.out.println(diff);

            long diff1 = now.getTime() - parse.getTime();
            System.out.println(diff1==diff);
        } catch (ParseException e) {
            e.printStackTrace();
        }
//        Date d = sdf.parse(orderVOByOrderOID.getCreateTime()+"");
//        Date now = Calendar.getInstance().getTime();
//        long diff = sdf.parse(sdf.format(now)).getTime()-d.getTime();
    }


    @Test
    public void testSeri() {
        MyShow myShow = new MyShow();
        myShow.setShowOID("sh");
        myShow.setVenueName("ve");
        myShow.setAddress("ad");
        myShow.setIsPermanent(true);
        ObjectMapper objectMapper = new ObjectMapper();
        String s = null;
        try {
            s = objectMapper.writeValueAsString(myShow);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println(s);
        try {
            MyShow myShow1 = objectMapper.readValue(s, MyShow.class);
            System.out.println(myShow1);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testSeri1() {
        MyShow myShow = new MyShow();
        myShow.setShowOID("sh");
        myShow.setVenueName("ve");
        myShow.setAddress("ad");
        myShow.setIsPermanent(true);
//        ObjectMapper objectMapper = new ObjectMapper();
        String s = null;
//        try {
            s = JSON.toJSONString(myShow);
//            s = objectMapper.writeValueAsString(myShow);
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }
        System.out.println(s);
//        try {
            MyShow myShow1 = JSON.parseObject(s, MyShow.class);
            System.out.println(myShow1);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }


    @Test
    public void testSe() {
        Map<String, Object> map = new HashMap<>(10);
        map.put("a", "a");
        map.put("b", true);

        String s = JSON.toJSONString(map);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String s1 = objectMapper.writeValueAsString(map);
            System.out.println(s1);
            Map map1 = JSON.parseObject(s1, Map.class);
            System.out.println(map1);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println(s);
    }

    @Test
    public void testAVC() {
        StringBuilder stringBuilder = new StringBuilder(16);
        stringBuilder.append("1234567890");
        stringBuilder.append("1234567890");
        stringBuilder.append("1234567890");
        System.out.println(stringBuilder.toString());
    }
//.removalListener(((key, value, cause) -> {
//        System.out.println("清除："+String.join(":", key.toString(), cause.toString()));
//    }))
    @Test
    public void testCaffeine1() {
        Cache<String, String> myCache = Caffeine.newBuilder()
                .initialCapacity(2)
                .maximumSize(4)
                .expireAfterWrite(5, TimeUnit.SECONDS)
                .removalListener(((key, value, cause) -> {
                    System.out.println("清除：" + String.join(":", key.toString(), cause.toString()));
                }))
                .build();
        System.out.println("初始点："+myCache.asMap().size());
        System.out.println("初始点："+myCache.asMap());
        myCache.put("1", "1");
        myCache.getIfPresent("1");
        myCache.put("2", "1");
        myCache.put("3", "1");
        myCache.getIfPresent("1");
        myCache.put("4", "1");
        myCache.put("5", "1");
        myCache.put("6", "1");
        myCache.getIfPresent("1");
        myCache.put("7", "1");
        myCache.put("8", "1");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {

        }
        System.out.println("放置8个后："+myCache.asMap().size());
        System.out.println("放置8个后："+myCache.asMap());
        myCache.getIfPresent("1");
        myCache.put("9", "1");
        myCache.getIfPresent("9");
        myCache.getIfPresent("9");
        myCache.getIfPresent("9");
        myCache.put("10", "1");
        myCache.put("11", "1");
        myCache.put("12", "1");
        myCache.put("13", "1");
        myCache.put("14", "1");
        myCache.put("15", "1");
        myCache.put("16", "1");
        myCache.put("17", "1");
        System.out.println("放置17个后："+myCache.asMap().size());
        System.out.println("放置17个后："+myCache.asMap());
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {

        }
        System.out.println("放置17个后-1："+myCache.asMap().size());
        System.out.println("放置17个后-1："+myCache.asMap());
        System.out.println("放置17个后-2："+myCache.asMap().size());
        System.out.println("放置17个后-2："+myCache.asMap());
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("缓存超时后："+myCache.asMap().size());
        System.out.println("缓存超时后："+myCache.asMap());

        myCache.put("1", "1");
        myCache.put("2", "1");
        myCache.put("3", "1");
        myCache.put("4", "1");
        myCache.put("5", "1");
        myCache.put("6", "1");
        myCache.put("7", "1");
        myCache.put("8", "1");
        myCache.put("9", "1");
        myCache.put("10", "1");
        myCache.put("11", "1");
        myCache.put("12", "1");
        System.out.println("第二次放置12个后-pre："+myCache.asMap().size());
        System.out.println("第二次放置12个后-pre："+myCache.asMap());
        myCache.put("13", "1");
        myCache.put("14", "1");
        myCache.put("15", "1");
        myCache.put("16", "1");
        myCache.put("17", "1");
        System.out.println("第二次放置17个后："+myCache.asMap().size());
        System.out.println("第二次放置17个后："+myCache.asMap());
        System.out.println("第二次放置17个后-1："+myCache.asMap().size());
        System.out.println("第二次放置17个后-1："+myCache.asMap());
        System.out.println("第二次放置17个后-2："+myCache.asMap().size());
        System.out.println("第二次放置17个后-2："+myCache.asMap());
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("第二次缓存超时后："+myCache.asMap().size());
        System.out.println("第二次缓存超时后："+myCache.asMap());
    }

    @Test
    public void test111() {
        PostCreateOrderDTO.PostCreateOrderDTOBuilder builder = PostCreateOrderDTO.builder();
        builder.orderId("1");
        builder.agreeTime(new Date());

        System.out.println(builder.build());
        String msg = JSON.toJSONString(builder.build());

        System.out.println(JSON.parseObject(msg, PostCreateOrderDTO.class));
    }



    @Data
    class DemandMarketVO {
        private String userOID;
        private String orderOID;
    }

    @Data
    class SellerCertificationQueryDTO {
        private String sellerOID;
        private String showOID;
        private Boolean needPersonalRandomSeller;
    }

    @Test
    public void testPayment () {
        StringBuilder sb
                 = new StringBuilder();
        for (PaymentMethodType pay : PaymentMethodType.values()) {
            sb.append(" WHEN tm_order.payment = '"+pay.getName()+"' THEN '"+pay.getDisplayName()+"' \n\r");
        }
        System.out.println(sb.toString());
    }

    @Test
    public void testPayment1 () {
        StringBuilder sb
                = new StringBuilder();
        for (PaymentMethodType pay : PaymentMethodType.values()) {
            sb.append(""+pay.getName()+" 表示 "+pay.getDisplayName()+" \n\r");
        }
        System.out.println(sb.toString());
    }


    enum PaymentMethodType {

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
        CHANNEL_PIAOXINGQIU(37,"Channel_piaoxingqiu","票小二支付"),
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
         * 淘宝支付 - 目前为淘票票-后台下单
         */
        TAOBAO(72,"TAOBAO","淘宝支付"),
        ALIPAY_PXQ(73, "ALIPAY_PXQ", "支付宝-票星球"),
        WEIXIN_PXQ(74, "WEIXIN_PXQ", "微信-票星球"),
        CHANNEL_ENJOY_LIFE(75,"CHANNEL_ENJOY_LIFE","享生活支付"),


        CHANNEL_NXQ_BYPW(76,"CHANNEL_NXQ_BYPW","NXQ-北娱票务支付"),
        CHANNEL_NXQ_DDTP(77,"CHANNEL_NXQ_DDTP","NXQ-铛铛淘票网支付"),
        CHANNEL_NXQ_FSYL(78,"CHANNEL_NXQ_FSYL","NXQ-范丝娱乐支付"),
        CHANNEL_NXQ_GJPW(79,"CHANNEL_NXQ_GJPW","NXQ-高集票务支付"),
        CHANNEL_NXQ_HPCM(80,"CHANNEL_NXQ_HPCM","NXQ-杭票传媒支付"),
        CHANNEL_NXQ_JJXWH(81,"CHANNEL_NXQ_JJXWH","NXQ-金聚星文化支付"),
        CHANNEL_NXQ_SDPW(82,"CHANNEL_NXQ_SDPW","NXQ-时代票网支付"),
        CHANNEL_NXQ_SZXNY(83,"CHANNEL_NXQ_SZXNY","NXQ-苏州小娘鱼支付"),
        CHANNEL_NXQ_XGQN(84,"CHANNEL_NXQ_XGQN","NXQ-斜杠青年支付"),
        CHANNEL_NXQ_XP(85,"CHANNEL_NXQ_XP","NXQ-星票支付"),
        CHANNEL_NXQ_ZXYY(86,"CHANNEL_NXQ_ZXYY","NXQ-众星演绎支付"),
        CHANNEL_NXQ_ZBPWW(87,"CHANNEL_NXQ_ZBPWW","NXQ-醉摆票务网支付"),


        ACTIVITY_ENROLL(88,"ACTIVITY_ENROLL","活动报名"),
        CHANNEL_AGENT_SEEK_AUTO(89, "CHANNEL_AGENT_SEEK_AUTO", "寻票自动撮合支付"),
        CHANNEL_AGENT_SEEK_MANUAL(90, "CHANNEL_AGENT_SEEK_MANUAL", "寻票手动撮合支付"),

        CHANNEL_NXQ_1010(91, "CHANNEL_NXQ_1010", "NXQ-1010票务"),
        CHANNEL_NXQ_BAIHU(92, "CHANNEL_NXQ_BAIHU", "NXQ-白虎票务"),
        CHANNEL_NXQ_DAXIAO(93, "CHANNEL_NXQ_DAXIAO", "NXQ-大小票务"),
        CHANNEL_NXQ_DEXI(94, "CHANNEL_NXQ_DEXI", "NXQ-德兮票务"),
        CHANNEL_NXQ_JIXIANG(95, "CHANNEL_NXQ_JIXIANG", "NXQ-吉祥票网"),
        CHANNEL_NXQ_XIANGPIAO(96, "CHANNEL_NXQ_XIANGPIAO", "NXQ-享票"),
        CHANNEL_NXQ_XINGKONG(97, "CHANNEL_NXQ_XINGKONG", "NXQ-星空票务"),
        CHANNEL_NXQ_XINGRUI(98, "CHANNEL_NXQ_XINGRUI", "NXQ-星锐娱乐"),
        CHANNEL_NXQ_GUANGMENG(100, "CHANNEL_NXQ_GUANGMENG", "NXQ-广盟票务"),

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

}
