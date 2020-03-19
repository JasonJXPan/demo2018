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

}
