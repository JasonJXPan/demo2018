package com.pjx.demo2018.service.impl;

import com.pjx.demo2018.mapper.UserIPMapper;
import com.pjx.demo2018.po.UserIPPO;
import com.pjx.demo2018.service.UserIpLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 类作用描述
 *
 * @author panjinxin
 * @since 19/1/6
 */
@Service
public class UserIpLogServiceImpl implements UserIpLogService {
    @Autowired
    private UserIPMapper userIPMapper;

    @Override
    public List<UserIPPO> findByUserId(String userId) {
        return userIPMapper.findByUserId(userId);
    }

    @Override
    public List<UserIPPO> findByUserIdsForeach(List<String> userId) {
        return userIPMapper.findByUserIdsForeach(userId);
    }

    @Override
    public List<UserIPPO> findByUserIds(String userId) {
        return userIPMapper.findByUserIds(userId);
    }
}
