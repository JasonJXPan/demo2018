package com.pjx.demo2018.service.impl;

import com.pjx.demo2018.mapper.UserMapper;
import com.pjx.demo2018.po.UserPO;
import com.pjx.demo2018.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * 为了方便演示数据库操作，直接定义了一个Map<Long, User> DATABASES，这里的核心就是@Cacheable、@CachePut、@CacheEvict 三个注解
 * @EnableCaching 必须要加，否则spring-data-cache相关注解不会生效…
 * @author juqi
 * @date 18/6/3
 */
@Service
public class UserServiceImpl implements UserService {
    private static final Map<Long, UserPO> DATABASES = new HashMap<>();

    static {
        DATABASES.put(1L, new UserPO(1L, "u1", "p1"));
        DATABASES.put(2L, new UserPO(2L, "u2", "p2"));
        DATABASES.put(3L, new UserPO(3L, "u3", "p3"));
    }
    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserMapper userMapper;

    @CachePut(value = "user", key = "#user.id")
    @Override
    public UserPO saveOrUpdate(UserPO user) {
        DATABASES.put(user.getId(), user);
        log.info("进入 saveOrUpdate 方法");
        return user;
    }

    @Cacheable(value = "user", key = "#id")
    @Override
    public UserPO get(Long id) {
        log.info("进入 get 方法");
        return DATABASES.get(id);
    }

    @CacheEvict(value = "user", key = "#id")
    @Override
    public void delete(Long id) {
        DATABASES.remove(id);
        log.info("进入 delete 方法");
    }

    @Override
    @Transactional
    public List<UserPO> findById(Long id, Long id1) {
        List<UserPO> byId = userMapper.findById(id, id1);
        for (UserPO item : byId) {
            log.info("itemID:"+item.getId());
            log.info("item:", item);
        }
        userMapper.updateNameById(id, "abcd");
        byId = userMapper.findById(id, id1);
        return byId;
    }

    @Override
    public List<UserPO> findWithIpLog(Long id, Long id1) {
        return userMapper.findWithIpLog(id, id1);
    }

    @Override
    public List<UserPO> findByUsername(String username, List<String> list) {
        return userMapper.findByUsername(username, list);
    }
}
