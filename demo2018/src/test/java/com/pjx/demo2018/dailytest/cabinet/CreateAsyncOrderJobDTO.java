package com.pjx.demo2018.dailytest.cabinet;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

/**
 * 异步添加订单jobDTO 用于mq数据传递
 *
 * @author panjinxin
 * @since 2020/2/24
 */
@Data
public class CreateAsyncOrderJobDTO implements Serializable {
    private static final long serialVersionUID = 1294756852875404253L;

    /**
     * job命名前缀
     */
    private String jobPrefix;
    /**
     * jobId
     */
    private String jobId;
    /**
     * job中的参数
     */
    private Map<String, String> jobAttributes;
    /**
     * job启动时间
     */
    private Date triggerStartTime;

}
