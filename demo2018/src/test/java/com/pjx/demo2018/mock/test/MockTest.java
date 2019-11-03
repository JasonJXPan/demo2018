package com.pjx.demo2018.mock.test;

import com.alibaba.fastjson.JSON;
import com.juqitech.service.enums.BizCodeEnum;
import com.juqitech.service.utils.DateUtils;
import com.pjx.demo2018.mock.*;
import org.apache.commons.collections.CollectionUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class MockTest {

    @Test
    public void test() {
        testCreateRule();
        System.out.println("=============");
        System.out.println("=============");
        testUpdateRule();
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
