package com.pjx.demo2018.dailytest;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.gson.Gson;
import com.juqitech.service.scheduler.SchedulerConstants;
import com.juqitech.service.utils.DESUtils;
import com.juqitech.service.utils.MD5Utils;
import com.pjx.demo2018.dailytest.cabinet.CabinetDrawerInfo;
import com.pjx.demo2018.dailytest.cabinet.CabinetDrawerListParam;
import com.pjx.demo2018.dailytest.cabinet.CreateAsyncOrderJobDTO;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.*;

/**
 * Created by juqi on 18/8/23.
 */
public class DesUti {
    private static String DESKEY="juqitech";
    @Test
    public void test(){
        String password = "s0tJweBqCUAOoAsV6mDDUQ==";
        try {
            String pwd = DESUtils.decryptBase64(password, DESKEY);
            System.out.println(pwd);
            pwd = DigestUtils.md5Hex(pwd);
            System.out.println(pwd);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    @Test
    public void test1234() {
        String x ="142727199306300316";
        String s = null;
        try {
            s = MD5Utils.string2MD5(x);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        System.out.println(s);
    }
    @Test
    public void test1(){
        String password = "沈庆杰";
        try {
            String pwd = DESUtils.decryptHex(password, DESKEY);
            System.out.println(pwd);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void test2() {
        StringBuilder signBuilder = new StringBuilder();
        String nonce = GenerateUUID.generate(32);;
        signBuilder.append("bdaa0655a14e4f3fa55e6aac5cde5e7a").append("00301-310104-0001-01")
                .append(nonce).append("e40ffca390934028b440fa0025682ab8");

        try {
            String signStr = MD5Utils.string2MD5(signBuilder.toString());
            System.out.println(nonce);
            System.out.println(signStr);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
//            throw new BizException("生成签名失败");
        }
    }

    @Test
    public void test3() {
        CabinetDrawerListParam param = new CabinetDrawerListParam("00301-310104-0001-01");
//        param.setCabinetNo();
        System.out.println(new Gson().toJson(param));
        System.out.println(param.getNonce().length());


//        StringBuilder signBuilder = new StringBuilder();
//        String nonce = GenerateUUID.generate(32);;
//        signBuilder.append("bdaa0655a14e4f3fa55e6aac5cde5e7a").append("00301-310104-0001-01")
//                .append(nonce).append("e40ffca390934028b440fa0025682ab8");
//
//        try {
//            String signStr = MD5Utils.string2MD5(signBuilder.toString());
//            System.out.println(nonce);
//            System.out.println(signStr);
//        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
////            throw new BizException("生成签名失败");
//        }
    }

    @Test
    public void test5() {
        String x = "{\"a\":\"a\"}";
        Gson gson = new Gson();
        CabinetDrawerInfo cabinetDrawerInfo = gson.fromJson(x, CabinetDrawerInfo.class);
        System.out.println(cabinetDrawerInfo);

        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.forEach(item -> {
            if (item.equals("2")) {
                return;
            }
            System.out.println(item);
        });
    }

    @Test
    public void test6() {
        String MSG_CONTENT_TEMPLATE = "您有一个新订单! %d元";

        String format = String.format(MSG_CONTENT_TEMPLATE, "10");
        System.out.println(format);
    }


    @Test
    public void test7() throws IOException {
        String message = "{\"originalPrice\":244.0,\"userOID\":\"5e4fc5904c7e6a6b2dbd6937\",\"quickDelivery\":0,\"seatComments\":\" \",\"seatPlanPrice\":244.0,\"originalPriceComment\":\"说明【测试】\",\"orderOID\":\"5e5375a80ffd4e5002aa6aa0\",\"compensatedPrice\":0.0,\"total\":244.0,\"price\":244.0,\"ticketOID\":\"5e5374984c7e6a62d439d5fe\",\"productType\":\"STANDARD\",\"showSessionOID\":\"5e5373f10ffd4e4aaec61c80\",\"guaranteeFee\":13.0,\"showName\":\"不添加自定义票面Y0224\",\"orderItemOID\":\"5e5375a80ffd4e5002aa6aa3\",\"sessionName\":\"2020-03-07 星期六12:00\",\"display\":false,\"seatPlanOID\":\"5e5373f10ffd4e4aaec61c81\",\"sessionTime\":\"2020-03-07 12:00\",\"totalTicketsSalePrice\":257.00,\"seatPlanName\":null,\"showOID\":\"5e5373f10ffd4e4aaec61c7f\",\"payTicketPeriod\":null,\"qty\":1,\"allocTypeCode\":0}";

        Map<String, Object> param = new ObjectMapper().readValue(message, Map.class);

        String seatPlanName = null;
        if (param.get("seatPlanName") != null) {
            seatPlanName = param.get("seatPlanName") + "";
        }
        System.out.println(seatPlanName);
    }

    @Test
    public void test8() throws JsonProcessingException {

        String orderId = "1234";
        Map<String, String> jobAttributes = new HashMap<>();
        jobAttributes.put("orderOID", orderId);

        CreateAsyncOrderJobDTO dto = new CreateAsyncOrderJobDTO();
        dto.setJobPrefix(SchedulerConstants.EXPIRE_ORDER);
        dto.setJobId(orderId);
        dto.setJobAttributes(jobAttributes);
        dto.setTriggerStartTime(new Date());

        ObjectMapper mapper = (new ObjectMapper()).configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        String messageStr = mapper.writeValueAsString(dto);
        System.out.println(jobAttributes);
        System.out.println(messageStr);
        CreateAsyncOrderJobDTO dto1 = JSON.parseObject(messageStr, CreateAsyncOrderJobDTO.class);
        System.out.println(dto1);
        System.out.println(dto1.getJobAttributes());
        System.out.println(jobAttributes.equals(dto1.getJobAttributes()));
    }

    @Test
    public void test8_1() {
        float a = 0.1f;
        float b = 0.1f;
        System.out.println(a == b);

        String x = "123";
        String y = "123";
        System.out.println(x == y);

        String x1 = new String("123");
        String x2 = new String("123");
        System.out.println(x1 == x2);
        System.out.println(x == x1);
        System.out.println(x == x2);
    }
}
