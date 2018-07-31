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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PushMessage that = (PushMessage) o;

        if (messageTitle != null ? !messageTitle.equals(that.messageTitle) : that.messageTitle != null) return false;
        if (messageContent != null ? !messageContent.equals(that.messageContent) : that.messageContent != null)
            return false;
        return userClientInfos != null ? userClientInfos.equals(that.userClientInfos) : that.userClientInfos == null;
    }

    @Override
    public int hashCode() {
        int result = messageTitle != null ? messageTitle.hashCode() : 0;
        result = 31 * result + (messageContent != null ? messageContent.hashCode() : 0);
        result = 31 * result + (userClientInfos != null ? userClientInfos.hashCode() : 0);
        return result;
    }
}
