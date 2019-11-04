package com.pjx.demo2018.mock.test;

import com.alibaba.fastjson.JSON;
import com.juqitech.service.enums.BizCodeEnum;
import com.juqitech.service.utils.DateUtils;
import com.pjx.demo2018.mock.*;
import org.apache.commons.collections.CollectionUtils;
import org.junit.Test;

import java.util.*;

public class MockTest {

    @Test
    public void test() {
        System.out.println("====testBook");
        testBook();
        System.out.println("====testCreateRule");
        testCreateRule();
        System.out.println("=====testUpdateRule");
        testUpdateRule();
    }

    @Test
    public void testBook () {

        int i=80;
        List<OpenCabinetBookParam> bookParams = new ArrayList<>();
        String occupyStartTime = "2019-11-04 11:00:00";
        String occupyEndTime = "2019-11-05 11:00:00";

        String pickUpstartTime = "2019-11-04 18:00:00";
        String pickUpEndTime = occupyEndTime;

        String deliverStartTime = occupyStartTime;
        String deliverEndTime = "2019-11-04 17:00:00";

        OpenCabinetBookParam bookParam = new OpenCabinetBookParam();
        bookParam.setVenueId("5b7d12ff908c3815c682b035");
        bookParam.setPurchaseOrderId("po"+i);
        bookParam.setOrderId("order"+i);
        bookParam.setBookTime(new Date());
        bookParam.setTicketQty(1);
        bookParam.setDeliveryCodeStartTime(DateUtils.parseDateNewFormat(deliverStartTime));
        bookParam.setDeliveryCodeEndTime(DateUtils.parseDateNewFormat(deliverEndTime));
        bookParam.setPickupCodeStartTime(DateUtils.parseDateNewFormat(pickUpstartTime));
        bookParam.setPickupCodeEndTime(DateUtils.parseDateNewFormat(pickUpEndTime));
        bookParam.setSessionId("bookSessionId1");
        bookParam.setOccupyTimeStart(DateUtils.parseDateNewFormat(occupyStartTime));
        bookParam.setOccupyTimeEnd(DateUtils.parseDateNewFormat(occupyEndTime));

        bookParams.add(bookParam);

        i++;
        OpenCabinetBookParam bookParam1 = new OpenCabinetBookParam();
        bookParam1.setVenueId("5b7d12ff908c3815c682b035");
        bookParam1.setPurchaseOrderId("po"+i);
        bookParam1.setOrderId("order"+i);
        bookParam1.setBookTime(new Date());
        bookParam1.setTicketQty(2);
        bookParam1.setDeliveryCodeStartTime(DateUtils.parseDateNewFormat(deliverStartTime));
        bookParam1.setDeliveryCodeEndTime(DateUtils.parseDateNewFormat(deliverEndTime));
        bookParam1.setPickupCodeStartTime(DateUtils.parseDateNewFormat(pickUpstartTime));
        bookParam1.setPickupCodeEndTime(DateUtils.parseDateNewFormat(pickUpEndTime));
        bookParam1.setSessionId("bookSessionId1");
        bookParam1.setOccupyTimeStart(DateUtils.parseDateNewFormat(occupyStartTime));
        bookParam1.setOccupyTimeEnd(DateUtils.parseDateNewFormat(occupyEndTime));

        bookParams.add(bookParam1);

        i++;
        OpenCabinetBookParam bookParam2 = new OpenCabinetBookParam();
        bookParam2.setVenueId("5b7d12ff908c3815c682b035");
        bookParam2.setPurchaseOrderId("po"+i);
        bookParam2.setOrderId("order"+i);
        bookParam2.setBookTime(new Date());
        bookParam2.setTicketQty(2);
        bookParam2.setDeliveryCodeStartTime(DateUtils.parseDateNewFormat(deliverStartTime));
        bookParam2.setDeliveryCodeEndTime(DateUtils.parseDateNewFormat(deliverEndTime));
        bookParam2.setPickupCodeStartTime(DateUtils.parseDateNewFormat(pickUpstartTime));
        bookParam2.setPickupCodeEndTime(DateUtils.parseDateNewFormat(pickUpEndTime));
        bookParam2.setSessionId("bookSessionId1");
        bookParam2.setOccupyTimeStart(DateUtils.parseDateNewFormat(occupyStartTime));
        bookParam2.setOccupyTimeEnd(DateUtils.parseDateNewFormat(occupyEndTime));

        bookParams.add(bookParam2);

        i++;

        //冲突
        String occupyStartTime3 = "2019-11-04 14:00:00";
        String occupyEndTime3 = "2019-11-05 10:00:00";
        String pickUpstartTime3 = "2019-11-04 18:00:00";
        String pickUpEndTime3 = occupyEndTime3;
        String deliverStartTime3 = occupyStartTime3;
        String deliverEndTime3 = "2019-11-04 17:00:00";

        OpenCabinetBookParam bookParam3 = new OpenCabinetBookParam();
        bookParam3.setVenueId("5b7d12ff908c3815c682b035");
        bookParam3.setPurchaseOrderId("po"+i);
        bookParam3.setOrderId("order"+i);
        bookParam3.setBookTime(new Date());
        bookParam3.setTicketQty(4);
        bookParam3.setDeliveryCodeStartTime(DateUtils.parseDateNewFormat(deliverStartTime3));
        bookParam3.setDeliveryCodeEndTime(DateUtils.parseDateNewFormat(deliverEndTime3));
        bookParam3.setPickupCodeStartTime(DateUtils.parseDateNewFormat(pickUpstartTime3));
        bookParam3.setPickupCodeEndTime(DateUtils.parseDateNewFormat(pickUpEndTime3));
        bookParam3.setSessionId("bookSessionId1");
        bookParam3.setOccupyTimeStart(DateUtils.parseDateNewFormat(occupyStartTime3));
        bookParam3.setOccupyTimeEnd(DateUtils.parseDateNewFormat(occupyEndTime3));
        bookParams.add(bookParam3);

        i++;

        //和最开始相同
        String occupyStartTime4 = "2019-11-04 10:00:00";
        String occupyEndTime4 = "2019-11-05 11:00:00";
        String pickUpstartTime4 = "2019-11-04 18:00:00";
        String pickUpEndTime4 = occupyEndTime4;
        String deliverStartTime4 = occupyStartTime4;
        String deliverEndTime4 = "2019-11-04 17:00:00";

        OpenCabinetBookParam bookParam4 = new OpenCabinetBookParam();
        bookParam4.setVenueId("5b7d12ff908c3815c682b035");
        bookParam4.setPurchaseOrderId("po"+i);
        bookParam4.setOrderId("order"+i);
        bookParam4.setBookTime(new Date());
        bookParam4.setTicketQty(3);
        bookParam4.setDeliveryCodeStartTime(DateUtils.parseDateNewFormat(deliverStartTime4));
        bookParam4.setDeliveryCodeEndTime(DateUtils.parseDateNewFormat(deliverEndTime4));
        bookParam4.setPickupCodeStartTime(DateUtils.parseDateNewFormat(pickUpstartTime4));
        bookParam4.setPickupCodeEndTime(DateUtils.parseDateNewFormat(pickUpEndTime4));
        bookParam4.setSessionId("bookSessionId1");
        bookParam4.setOccupyTimeStart(DateUtils.parseDateNewFormat(occupyStartTime4));
        bookParam4.setOccupyTimeEnd(DateUtils.parseDateNewFormat(occupyEndTime4));
        bookParams.add(bookParam4);
        i++;

        //不冲突
        String occupyStartTime5 = "2019-11-08 10:00:00";
        String occupyEndTime5 = "2019-11-08 19:00:00";
        String pickUpstartTime5 = "2019-11-08 17:00:00";
        String pickUpEndTime5 = occupyEndTime5;
        String deliverStartTime5 = occupyStartTime5;
        String deliverEndTime5 = "2019-11-08 16:00:00";

        OpenCabinetBookParam bookParam5 = new OpenCabinetBookParam();
        bookParam5.setVenueId("5b7d12ff908c3815c682b035");
        bookParam5.setPurchaseOrderId("po"+i);
        bookParam5.setOrderId("order"+i);
        bookParam5.setBookTime(new Date());
        bookParam5.setTicketQty(3);
        bookParam5.setDeliveryCodeStartTime(DateUtils.parseDateNewFormat(deliverStartTime5));
        bookParam5.setDeliveryCodeEndTime(DateUtils.parseDateNewFormat(deliverEndTime5));
        bookParam5.setPickupCodeStartTime(DateUtils.parseDateNewFormat(pickUpstartTime5));
        bookParam5.setPickupCodeEndTime(DateUtils.parseDateNewFormat(pickUpEndTime5));
        bookParam5.setSessionId("bookSessionId1");
        bookParam5.setOccupyTimeStart(DateUtils.parseDateNewFormat(occupyStartTime5));
        bookParam5.setOccupyTimeEnd(DateUtils.parseDateNewFormat(occupyEndTime5));
        bookParams.add(bookParam5);

        String s = JSON.toJSONString(bookParams);
        System.out.println(s);


    }

    @Test
    public void testQuery() {
        try {

            String sessionTime = "2019-11-06 11:00";
            CabinetRuleQueryParam queryParam = new CabinetRuleQueryParam();
            queryParam.setBizCode(BizCodeEnum.MTL);
            queryParam.setNeedDefault(true);
            CabinetRuleDetailQueryParam detailQueryParam = new CabinetRuleDetailQueryParam();
            detailQueryParam.setBizCode(BizCodeEnum.MTL);
            detailQueryParam.setSessionId("showSessionId1");
            detailQueryParam.setSessionTime(DateUtils.parseNoSecondFormat(sessionTime));
            detailQueryParam.setVenueId("venueId1");

            String sessionTime1 = "2019-11-03 18:00";
            CabinetRuleDetailQueryParam detailQueryParam1 = new CabinetRuleDetailQueryParam();
            detailQueryParam1.setBizCode(BizCodeEnum.MTL);
            detailQueryParam1.setSessionId("showSessionId_1");
            detailQueryParam1.setSessionTime(DateUtils.parseNoSecondFormat(sessionTime1));
            detailQueryParam1.setVenueId("venueId_1");

            queryParam.setDetailQueryParams(Arrays.asList(detailQueryParam, detailQueryParam1));

            String s = JSON.toJSONString(queryParam);
            System.out.println("{\"param\":" + s + "}");
        } catch (Exception e) {

        }

    }

    @Test
    public void testCreateRule() {
        String sessionTime = "2019-11-06 11:00";
        String occupyTimeStart = "2019-11-06 00:00";
        String depositTimeEnd = "2019-11-06 18:00";
        String pickUpTimeStart = "2019-11-06 19:00";
        String occupyTimeEnd = "2019-11-06 23:00";
        CabinetRuleOperateParam operateParam = new CabinetRuleOperateParam();
        operateParam.setBizCode("MTL");
        operateParam.setShowId("showId");
//        operateParam.setExcludeShowSessionIds();
//        excludeShowSessionIds
        try {
            CabinetRuleOperateDetailParam detailParam = new CabinetRuleOperateDetailParam();
            detailParam.setBizCode("MTL");
            detailParam.setShowSessionId("showSessionId1");
            detailParam.setSessionTime(DateUtils.parseNoSecondFormat(sessionTime));
            detailParam.setVenueId("venueId1");
            detailParam.setOccupyTimeStart(DateUtils.parseNoSecondFormat(occupyTimeStart));
            detailParam.setDepositTimeEnd(DateUtils.parseNoSecondFormat(depositTimeEnd));
            detailParam.setPickUpTimeStart(DateUtils.parseNoSecondFormat(pickUpTimeStart));
            detailParam.setOccupyTimeEnd(DateUtils.parseNoSecondFormat(occupyTimeEnd));
            detailParam.setRangeType(RangeType.EXCLUDE);
            detailParam.setSellerIds(Arrays.asList("sellerId1", "sellerId2", "sellerId3"));


            String sessionTime1 = "2019-11-07 11:00";
            String occupyTimeStart1 = "2019-11-07 00:00";
            String depositTimeEnd1 = "2019-11-07 18:00";
            String pickUpTimeStart1 = "2019-11-07 19:00";
            String occupyTimeEnd1 = "2019-11-07 23:00";
            CabinetRuleOperateDetailParam detailParam1 = new CabinetRuleOperateDetailParam();
            detailParam1.setBizCode("MTL");
            detailParam1.setShowSessionId("showSessionId2");
            detailParam1.setSessionTime(DateUtils.parseNoSecondFormat(sessionTime1));
            detailParam1.setVenueId("venueId2");
            detailParam1.setOccupyTimeStart(DateUtils.parseNoSecondFormat(occupyTimeStart1));
            detailParam1.setDepositTimeEnd(DateUtils.parseNoSecondFormat(depositTimeEnd1));
            detailParam1.setPickUpTimeStart(DateUtils.parseNoSecondFormat(pickUpTimeStart1));
            detailParam1.setOccupyTimeEnd(DateUtils.parseNoSecondFormat(occupyTimeEnd1));
            detailParam1.setRangeType(RangeType.EXCLUDE);
            detailParam1.setSellerIds(Arrays.asList("sellerId2", "sellerId3"));

            operateParam.setOperateDetailParams(Arrays.asList(detailParam, detailParam1));
            String s = JSON.toJSONString(operateParam);
            System.out.println("{\"param\":" + s + "}");

        } catch (Exception e) {

        }


    }

    /**
     * "sellerId2", "sellerId3"
     * "sellerId1", "sellerId2", "sellerId4"
     */
    @Test
    public void testUpdateRule() {
        String sessionTime = "2019-11-06 11:30";
        String occupyTimeStart = "2019-11-06 00:30";
        String depositTimeEnd = "2019-11-06 18:30";
        String pickUpTimeStart = "2019-11-06 19:30";
        String occupyTimeEnd = "2019-11-06 23:30";
        CabinetRuleOperateParam operateParam = new CabinetRuleOperateParam();
        operateParam.setBizCode("MTL");
        operateParam.setShowId("showId");
//        operateParam.setExcludeShowSessionIds();
//        excludeShowSessionIds
        try {
            CabinetRuleOperateDetailParam detailParam = new CabinetRuleOperateDetailParam();
            detailParam.setBizCode("MTL");
            detailParam.setShowSessionId("showSessionId1");
            detailParam.setSessionTime(DateUtils.parseNoSecondFormat(sessionTime));
            detailParam.setVenueId("venueId1");
            detailParam.setOccupyTimeStart(DateUtils.parseNoSecondFormat(occupyTimeStart));
            detailParam.setDepositTimeEnd(DateUtils.parseNoSecondFormat(depositTimeEnd));
            detailParam.setPickUpTimeStart(DateUtils.parseNoSecondFormat(pickUpTimeStart));
            detailParam.setOccupyTimeEnd(DateUtils.parseNoSecondFormat(occupyTimeEnd));
            detailParam.setRangeType(RangeType.EXCLUDE);
            detailParam.setSellerIds(Arrays.asList("sellerId2", "sellerId3"));


            String sessionTime1 = "2019-11-07 11:30";
            String occupyTimeStart1 = "2019-11-07 00:30";
            String depositTimeEnd1 = "2019-11-07 18:30";
            String pickUpTimeStart1 = "2019-11-07 19:30";
            String occupyTimeEnd1 = "2019-11-07 23:30";
            CabinetRuleOperateDetailParam detailParam1 = new CabinetRuleOperateDetailParam();
            detailParam1.setBizCode("MTL");
            detailParam1.setShowSessionId("showSessionId2");
            detailParam1.setSessionTime(DateUtils.parseNoSecondFormat(sessionTime1));
            detailParam1.setVenueId("venueId2");
            detailParam1.setOccupyTimeStart(DateUtils.parseNoSecondFormat(occupyTimeStart1));
            detailParam1.setDepositTimeEnd(DateUtils.parseNoSecondFormat(depositTimeEnd1));
            detailParam1.setPickUpTimeStart(DateUtils.parseNoSecondFormat(pickUpTimeStart1));
            detailParam1.setOccupyTimeEnd(DateUtils.parseNoSecondFormat(occupyTimeEnd1));
            detailParam1.setRangeType(RangeType.EXCLUDE);
            detailParam1.setSellerIds(Arrays.asList("sellerId1", "sellerId2", "sellerId4"));

            operateParam.setOperateDetailParams(Arrays.asList(detailParam, detailParam1));
            String s = JSON.toJSONString(operateParam);
            System.out.println("{\"param\":" + s + "}");

        } catch (Exception e) {

        }
    }


    @Test
    public void testGetSellerIds() {
        List<String> list1 = new ArrayList<>();
        list1.add("5");
//        list1.add("2");
//        list1.add("3");
        List<String> list2 = new ArrayList<>();
        list2.add("2");
        list2.add("3");
        list2.add("4");

//        boolean b = list1.retainAll(list2);
//        System.out.println(list1); //[2, 3]
//        System.out.println(list2); //[2, 3, 4]
        System.out.println("CollectionUtils.retainAll");
        Collection retainAll = CollectionUtils.retainAll(list1, list2);
        System.out.println("公共" + retainAll); //[2, 3]
        System.out.println("新增" + CollectionUtils.removeAll(list2, retainAll)); //[2, 3]
        System.out.println(list1); //[1, 2, 3]
        System.out.println(list2); //[2, 3, 4]

        Collection removeAll = CollectionUtils.removeAll(list1, list2);
        System.out.println("remove");
        System.out.println("需要删除" + removeAll); //[1]
        System.out.println(list1); //[1, 2, 3]
        System.out.println(list2); //[2, 3, 4]

    }
}
