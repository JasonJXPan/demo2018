package com.pjx.demo2018.dailytest;

import lombok.Data;

/**
 * 订单数据统计DTO
 *
 * @author weiyingni
 * @since 2019/4/23
 */
@Data
public class OrderStatisticsDTO {

    /**
     * 订单数量
     */
    private int orderCount;

    /**
     * 统计sum(order.total)
     */
    private double sumTotal;

    /**
     * 当日待支付订单数量
     */
    private Long dailyUnPaidCount;
    /**
     * 当日已取消订单数量
     */
    private Long dailyCanceledCount;
    /**
     * 尾票待支付数量
     */
    private Long tailSessionUnPaidCount;
    /**
     * 尾票已取消数量
     */
    private Long tailSessionCanceledCount;

    /**
     * 当天待支付和已取消订单限制数量
     */
    private Long dailyUnPaidCancelCountLimit;
    /**
     * 尾票待支付和已取消订单限制数量
     */
    private Long tailSessionUpPaidCancelCountLimit;

    /**
     * 场次是否进入尾票
     */
    private boolean ifTailSession;

    public Long getDailyUnPaidCount() {
        if (this.dailyUnPaidCount == null) {
            this.dailyUnPaidCount= 0L;
        }
        return this.dailyUnPaidCount;
    }

    public Long getDailyCanceledCount() {
        if (this.dailyCanceledCount == null) {
            this.dailyCanceledCount = 0L;
        }
        return dailyCanceledCount;
    }

    public Long getTailSessionUnPaidCount() {
        if (this.tailSessionUnPaidCount == null) {
            this.tailSessionUnPaidCount = 0L;
        }
        return tailSessionUnPaidCount;
    }

    public Long getTailSessionCanceledCount() {
        if (this.tailSessionCanceledCount == null) {
            this.tailSessionCanceledCount =0L;
        }
        return tailSessionCanceledCount;
    }

    public static void main(String[] args) {
        OrderStatisticsDTO dto = new OrderStatisticsDTO();
        System.out.println(dto.getDailyCanceledCount());
    }
}
