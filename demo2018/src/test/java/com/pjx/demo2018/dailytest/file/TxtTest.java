package com.pjx.demo2018.dailytest.file;

import org.apache.commons.collections.list.TreeList;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.DecimalFormat;
import java.util.*;

/**
 * 类作用描述
 *
 * @author panjinxin
 * @since 2020/1/10
 */
public class TxtTest {


    @Test
    public void testIp() {

    }


    @Test
    public void test下单错误日志() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("D:\\数据分析\\下单数据.txt"));
            reader.readLine();//第一行信息，为标题信息，不用，如果需要，注释掉
            String line = null;
            int lineCount = 0;
            List<String> result = new ArrayList<>(50);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("'");
//            line=reader.readLine();
//            System.out.println(line);
            Map<String, Integer> map = new HashMap<>();
            while((line=reader.readLine())!=null){
                if (line.contains("statusCode=200")) {
                    line = "200";
                }
                Integer integer = map.get(line);
                if (integer == null) {
                    integer = 0;
                }
                integer++;
                map.put(line, integer);
                lineCount ++;
            }
            System.out.println(lineCount);
            DecimalFormat decimalFormat = new DecimalFormat("00000");
            List<Integer> countList = new ArrayList<>();

            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                countList.add(entry.getValue());
//                System.out.println(decimalFormat.format(entry.getValue()) +"_____"+entry.getKey());
            }
            Collections.sort(countList);
            Collections.reverse(countList);
            System.out.println(countList);
            for (Integer integer : countList) {
                for (Map.Entry<String, Integer> entry : map.entrySet()) {
                    if (integer.equals(entry.getValue())) {
                        System.out.println(decimalFormat.format(entry.getValue()) +"_____"+entry.getKey());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testMy() {
        getMyFocus(null, "orderId=", 24);
    }

    private String getMyFocus(String x, String focus, int valueLength) {
//        x = "\"2020-01-10T04:12:04.409Z\",\"order\",\"通知第三方支付成功消息，发送失败, 2秒后进行补发 orderId=5e17f96994b85f705bea7f34, msg=TicketClient#findByTicketOID(String) timed-out and no fallback available.\",\"5e17f98a94b85f705bea810a\"";
        int index = x.indexOf(focus);
        String value = x.substring(index+focus.length(), index+valueLength+focus.length());
//        System.out.println(value);
        return value;
    }
}
