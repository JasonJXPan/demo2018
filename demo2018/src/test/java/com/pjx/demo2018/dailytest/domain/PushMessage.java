package com.pjx.demo2018.dailytest.domain;

import java.util.List;

/**
 * Created by juqi on 18/7/27.
 */
public class PushMessage {
    private String messageTitle;
    private String messageContent;
    private List<UserClientInfo> userClientInfos;

    public String getMessageTitle() {
        return messageTitle;
    }

    public void setMessageTitle(String messageTitle) {
        this.messageTitle = messageTitle;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public List<UserClientInfo> getUserClientInfos() {
        return userClientInfos;
    }

    public void setUserClientInfos(List<UserClientInfo> userClientInfos) {
        this.userClientInfos = userClientInfos;
    }

    @Override
    public String toString() {
        return "PushMessage{" +
                "messageTitle='" + messageTitle + '\'' +
                ", messageContent='" + messageContent + '\'' +
                ", userClientInfos=" + userClientInfos +
                '}';
    }
}
