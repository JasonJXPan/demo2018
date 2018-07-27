package com.pjx.demo2018.dailytest;

import com.google.gson.Gson;
import com.pjx.demo2018.dailytest.domain.PushMessage;
import com.pjx.demo2018.dailytest.domain.UserClientInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by juqi on 18/7/27.
 */
public class GsonTest {
    public static void main(String[] args) {
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
}
