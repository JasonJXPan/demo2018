package com.pjx.demo2018.singletest;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.juqitech.service.utils.DateUtils;
import com.juqitech.service.vo.resource.ResourceVo;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.*;

/**
 * Created by juqi on 18/5/25.
 */
public class SingleTest {

    static final String DEPRECATE_REG_VERSION = "^(\\[).*?(\\])$";

    @Data
    public static class A {
        private BigDecimal a;
    }
    public static void main(String[] args) {
//        System.out.println(Boolean.TRUE.equals(null));
//        System.out.println(Boolean.TRUE.equals(true));
//        System.out.println(Boolean.TRUE.equals(false));
//        System.out.println(Boolean.FALSE.equals(null));
//        System.out.println(Boolean.FALSE.equals(false));
//        System.out.println(Boolean.FALSE.equals(true));


        String x1 = "取票链接< https://q.tking.cn/5df231ae069b3e751c6bbcd6&258004 >。您订购的 280票面 1 张 【北京站】俄罗斯亚历山大红旗歌舞团2019年巡演 2019-12-13 19:30 人民大会堂 请提前一小时至 北京市西城区西长安街街道国家电网充电站(国家大剧院)国家大剧院，联系商家：吉祥票网，您可点击短信链接或打开摩天轮APP订单联系卖家。 进行取票！温馨提醒：由于现场票务特殊性，最晚取票时间截止为开场后半小时。(摩天轮要求商家不能以任何名义与用户私下协商退补票款，如遇问题，请联系客服热线：10102266)";

        String string1 = "asfdadsf取票URL";

        String s2 = string1.replace("取票URL", "adfadfasdf");
        System.out.println(string1);
        System.out.println(s2);
        int start = StringUtils.indexOfIgnoreCase(x1, "取票链接<");
        int end = StringUtils.indexOfIgnoreCase(x1, ">");

//        System.out.println(StringUtils.indexOfIgnoreCase(x1, "<="));
//        System.out.println(StringUtils.indexOfIgnoreCase(x1, "<"));
//        System.out.println(StringUtils.indexOfIgnoreCase(x1, ">"));
        System.out.println(start + 6);
        System.out.println(end);
        String substring = StringUtils.substring(x1, start + 6, end);
        System.out.println(StringUtils.replace(x1, substring, "曹尼玛"));

        System.out.println(StringUtils.indexOfIgnoreCase(x1, "您订购的"));


        System.out.println("=-----------");
        A a  = new A();
        a.setA(new BigDecimal("9.35"));

        System.out.println(a);

        System.out.println(new BigDecimal(new BigDecimal("9.35").doubleValue()));
        System.out.println(new BigDecimal("9.35"));

        String additionalStub = "{\"resources\":[{\"body\":\"oik12wXB/d6f/TYqUSW11wNwDNtB8btB\",\"height\":0,\"size\":0,\"width\":0}]}";
//        List<ResourceVo> resourceVos = JSON.parseObject(additionalStub,
//                new TypeReference<ArrayList<ResourceVo>>() {
//                });
//        System.out.println(resourceVos);

        Date date = new Date();
        System.out.println(DateUtils.beginTime(date));
        System.out.println(DateUtils.endTime(date));
        String x ="{\"checkCodeItemList\":[{\"checkCode\":\"npJi9IVjD6\",\"qRCodeURL\":\"https://q.tking.cn/1/npJi9IVjD6_H1Q1oMxdiH\"},{\"checkCode\":\"H1Q1oMxdiH\",\"qRCodeURL\":\"https://q.tking.cn/1/npJi9IVjD6_H1Q1oMxdiH\"}]}";

        System.out.println(additionalStub.matches(DEPRECATE_REG_VERSION));

        TicketStubDTO additionalStubObj = JSON.parseObject(additionalStub, TicketStubDTO.class);
        System.out.println(additionalStubObj);
        System.out.println(additionalStubObj.getResources().get(0).getBody());


        List<TicketStubDTO.CheckCodeItem> checkCodeItemList = JSON.parseObject(x,
                new TypeReference<ArrayList<TicketStubDTO.CheckCodeItem>>() {
                });

        System.out.println(checkCodeItemList);

//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        Set<String> setA = new HashSet<>();
//        Set<String> setB = new HashSet<>();
//        try {
//            String value = reader.readLine();
//            while (!value.equals("end")){
//                setA.add(value);
//                value = reader.readLine();
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        try {
//            String value = reader.readLine();
//            while (!value.equals("end")){
//                setB.add(value);
//                value = reader.readLine();
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println(setA.retainAll(setB));
//        System.out.println(setA);
//        System.out.println(setB);


    }
}
