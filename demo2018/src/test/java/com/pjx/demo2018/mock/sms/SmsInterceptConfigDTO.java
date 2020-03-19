package com.pjx.demo2018.mock.sms;

import lombok.Data;

import java.util.List;

/**
 * 短信拦截配置DTO, 临时方案，后续MTC-NOTIFICATION会兼容处理
 */
@Data
public class SmsInterceptConfigDTO {
    /**
     * 支付方式
     */
    private String payment;
    /**
     * 最终处理目标
     */
    private SMSInterceptDestination destination;

    /**
     * 拦截信息详情
     */
    private List<SmsInterceptConfigDetailDTO> configDetails;
}
