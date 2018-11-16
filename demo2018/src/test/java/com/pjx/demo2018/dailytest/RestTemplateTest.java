package com.pjx.demo2018.dailytest;

import com.aliyun.openservices.shade.com.alibaba.rocketmq.shade.com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.juqitech.service.utils.net.TMultiResult;
import org.junit.Test;
import org.springframework.http.*;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by juqi on 18/10/8.
 */
public class RestTemplateTest {

    @Test
    public void test() throws InterruptedException {
        List<String> list = Arrays.asList("[  {    \"orderItemOID\": \"5bbb3b5fe4b009ffefe5e3e2\",    \"showOID\": \"5a5da7a5c756b172b08b65e6\",    \"sellerOID\": \"572622ab0cf27c5c4462ea92\"  }]","[  {    \"orderItemOID\": \"5bbbad95e4b0b7858c5bcfd2\",    \"showOID\": \"5b73827ac756b10c2a7909dc\",    \"sellerOID\": \"5a5ee202069b3e61f0e979a5\"  }]","[  {    \"orderItemOID\": \"5bbc1f5de4b009ffefed2d45\",    \"showOID\": \"5aeadb0fc756b1728cdc7374\",    \"sellerOID\": \"5845499c0cf292acc51a0d24\"  }]","[  {    \"orderItemOID\": \"5bbc7244e4b0b7858c6461bb\",    \"showOID\": \"5b71581ac756b149d1f41733\",    \"sellerOID\": \"5b57df9e069b3e074093687a\"  }]");
        List<String> result = new ArrayList<>();
        for (String x : list) {
            result.add(testABC(x));
            Thread.sleep(500);
        }

        System.out.println("--------");
        for (String x : result) {
            System.out.println(x);
        }
    }

    public String testABC(String requestBody){
        RestTemplate restTemplate = new RestTemplate(
                new BufferingClientHttpRequestFactory(new SimpleClientHttpRequestFactory()));
//        String requestBody = "[\n" +
//                "  {\n" +
//                "    \"orderItemOID\": \"5bb46c06e4b009ffefa4e283\",\n" +
//                "    \"showOID\": \"5b8f8b6dc756b11b87db9555\",\n" +
//                "    \"sellerOID\": \"579074e90cf2758515b87d4d\"\n" +
//                "  }\n" +
//                "]";
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
        headers.setContentType(type);
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());
        HttpEntity<String> httpEntity = new HttpEntity<String>(requestBody, headers);

        ResponseEntity<TMultiResult> exchange = restTemplate.exchange("https://mj.tking.cn/sellerapi/endpoint/seller_facade_certifications",
                HttpMethod.POST, httpEntity, TMultiResult.class);
        Gson gson = new Gson();
        String cons = exchange.getBody().getData().get(0).toString();
        if ('='== (cons.charAt(cons.length()-2))) {
            cons = cons.replace("facadeBusinessLicenseFile=", "facadeBusinessLicenseFile=\"\"");
        }
        String content = cons.replace("/", "").replace(":", "").replace("_","");
        SellerShowCertificationDTO sellerShowCertificationDTO = gson.fromJson(content, SellerShowCertificationDTO.class);
//        System.out.println();
//        System.out.println();
//        System.out.println(sellerShowCertificationDTO);
        StringBuilder stringBuilder = new StringBuilder();
        String sellerType = "certificated";
        if (sellerShowCertificationDTO.getSellerType() == "personal"
                && StringUtils.isEmpty(sellerShowCertificationDTO.getFacadeBusinessLicenseFile())) {
            sellerType = "personal";
        }
        if(org.apache.commons.lang3.StringUtils.contains(sellerShowCertificationDTO.getFacadeSellerNickName(), "**")) {
            sellerType = "personal";
        }
        String replace = requestBody.replace("[", "").replace("]", "");
        SellerCertQueryDTO sellerCertQueryDTO = gson.fromJson(replace, SellerCertQueryDTO.class);
        stringBuilder.append("update tm_order_item_ticket t set t.seller_id='")
                .append(sellerShowCertificationDTO.getFacadeSellerOID()).append("',")
                .append("t.seller_display_name='").append(sellerShowCertificationDTO.getFacadeSellerNickName()).append("',")
                .append("t.seller_type='").append(sellerType).append("' ")
                .append("where t.orderItemOID='").append(sellerCertQueryDTO.getOrderItemOID()).append("';");
//        System.out.println();
//        System.out.println();
//        System.out.println(stringBuilder.toString());
        return stringBuilder.toString();
    }
}
