package com.pjx.demo2018.mock.test;

import com.alibaba.fastjson.JSON;
import com.juqitech.service.utils.DateUtils;
import com.pjx.demo2018.mock.CabinetRuleOperateDetailParam;
import com.pjx.demo2018.mock.CabinetRuleOperateParam;
import com.pjx.demo2018.mock.RangeType;
import org.junit.Test;

import java.util.Arrays;

public class MockTest {

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
            operateParam.setOperateDetailParams(Arrays.asList(detailParam));
            String s = JSON.toJSONString(operateParam);
            System.out.println("{\"param\":"+s+"}");

        }catch (Exception e) {

        }


    }
}
