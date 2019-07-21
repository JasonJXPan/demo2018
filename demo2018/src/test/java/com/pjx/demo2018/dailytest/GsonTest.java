package com.pjx.demo2018.dailytest;

import com.alibaba.fastjson.JSON;
import com.aliyun.openservices.shade.com.alibaba.rocketmq.shade.com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.pjx.demo2018.dailytest.domain.*;
import lombok.Data;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * refer: https://github.com/google/gson/blob/master/UserGuide.md
 * Created by juqi on 18/7/27.
 */
public class GsonTest {
    @Test
    public void test1(){
        UserClientInfo userClientInfoIOS = new UserClientInfo("clientID1", "userID1", "ios");
        UserClientInfo userClientInfoANDROID = new UserClientInfo("clientID2", "userID1", "android");
        List<UserClientInfo> userClientInfos = new ArrayList<>();
        userClientInfos.add(userClientInfoIOS);
        userClientInfos.add(userClientInfoANDROID);
        PushMessage pushMessage = new PushMessage();
        pushMessage.setUserClientInfos(userClientInfos);
        pushMessage.setMessageTitle("messageTitle");
        pushMessage.setMessageContent("messageContent");
        Gson gson = new Gson();
        String s = gson.toJson(pushMessage);
        PushMessage deserializedPushMessage = gson.fromJson(s, PushMessage.class);
        System.out.println(s);
        System.out.println(deserializedPushMessage.getMessageTitle());
        System.out.println(deserializedPushMessage.getMessageContent());
        System.out.println(deserializedPushMessage.getUserClientInfos().get(0).getClientOID());
        System.out.println(deserializedPushMessage.getUserClientInfos().get(1).getClientOID());
    }

    @Test
    public void test2(){
        String content = "{\"messageTitle\":\"messageTitle\",\"messageContent\":\"messageContent\",\"userClientInfos\":[{\"clientOID\":\"clientID1\",\"userOID\":\"userID1\",\"userSource\":\"ios\"},{\"clientOID\":\"clientID2\",\"userOID\":\"userID1\",\"userSource\":\"android\"}], \"abc\":\"abc\"}";

        Gson gson = new Gson();
        PushMessage pushMessage = gson.fromJson(content, PushMessage.class);
        try {
            String s = new ObjectMapper().writeValueAsString(pushMessage);
            Map map = new ObjectMapper().readValue(s, Map.class);
            String contentStr = gson.toJson(map);
            PushMessage pushMessage1 = gson.fromJson(contentStr, PushMessage.class);
            System.out.println(pushMessage1.equals(pushMessage));
            System.out.println(pushMessage1.getUserClientInfos().equals(pushMessage.getUserClientInfos()));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(pushMessage);
        System.out.println(pushMessage.getUserClientInfos());
    }
    @Test
    public void test3(){
        String x = null;
        Gson gson = new Gson();
        PushMessage deserializedPushMessage = gson.fromJson(x, PushMessage.class);
        System.out.println(deserializedPushMessage);
        TreeSetObj obj1 = new TreeSetObj();
        obj1.setSequence(1);
        obj1.setContent("a");
        TreeSetObj obj2 = new TreeSetObj();
        obj2.setSequence(2);
        obj2.setContent("b");
        Set<TreeSetObj> treeSet = new TreeSet<>();
        treeSet.add(obj1);
        treeSet.add(obj2);
        System.out.println(gson.toJson(treeSet));
        Type type = new TypeToken<Set<TreeSetObj>>(){}.getType();
        Set<TreeSetObj> o = gson.fromJson(gson.toJson(treeSet), type);
        System.out.println(o);
//        UserClientInfo userClientInfoIOS = new UserClientInfo("clientID1", "userID1", "ios");
//        UserClientInfo userClientInfoANDROID = new UserClientInfo("clientID2", "userID1", "android");
//        List<UserClientInfo> userClientInfos = new ArrayList<>();
//        userClientInfos.add(userClientInfoIOS);
//        userClientInfos.add(userClientInfoANDROID);
//        PushMessage pushMessage = new PushMessage();
//        pushMessage.setUserClientInfos(userClientInfos);
//        pushMessage.setMessageTitle("messageTitle");
//        pushMessage.setMessageContent("messageContent");
//        Gson gson = new Gson();
//        String s = gson.toJson(pushMessage);
//        PushMessage deserializedPushMessage = gson.fromJson(s, PushMessage.class);
//        System.out.println(deserializedPushMessage);
    }

    @Test
    public void test4() {
//        When you call toJson(obj), Gson calls obj.getClass() to get information on the fields to serialize. Similarly, you can typically pass MyClass.class object in the fromJson(json, MyClass.class) method. This works fine if the object is a non-generic type. However, if the object is of a generic type, then the Generic type information is lost because of Java Type Erasure. Here is an example illustrating the point:
//
//        class Foo<T> {
//            T value;
//        }
//        Gson gson = new Gson();
//        Foo<Bar> foo = new Foo<Bar>();
//        gson.toJson(foo); // May not serialize foo.value correctly
//
//        gson.fromJson(json, foo.getClass()); // Fails to deserialize foo.value as Bar
//
//        The above code fails to interpret value as type Bar because Gson invokes list.getClass() to get its class information, but this method returns a raw class, Foo.class. This means that Gson has no way of knowing that this is an object of type Foo<Bar>, and not just plain Foo.
//
//        You can solve this problem by specifying the correct parameterized type for your generic type. You can do this by using the TypeToken class.
//
//        Type fooType = new TypeToken<Foo<Bar>>() {}.getType();
//        gson.toJson(foo, fooType);
//
//        gson.fromJson(json, fooType);
//
//        The idiom used to get fooType actually defines an anonymous local inner class containing a method getType() that returns the fully parameterized type.
    }

    @Test
    public void test5() {
        Set<String> orderIDs = new HashSet<>();
        orderIDs.add("1");
        orderIDs.add("2");
        orderIDs.add("3");
        orderIDs.add("4");
        Map<String, Object> msg = new HashMap<>();
        msg.put("a", orderIDs);
        msg.put("myDate", null);
        msg.put("myInteger", null);
        try {
            String s = new ObjectMapper().writeValueAsString(msg);
            Map map = new ObjectMapper().readValue(s, Map.class);
            List<String> list = (List<String>)map.get("a");
            Date myDate = (Date) map.get("myDate");
            Integer myInteger = (Integer) map.get("myInteger");
            Integer myInteger1= Integer.getInteger((String)map.get("myInteger"));
            System.out.println(list);
            System.out.println(myDate);
            System.out.println(myInteger);
            System.out.println(myInteger1);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test6() {
        Map<String, Object> map = new HashMap<>();
        map.put("date", Calendar.getInstance().getTime());
        try {
            String s = new ObjectMapper().writeValueAsString(map);
            System.out.println(s);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void test7(){
        String jsonStr = "";

        Gson gson = new Gson();

        JsonRootBean jsonRootBean = gson.fromJson(jsonStr, JsonRootBean.class);
        JsonRootBeanParam param = gson.fromJson(jsonRootBean.getParams(), JsonRootBeanParam.class);
        String template = jsonRootBean.getTemplate().replace("VERIFY_CODE", jsonRootBean.getVerifyCode()).replace("ORIGINAL_PRICE", jsonRootBean.getOriginalPrice()+"票面")
                .replace("TICKET_QTY", jsonRootBean.getQty()+"").replace("TICKET_UNIT", "张").replace("SHOW_NAME", param.getSHOW_NAME())
                .replace("SHOW_TIME", param.getSHOW_TIME()+"").replace("VENUE_NAME", param.getVENUE_NAME()).replace("ARRIVE_TIME", param.getARRIVE_TIME())
                .replace("ADDRESS", param.getADDRESS()).replace("VENUE_CONTACT", param.getVENUE_CONTACT()).replace("SELLER_PHONE", param.getSELLER_PHONE())
                .replace("TIPS", param.getTIPS()).replace("CODEURL", "https://q.abc.cn/"+jsonRootBean.getPurchaseOrderOID());
//        template = jsonRootBean.getTemplate().replace("VERIFY_CODE", jsonRootBean.getVerifyCode());
        System.out.println("订单id："+jsonRootBean.getOrderOID()+"-用户手机号" + jsonRootBean.getBuyerPhone()+ "-短信内容-"+template);
    }

    @Test
    public void test8(){
        String x ="{showOID=5b3dade0c756b113c84ae3f4, sellerType=business, sellerOID=5b2cafd4069b3e7aa44384f0, facadeSellerOID=5b2cafd4069b3e7aa44384f0, facadeSellerNickName=北京小红帽票务, facadeBusinessLicenseFile=\"\"}";

        System.out.println(x.charAt(x.length()-2));
        x = x.replace("/", "").replace(":", "").replace("_","");
        Gson gson = new Gson();
        gson.fromJson(x, SellerShowCertificationDTO.class);


        Arrays.asList("[  {    \"orderItemOID\": \"5bb47346e4b0b7858c139db3\",    \"showOID\": \"5b332f58908c38706b47e509\",    \"sellerOID\": \"59c20a3a0cf2a38f4825523b\"  }]","[  {    \"orderItemOID\": \"5bb4880de4b009ffefa60296\",    \"showOID\": \"5bb06cf5908c3856d692423b\",    \"sellerOID\": \"5848c5fb0cf279ca67a3a91c\"  }]","[  {    \"orderItemOID\": \"5bb4a79be4b0b7858c1612ed\",    \"showOID\": \"5b67e4bc908c38543ff24b4d\",    \"sellerOID\": \"5a3672d1e4b0eb06e56c8336\"  }]","[  {    \"orderItemOID\": \"5bb4c849e4b009ffefa8d808\",    \"showOID\": \"5b9b6399c756b162a9c6044a\",    \"sellerOID\": \"5833f5b90cf286628fafe345\"  }]","[  {    \"orderItemOID\": \"5bb4e391e4b009ffefa9f368\",    \"showOID\": \"5bb0f6eac756b1616d8b7743\",    \"sellerOID\": \"5bb065dc069b3e0315a210c2\"  }]");
    }


    @Test
    public void test9(){
     MyRequest myRequest = new MyRequest();
     myRequest.setId("id");
     myRequest.setX("x");
        try {
            String s = new ObjectMapper().writeValueAsString(myRequest);
            MyRequest1 myRequest11 = JSON.parseObject(s, MyRequest1.class);
            System.out.println(myRequest11);
//            MyRequest1 myRequest1 = new ObjectMapper().readValue(s, MyRequest1.class);
//            System.out.println(myRequest1);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test10(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            System.out.println(dateFormat.parse("2019-02-24 23:59:59").getTime());
        } catch (ParseException e) {

        }
        String x ="[{\"overdueDeadline\":1553702399000,\"targetOrderOID\":\"5c4537fa94b85f14b4658ba4\"}]";
        try {
            List map = new ObjectMapper().readValue(x, List.class);
            System.out.println(map);
        } catch (IOException e) {

        }
        List<OrderOverdueDTO> orderOverdueDTOS = JSONObject.parseArray(x, OrderOverdueDTO.class);
        System.out.println(orderOverdueDTOS);
    }

    @Test
    public void test11() {
        List<PriceItemDTO> priceItems = new ArrayList<>();
        PriceItemDTO priceItem = new PriceItemDTO();
        priceItem.setPriceItemName("代收票款");
        priceItem.setComputable(true);
        priceItem.setPriceItemVal(new BigDecimal("77"));
        priceItems.add(priceItem);
        String x = JSON.toJSONString(priceItems);
        System.out.println(x);

        List<PriceItemDTO> priceItemDTOs = JSON.parseArray(x, PriceItemDTO.class);
        System.out.println(priceItemDTOs);

        PriceItemGroup itemGroup = new PriceItemGroup();
        itemGroup.setSeq(1);
        itemGroup.setPriceItemDTOs(priceItemDTOs);
        List<PriceItemGroup> itemGroups = new ArrayList<>();
        itemGroups.add(itemGroup);
        String y = JSON.toJSONString(itemGroups);
        System.out.println(y);

        List<PriceItemDTO> priceItemDTOs1 = JSON.parseArray(y, PriceItemDTO.class);
//        System.out.println(CollectionUtils.isEmpty(priceItemDTOs1));
//        System.out.println(StringUtils.isBlank(priceItemDTOs1.get(0).getPriceItemName()));
//        System.out.println(priceItemDTOs1.size());
//        System.out.println(priceItemDTOs1);
        if (StringUtils.isBlank(priceItemDTOs1.get(0).getPriceItemName())) {
            List<PriceItemGroup> itemGroups1 = JSON.parseArray(y, PriceItemGroup.class);
            System.out.println(itemGroups1);
        }
    }

    @Test
    public void test12() {
        List<PriceItemDTO> priceItems = new ArrayList<>();
        PriceItemDTO priceItem = new PriceItemDTO();
        priceItem.setPriceItemName("代收票款");
        priceItem.setComputable(true);
        priceItem.setPriceItemVal(new BigDecimal("77"));
        priceItems.add(priceItem);

        PriceItemDTO priceItem1 = new PriceItemDTO();
        priceItem1.setPriceItemName("代收票款1");
        priceItem1.setComputable(true);
        priceItem1.setPriceItemVal(new BigDecimal("771"));
        priceItems.add(priceItem1);

        System.out.println(priceItems);

        List<PriceItemDTO> pri = priceItems.stream().filter(item -> StringUtils.equals(item.getPriceItemName(), "代收票款1")).collect(Collectors.toList());
        System.out.println(pri);
        pri.get(0).setComputable(false);
        pri.get(0).setPriceItemName("123456");

        System.out.println(priceItems);

        System.out.println(StringUtils.join("a", "B"));

    }

    @Test
    public void test13() {
        List<PriceItemDTO> priceItems = new ArrayList<>();
        PriceItemDTO priceItem = new PriceItemDTO();
        priceItem.setPriceItemName("代收票款");
        priceItem.setComputable(true);
        priceItem.setPriceItemVal(new BigDecimal("77"));
        priceItems.add(priceItem);

        PriceItemDTO priceItem1 = new PriceItemDTO();
        priceItem1.setPriceItemName("代收票款1");
        priceItem1.setComputable(true);
        priceItem1.setPriceItemVal(new BigDecimal("771"));
        priceItems.add(priceItem1);

        List<PriceItemDTO> result = new ArrayList<>();
        int i =0;
        for (PriceItemDTO a : priceItems) {
            PriceItemDTO b = a;
            if (i==0) {
                b.setComments("aaaa");
            } else {
                b.setComments("bbbb");
            }
            i++;
            result.add(b);
        }
        System.out.println(result);
    }
@Data
class PriceItemGroup {
    private int seq;
    private List<PriceItemDTO> priceItemDTOs;
}
@Data
class PriceItemDTO {
    private String priceItemName;
    /**
     * 计费项子名字
     */
    private String priceItemSubName;
    private BigDecimal priceItemVal;
    private String comments;

    /**
     * 订单priceItem 子类型名
     * 如 priceItem 类型为ALLOWANCE，
     *  子类型可能是SPONSOR_ALLOWANCE 表示主办补贴
     */
    private String priceItemSubTypeName;

    /**
     * 计费项单位, 默认为元
     */
    private PriceItemUnit unit = PriceItemUnit.YUAN;

    /**
     * 是否可以参与计算订单金额, 默认为true
     */
    private boolean computable = true;



}
    public enum PriceItemUnit {
        /**
         * 元
         */
        YUAN,
        /**
         * 次
         */
        CI
    }
@Data
class MyRequest {
    private String id;
    private String x;
}

@Data
class MyRequest1 {
    private String id;
}
class OrderOverdueDTO implements Serializable {

    private static final long serialVersionUID = 3740154186726667688L;

    private String targetOrderOID;
    private long overdueDeadline;

    public String getTargetOrderOID() {
        return targetOrderOID;
    }

    public void setTargetOrderOID(String targetOrderOID) {
        this.targetOrderOID = targetOrderOID;
    }

    public long getOverdueDeadline() {
        return overdueDeadline;
    }

    public void setOverdueDeadline(long overdueDeadline) {
        this.overdueDeadline = overdueDeadline;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("targetOrderOID=");
        sb.append(targetOrderOID);
        sb.append(",overdueDeadline=");
        sb.append(overdueDeadline);
        return sb.toString();
    }
}}