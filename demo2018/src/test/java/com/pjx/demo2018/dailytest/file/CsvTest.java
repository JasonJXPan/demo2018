package com.pjx.demo2018.dailytest.file;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 类作用描述
 *
 * @author panjinxin
 * @since 2020/1/10
 */
public class CsvTest {

    @Test
    public void testIp() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("D:\\下载\\graylog-search-result-relative-1800.csv"));//换成你的文件名
            reader.readLine();//第一行信息，为标题信息，不用，如果需要，注释掉
            String line = null;
            int lineCount = 0;
            List<String> result = new ArrayList<>(50);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("'");

            Map<String, Integer> map = new HashMap<>();

            while((line=reader.readLine())!=null){
//                String delimiter = "logIP methodName: preOrder ip:";
                String delimiter = "logIP methodName: pxqCreateOrder ip:";
                //预下单  logIP methodName: preOrder ip:
                //下单    logIP methodName: pxqCreateOrder
                String myFocus = getMyFocus(line, delimiter, -1);
                stringBuilder.append(myFocus).append("','");
                result.add(myFocus);
//                System.out.println(myFocus);
                Integer integer = map.get(myFocus);
                if (integer == null) {
                    integer = 0;
                }
                integer++;
                map.put(myFocus, integer);

                lineCount ++;
//                return;
            }
            String resultStr = stringBuilder.toString();
            resultStr = resultStr.substring(0, resultStr.length()-2);
//            System.out.println(resultStr);
//            System.out.println(result.size());

            DecimalFormat decimalFormat = new DecimalFormat("00000");
            List<Integer> countList = new ArrayList<>();

            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                countList.add(entry.getValue());
//                System.out.println(decimalFormat.format(entry.getValue()) +"_____"+entry.getKey());
            }
            Collections.sort(countList);
            Collections.reverse(countList);
            Set<Integer> set = new LinkedHashSet<>();
            for (Integer x : countList) {
                set.add(x);
            }
//            set.addAll(countList);
//            System.out.println(set);
//            System.out.println(map);
            for (Integer integer : set) {
                for (Map.Entry<String, Integer> entry : map.entrySet()) {
                    if (integer.equals(entry.getValue())) {
                        System.out.println(decimalFormat.format(entry.getValue()) +"_____"+entry.getKey());
                    }
                }
            }
            System.out.println(result.parallelStream().distinct().count());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    public void test陈奕迅收费项出错() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("D:\\下载\\陈奕迅-获取收费项错误.csv"));//换成你的文件名
            reader.readLine();//第一行信息，为标题信息，不用，如果需要，注释掉
            String line = null;
            int lineCount = 0;
            List<String> result = new ArrayList<>(50);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("'");

            Map<String, Integer> map = new HashMap<>();

            while((line=reader.readLine())!=null){
                String delimiter = "clientId=";
//                String delimiter = "logIP methodName: pxqCreateOrder ip:";
                //预下单  logIP methodName: preOrder ip:
                //下单    logIP methodName: pxqCreateOrder
                String myFocus = getMyFocus(line, delimiter, 24);
                stringBuilder.append(myFocus).append("','");
                result.add(myFocus);
//                System.out.println(myFocus);
                Integer integer = map.get(myFocus);
                if (integer == null) {
                    integer = 0;
                }
                integer++;
                map.put(myFocus, integer);

                lineCount ++;
//                return;
            }
            String resultStr = stringBuilder.toString();
            resultStr = resultStr.substring(0, resultStr.length()-2);
//            System.out.println(resultStr);
//            System.out.println(result.size());

            DecimalFormat decimalFormat = new DecimalFormat("00000");
            List<Integer> countList = new ArrayList<>();

            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                countList.add(entry.getValue());
//                System.out.println(decimalFormat.format(entry.getValue()) +"_____"+entry.getKey());
            }
            Collections.sort(countList);
            Collections.reverse(countList);
            Set<Integer> set = new LinkedHashSet<>();
            for (Integer x : countList) {
                set.add(x);
            }
//            set.addAll(countList);
//            System.out.println(set);
//            System.out.println(map);
            for (Integer integer : set) {
                for (Map.Entry<String, Integer> entry : map.entrySet()) {
                    if (integer.equals(entry.getValue())) {
                        System.out.println(decimalFormat.format(entry.getValue()) +"_____"+entry.getKey());
                    }
                }
            }
            System.out.println(result.parallelStream().distinct().count());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("D:\\下载\\myTest.csv"));//换成你的文件名
            reader.readLine();//第一行信息，为标题信息，不用，如果需要，注释掉
            String line = null;
            int lineCount = 0;
            List<String> result = new ArrayList<>(50);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("'");
            while((line=reader.readLine())!=null){
                String myFocus = getMyFocus(line, "orderId=", 24);
                stringBuilder.append(myFocus).append("','");
                result.add(myFocus);
                lineCount ++;
            }
            String resultStr = stringBuilder.toString();
            resultStr = resultStr.substring(0, resultStr.length()-2);
            System.out.println(resultStr);
            System.out.println(result.size());
            System.out.println(result.parallelStream().distinct().count());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testMy() {
        getMyFocus(null, "orderId=", 24);
    }

    private String getMyFocus(String x, String focus, int valueLength) {
        int index = x.indexOf(focus);
//        System.out.println(x + ""+index);
        if (index == -1) {
            return "";
        }
        if (valueLength == -1) {

            String value = x.substring(index+focus.length());
            return value;
        }
        String value = x.substring(index+focus.length(), index+valueLength+focus.length());
        return value;
//        x = "\"2020-01-10T04:12:04.409Z\",\"order\",\"通知第三方支付成功消息，发送失败, 2秒后进行补发 orderId=5e17f96994b85f705bea7f34, msg=TicketClient#findByTicketOID(String) timed-out and no fallback available.\",\"5e17f98a94b85f705bea810a\"";
//        System.out.println(value);
    }
}
