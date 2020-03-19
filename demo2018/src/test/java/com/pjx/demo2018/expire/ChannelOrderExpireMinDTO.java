package com.pjx.demo2018.expire;

import lombok.Data;

/**
 * 渠道订单支付超时时间DTO
 *
 * @author panjinxin
 * @since 2019/12/3
 */
@Data
public class ChannelOrderExpireMinDTO {

    /**
     * 渠道名
     */
    private String channel;
    /**
     * 超时时间 单位：分钟
     */
    private Integer minute;
}
