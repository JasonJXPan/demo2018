package com.pjx.demo2018.mock.sms;

/**
 * 短信拦截配置 - 发送处理目标
 */
public enum SMSInterceptDestination {
    /**
     * 由adapter处理
     */
    ADAPTER,
    /**
     * 自定义 - 发送到mtc-notification
     */
    CUSTOMIZED;
}
