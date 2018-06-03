package com.pjx.demo2018.service.impl;

import com.pjx.demo2018.po.UserPO;
import com.pjx.demo2018.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

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
}
