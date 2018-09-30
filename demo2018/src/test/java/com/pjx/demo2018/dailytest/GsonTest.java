package com.pjx.demo2018.dailytest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.pjx.demo2018.dailytest.domain.*;
import org.junit.Test;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.*;

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
}
