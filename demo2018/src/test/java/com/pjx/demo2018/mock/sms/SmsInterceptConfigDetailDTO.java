package com.pjx.demo2018.mock.sms;

import lombok.Data;

/**
 * 短信拦截配置详情DTO, 临时方案，后续MTC-NOTIFICATION会兼容处理
 */
@Data
public class SmsInterceptConfigDetailDTO {
    /**
     * 触发短信发送的操作
     */
    private String action;
    /**
     * 产品通道id
     */
    private String productChannelId;

    /**
     * 模板
     */
    private String template;
    private String comments;
}
