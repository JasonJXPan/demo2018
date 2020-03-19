package com.pjx.demo2018.dailytest.file;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 类作用描述
 *
 * @author panjinxin
 * @since 2020/1/3
 */
public class FileTest {

    private static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Test
    public void test() {
        try {
//            InputStream fileInputStream = new FileInputStream(new File("D:\\下载\\grayLog-process.csv"));
//            FieldReader fieldReader = new FieldReader(fileInputStream);
            FileReader fileReader = new FileReader("D:\\下载\\graylog-1230-veiew.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();
            line = bufferedReader.readLine();
            StringBuilder sb = new StringBuilder();
            sb.append("insert into test_data2(userId, orderId, time) values ");
            while (StringUtils.isNotBlank(line)) {
//                System.out.println(line);
//                return;
//                System.out.println();
                test1(line, sb);
                line = bufferedReader.readLine();
            }
            System.out.println(sb.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    @Test
    public void test1(String x, StringBuilder sb) {
//        String x = "\"2019-12-29T11:21:19.950Z\",\"manage\",\"sent ons topic: topic_data tag: record_controller content{\"\"apiVisitOID\"\":null,\"\"apiOID\"\":\"\"56aa063dd4c67d2bbbb83d0a\"\",\"\"apiDesc\"\":\"\"通过订单id获取订单和配票订单详情\"\",\"\"sessionOID\"\":\"\"0B27614DE55E17144C8869EAAF48C8A3\"\",\"\"userOID\"\":\"\"5d383a3042eaa90c7ec73d7e\"\",\"\"ip\"\":\"\"113.89.236.215\"\",\"\"userAgent\"\":\"\"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/73.0.3683.86 Safari/537.36\"\",\"\"ver\"\":null,\"\"src\"\":null,\"\"refer\"\":\"\"http://mtl12k.juqitech.com/order/seller_ticket_list\"\",\"\"hostip\"\":null,\"\"params\"\":{\"\"purchaseOrderID\"\":\"\"5e088ad4069b3e2b344f5e12\"\",\"\"orderOID\"\":\"\"5e088ad48e8efd13504a6303\"\"},\"\"visitTime\"\":1577618479949,\"\"createTime\"\":null}\"";
        int userOID = x.indexOf("userOID");
//        System.out.println();
        String myUserId = x.substring(userOID+"userOID".length()+5, userOID+24+"userOID".length()+5);
//        System.out.println(myUserId);

        int orderOID = x.indexOf("orderOID");
//        System.out.println();
        String myOrderId = x.substring(orderOID+"orderOID".length()+5, orderOID+24+"orderOID".length()+5);
//        System.out.println(myOrderId);

        int visitTime = x.indexOf("visitTime");
//        System.out.println();
        String myVisitTime = x.substring(visitTime+"visitTime".length()+3, visitTime+13+"visitTime".length()+3);
//        System.out.println(myVisitTime);

        myVisitTime = dateFormat.format(new Date(Long.valueOf(myVisitTime)));


        int purchaseOrderID = x.indexOf("purchaseOrderID");
//        System.out.println();
        String myPurOrderId = x.substring(purchaseOrderID+"purchaseOrderID".length()+5, orderOID+24+"purchaseOrderID".length()+5);
//        StringBuilder sb = new StringBuilder();
//        sb.append("insert into test_data1(userId, orderId, time) values ");
        sb.append("(\'").append(myUserId).append("\',\'").append(myOrderId).append("\',\'").append(myVisitTime).append("\'").append("),");
//        System.out.println(sb.toString());

    }
}
