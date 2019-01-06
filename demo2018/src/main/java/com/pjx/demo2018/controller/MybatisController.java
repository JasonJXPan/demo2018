package com.pjx.demo2018.controller;

import com.pjx.demo2018.po.UserPO;
import com.pjx.demo2018.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 类作用描述
 *
 * @author panjinxin
 * @since 19/1/6
 */
@RestController
public class MybatisController {
    private Logger logger = LoggerFactory.getLogger(MybatisController.class);
    @Autowired
    private UserService userService;

    @GetMapping("/tusers/{userId}")
    public List<UserPO> findUserById(@PathVariable Long userId) {
        List<UserPO> byId = userService.findById(userId, 6L);
//        for (UserPO item : byId) {
//            logger.info("itemID:"+item.getId());
//            logger.info("item:", item);
//        }
//        logger.info("itemLog0={}", byId.get(0).getUserIPPOS().get(0));
//        logger.info("itemLog1={}", byId.get(1).getUserIPPOS());
        try {
            TimeUnit.SECONDS.sleep(2L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return byId;
    }

    @GetMapping("/tusers/{userId}/with-log")
    public List<UserPO> findUserWithIpLogById(@PathVariable Long userId) {
        List<UserPO> byId = userService.findWithIpLog(userId, 6L);
//        for (UserPO item : byId) {
//            logger.info("itemID:"+item.getId());
//            logger.info("item:", item);
//        }
//        logger.info("itemLog0={}", byId.get(0).getUserIPPOS().get(0));
//        logger.info("itemLog1={}", byId.get(1).getUserIPPOS());
        try {
            TimeUnit.SECONDS.sleep(2L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return byId;
    }

    @GetMapping("/tuser/all/by-name")
    public List<UserPO> findByName(@RequestParam String userName) {
        return userService.findByUsername(userName, null);
    }
}
