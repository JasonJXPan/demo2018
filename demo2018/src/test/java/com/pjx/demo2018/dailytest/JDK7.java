package com.pjx.demo2018.dailytest;
import java.text.DecimalFormat;
import java.util.ArrayList;
import	java.util.List;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import java.util.Date;

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
    @Data
    class DemandMarketVO {
        private String userOID;
        private String orderOID;
    }
}
