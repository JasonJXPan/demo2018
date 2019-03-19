package com.pjx.demo2018.service;

import com.pjx.demo2018.po.UserIPPO;

import java.util.List;

/**
 * 类作用描述
 *
 * @author panjinxin
 * @since 19/1/6
 */
public interface UserIpLogService {

    /**
     * @param userId
     * @return
     */
    List<UserIPPO> findByUserId(String userId);

    List<UserIPPO> findByUserIdsForeach(List<String>userId);

    List<UserIPPO> findByUserIds(String userId);
}
