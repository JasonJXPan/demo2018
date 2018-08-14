package com.pjx.demo2018.dailytest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.pjx.demo2018.dailytest.domain.PushMessage;
import com.pjx.demo2018.dailytest.domain.TreeSetObj;
import com.pjx.demo2018.dailytest.domain.UserClientInfo;
import org.junit.Test;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.*;

/**
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
}
