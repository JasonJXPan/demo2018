package com.pjx.demo2018.redis;

import com.pjx.demo2018.po.UserPO;
import com.pjx.demo2018.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.Serializable;

/**
 * Created by juqi on 18/6/3.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringCacheTest {

    private static final Logger log = LoggerFactory.getLogger(SpringCacheTest.class);
    @Autowired
    private UserService userService;

    @Autowired
    private RedisTemplate<String, Serializable> redisCacheTemplate;

    @Test
    public void get() {
        final UserPO user = userService.saveOrUpdate(new UserPO(5L, "u5", "p5"));
        log.info("[saveOrUpdate] - [{}]", user);
        final UserPO user1 = userService.get(5L);
//        UserPO userCache = (UserPO) redisCacheTemplate.opsForValue().get("user::5");
//        log.info("spring cache user ={}", userCache);
        log.info("[get] - [{}]", user1);
        userService.delete(5L);
    }


}
