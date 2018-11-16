package com.pjx.demo2018.dailytest.mtlorder;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.juqitech.service.utils.DateUtils;
import com.pjx.demo2018.dailytest.mtlorder.dto.OrderOverdueCompensateRule;
import com.pjx.demo2018.dailytest.mtlorder.dto.OrderOverdueCompensateRuleDetailDTO;
import com.pjx.demo2018.dailytest.mtlorder.dto.OverdueCompensateTransfer;
import org.apache.commons.collections.CollectionUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by juqi on 18/11/15.
 */
public class TestCompensateRule {

    private static Logger logger = LoggerFactory.getLogger(TestCompensateRule.class);
    @Test
    public void test1() {
        Gson gson = new Gson();
        OrderOverdueCompensateRuleDetailDTO detailDTO = new OrderOverdueCompensateRuleDetailDTO();
        detailDTO.setAmount(new BigDecimal(50));
        detailDTO.setMaxDays(5L);
        detailDTO.setMinDays(0L);
        OrderOverdueCompensateRuleDetailDTO detailDTO1 = new OrderOverdueCompensateRuleDetailDTO();
        detailDTO1.setAmount(new BigDecimal(5));
        detailDTO1.setMaxDays(30L);
        detailDTO1.setMinDays(5L);
        detailDTO1.setDaysStep(new BigDecimal(1));
        List<OrderOverdueCompensateRuleDetailDTO> list = new ArrayList<>();
        list.add(detailDTO);
        list.add(detailDTO1);
        OrderOverdueCompensateRule compensateRule = new OrderOverdueCompensateRule();
        compensateRule.setDelimitDateFrom(new Date(1262275200000L));
        compensateRule.setDelimitDateEnd(new Date(1541088000000L));
        compensateRule.setRuleDetails(list);
//        System.out.println(compensateRule);
        String s = gson.toJson(compensateRule);
        System.out.println(s);
        Type type = new TypeToken<OrderOverdueCompensateRule>() {
        }.getType();
        OrderOverdueCompensateRule o = gson.fromJson(s, type);
        System.out.println(o);
    }

    @Test
    public void test2() {
        Gson gson = new Gson();
        OrderOverdueCompensateRuleDetailDTO detailDTO = new OrderOverdueCompensateRuleDetailDTO();
        detailDTO.setAmount(new BigDecimal(10));
        detailDTO.setMinDays(0L);
        detailDTO.setMaxDays(3L);
        OrderOverdueCompensateRuleDetailDTO detailDTO1 = new OrderOverdueCompensateRuleDetailDTO();
        detailDTO1.setAmount(new BigDecimal(10));
        detailDTO1.setMinDays(3L);
        detailDTO1.setMaxDays(7L);
        OrderOverdueCompensateRuleDetailDTO detailDTO2 = new OrderOverdueCompensateRuleDetailDTO();
        detailDTO2.setAmount(new BigDecimal(5));
        detailDTO2.setMinDays(7L);
        detailDTO2.setMaxDays(23L);
        detailDTO2.setDaysStep(new BigDecimal(1));

        List<OrderOverdueCompensateRuleDetailDTO> list = new ArrayList<>();
        list.add(detailDTO);
        list.add(detailDTO1);
        list.add(detailDTO2);
        OrderOverdueCompensateRule compensateRule = new OrderOverdueCompensateRule();
        compensateRule.setDelimitDateFrom(new Date(1541088000000L));
        compensateRule.setDelimitDateEnd(new Date(1542643200000L));
        compensateRule.setRuleDetails(list);
        String s = gson.toJson(compensateRule);
        System.out.println(s);
        Type type = new TypeToken<OrderOverdueCompensateRule>() {
        }.getType();
        OrderOverdueCompensateRule o = gson.fromJson(s, type);
        System.out.println(o);
    }

    @Test
    public void test3() {
        Gson gson = new Gson();
        OrderOverdueCompensateRuleDetailDTO detailDTO = new OrderOverdueCompensateRuleDetailDTO();
        detailDTO.setAmount(new BigDecimal(10));
        detailDTO.setMinDays(0L);
        detailDTO.setMaxDays(3L);
        OrderOverdueCompensateRuleDetailDTO detailDTO1 = new OrderOverdueCompensateRuleDetailDTO();
        detailDTO1.setAmount(new BigDecimal(20));
        detailDTO1.setMinDays(3L);
        detailDTO1.setMaxDays(7L);
        OrderOverdueCompensateRuleDetailDTO detailDTO2 = new OrderOverdueCompensateRuleDetailDTO();
        detailDTO2.setAmount(new BigDecimal(5));
        detailDTO2.setMinDays(7L);
        detailDTO2.setMaxDays(21L);
        detailDTO2.setDaysStep(new BigDecimal(1));

        List<OrderOverdueCompensateRuleDetailDTO> list = new ArrayList<>();
        list.add(detailDTO);
        list.add(detailDTO1);
        list.add(detailDTO2);
        OrderOverdueCompensateRule compensateRule = new OrderOverdueCompensateRule();
        compensateRule.setDelimitDateFrom(new Date(1542643200000L));
        compensateRule.setDelimitDateEnd(new Date(4070880000000L));
        compensateRule.setRuleDetails(list);
        String s = gson.toJson(compensateRule);
        System.out.println(s);
        Type type = new TypeToken<OrderOverdueCompensateRule>() {
        }.getType();
        OrderOverdueCompensateRule o = gson.fromJson(s, type);
        System.out.println(o);
    }

    @Test
    public void test4() {
        String x1 = "{\"delimitDateFrom\":\"Jan 1, 2010 12:00:00 AM\",\"delimitDateEnd\":\"Nov 2, 2018 12:00:00 AM\",\"ruleDetails\":[{\"amount\":50,\"minDays\":0,\"maxDays\":5},{\"amount\":5,\"minDays\":5,\"maxDays\":30,\"daysStep\":1}]}";
        String x2 = "{\"delimitDateFrom\":\"Nov 2, 2018 12:00:00 AM\",\"delimitDateEnd\":\"Nov 20, 2018 12:00:00 AM\",\"ruleDetails\":[{\"amount\":10,\"minDays\":0,\"maxDays\":3},{\"amount\":10,\"minDays\":3,\"maxDays\":7},{\"amount\":5,\"minDays\":7,\"maxDays\":23,\"daysStep\":1}]}";
        String x3 = "{\"delimitDateFrom\":\"Nov 20, 2018 12:00:00 AM\",\"delimitDateEnd\":\"Jan 1, 2099 12:00:00 AM\",\"ruleDetails\":[{\"amount\":10,\"minDays\":0,\"maxDays\":3},{\"amount\":20,\"minDays\":3,\"maxDays\":7},{\"amount\":5,\"minDays\":7,\"maxDays\":21,\"daysStep\":1}]}";

        List<OrderOverdueCompensateRule> list = new ArrayList<>();
        Gson gson = new Gson();
        list.add(gson.fromJson(x1, OrderOverdueCompensateRule.class));
        list.add(gson.fromJson(x2, OrderOverdueCompensateRule.class));
        list.add(gson.fromJson(x3, OrderOverdueCompensateRule.class));

        //5天 345600100
        //1天 3674617
        //9天 746503906
//        String testData = "{    \"overdue_time_gap\": 746503906,    \"overdue_timestamp\": \"2018-11-01 23:59:59\"  }";
//        String testData = "{    \"overdue_time_gap\": 3674617,    \"overdue_timestamp\": \"2018-11-01 23:59:59\"  }";
//        String testData = "{    \"overdue_time_gap\": 3674617,    \"overdue_timestamp\": \"2018-11-10 23:59:59\"  }";
//        String testData = "{    \"overdue_time_gap\": 345600100,    \"overdue_timestamp\": \"2018-11-10 23:59:59\"  }";
//        String testData = "{    \"overdue_time_gap\": 746503906,    \"overdue_timestamp\": \"2018-11-10 23:59:59\"  }";
//        String testData = "{    \"overdue_time_gap\": 3674617,    \"overdue_timestamp\": \"2018-11-30 23:59:59\"  }";
//        String testData = "{    \"overdue_time_gap\": 345600100,    \"overdue_timestamp\": \"2018-11-30 23:59:59\"  }";
        String testData = "{    \"overdue_time_gap\": 746503906,    \"overdue_timestamp\": \"2018-11-30 23:59:59\"  }";
//        OverdueCompensateTransfer overdueCompensateTransfer = gson.fromJson(testData, OverdueCompensateTransfer.class);


        String data = "[  {    \"overdue_time_gap\": 3674617,    \"overdue_timestamp\": \"2018-11-01 23:59:59\"  },  {    \"overdue_time_gap\": 345600100,    \"overdue_timestamp\": \"2018-11-01 23:59:59\"  },  {    \"overdue_time_gap\": 746503906,    \"overdue_timestamp\": \"2018-11-01 23:59:59\"  },  {    \"overdue_time_gap\": 3674617,    \"overdue_timestamp\": \"2018-11-10 23:59:59\"  },  {    \"overdue_time_gap\": 345600100,    \"overdue_timestamp\": \"2018-11-10 23:59:59\"  },  {    \"overdue_time_gap\": 746503906,    \"overdue_timestamp\": \"2018-11-10 23:59:59\"  },  {    \"overdue_time_gap\": 3674617,    \"overdue_timestamp\": \"2018-11-30 23:59:59\"  },  {    \"overdue_time_gap\": 345600100,    \"overdue_timestamp\": \"2018-11-30 23:59:59\"  },  {    \"overdue_time_gap\": 746503906,    \"overdue_timestamp\": \"2018-11-30 23:59:59\"  }]";

        Type type = new TypeToken<List<OverdueCompensateTransfer>>(){}.getType();
        List<OverdueCompensateTransfer> overdueCompensateTransfers = gson.fromJson(data, type);
        for (OverdueCompensateTransfer item : overdueCompensateTransfers) {
            calculateFinal(item, list);
        }
//        OverdueCompensateTransfer t1 = new OverdueCompensateTransfer();
//        t1.setOverdue_time_gap(99L);
//        t1.setOverdue_timestamp(new Timestamp(11111111L));
//        OverdueCompensateTransfer t2 = new OverdueCompensateTransfer();
//        t2.setOverdue_time_gap(99L);
//        t2.setOverdue_timestamp(new Timestamp(11111111L));
//        List<OverdueCompensateTransfer> transfers = new ArrayList<>();
//        transfers.add(t1);
//        transfers.add(t2);
//        System.out.println(gson.toJson(transfers));



    }
    private void calculateFinal(OverdueCompensateTransfer overdueCompensateTransfer, List<OrderOverdueCompensateRule> list) {
        Timestamp overdueTimestamp = overdueCompensateTransfer.getOverdue_timestamp();
        long overdueGap = overdueCompensateTransfer.getOverdue_time_gap();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("逾期时间"+ overdueCompensateTransfer.getOverdue_timestamp());
        OrderOverdueCompensateRule orderOverdueCompensateRule =
                chooseSuitableRule(list, overdueTimestamp);
        if (orderOverdueCompensateRule == null) {
            logger.error("当前没有找到逾期规则 overdueGap={}", overdueGap);
            return;
        }
        BigDecimal result = calculateCompensateByRule(orderOverdueCompensateRule, overdueGap, stringBuilder);
        stringBuilder.append(",赔付金额"+result);
        stringBuilder.append(",规则匹配开始时间:"+DateUtils.getNewFormatDateString(orderOverdueCompensateRule.getDelimitDateFrom())
                +", 截止时间:"+DateUtils.getNewFormatDateString(orderOverdueCompensateRule.getDelimitDateEnd()));
        System.out.println(stringBuilder.toString());
    }

    /**
     * 根据约束时间和订单的逾期时间确定唯一一条逾期赔付规则
     *
     * @param rulesByType
     * @param overdueTimestamp
     * @return
     */
    private OrderOverdueCompensateRule chooseSuitableRule(List<OrderOverdueCompensateRule> rulesByType, Timestamp overdueTimestamp) {
        if (CollectionUtils.isEmpty(rulesByType)) {
            return null;
        }

        for (OrderOverdueCompensateRule item : rulesByType) {
            if (item.getDelimitDateFrom().compareTo(overdueTimestamp) <= 0
                    && overdueTimestamp.compareTo(item.getDelimitDateEnd()) < 0) {
                return item;
            }
        }
        return null;
    }

    private BigDecimal calculateCompensateByRule(OrderOverdueCompensateRule orderOverdueCompensateRule, long overdueGap, StringBuilder stringBuilder) {
        BigDecimal result = BigDecimal.ZERO;
        Long daysOverdue = overdueGap / DateUtils.ONE_DAY_MILL_SECONDS;
        if (overdueGap % DateUtils.ONE_DAY_MILL_SECONDS >0) {
            daysOverdue += 1;
        }
        stringBuilder.append(",逾期"+daysOverdue+"天");
        for (OrderOverdueCompensateRuleDetailDTO ruleDetail : orderOverdueCompensateRule.getRuleDetails()) {
            result = result.add(calculateCompensateByRuleDetail(ruleDetail, daysOverdue));
        }
        return result;
    }

    /**
     *
     * @param ruleDetail
     * @param daysOverdue
     * @return
     */
    private BigDecimal calculateCompensateByRuleDetail(OrderOverdueCompensateRuleDetailDTO ruleDetail, Long daysOverdue) {
        BigDecimal result = BigDecimal.ZERO;

        //不满足最低逾期天数，则不能匹配改规则
        if (daysOverdue.compareTo(ruleDetail.getMinDays())<=0){
            return result;
        }

        //如果步进不为null  当前规则的赔付金额为 step*amount
        if (ruleDetail.getDaysStep() != null) {
            Long daysUsedInCalculation = daysOverdue-ruleDetail.getMinDays();
            Long maxDays = ruleDetail.getMaxDays() - ruleDetail.getMinDays();
            //如果规则内逾期天数差额大于当前规则的（最大逾期天数-最小天数），使用规则的（最大逾期天数-最小天数）计算赔付金
            if (daysUsedInCalculation.compareTo(maxDays) > 0) {
                daysUsedInCalculation = maxDays;
            }
            result = new BigDecimal(daysUsedInCalculation).multiply(ruleDetail.getAmount());
        } else {
            //如果步进为null， 则直接使用amount
            result = ruleDetail.getAmount();
        }
        return result;
    }

}
