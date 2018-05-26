package com.pjx.demo2018.controller;

import com.pjx.demo2018.Demo2018Application;
import com.pjx.demo2018.po.UserPO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * 为了简单搭建基本框架 暂时不拆分service和dao层，全部操作放在controller层处理
 * Created by juqi on 18/5/26.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Demo2018Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SpringJDBCControllerTest {
    private Logger logger = LoggerFactory.getLogger(SpringJDBCControllerTest.class);

    @Autowired
    private TestRestTemplate testRestTemplate;
    @LocalServerPort
    private int port;

    @Test
    public void testAddUpdateAndDelete() {
        //创建
        String url = "http://localhost:" + port + "/test";
        ResponseEntity<Integer> integerResponseEntity =
                testRestTemplate.postForEntity(url + "/users", new UserPO("user1", "pass1"), Integer.class);
        logger.info("[添加用户成功]" + integerResponseEntity.getBody());
//        创建
        ResponseEntity<Integer> integerResponseEntity1 =
                testRestTemplate.postForEntity(url + "/users", new UserPO("user2", "pass2"), Integer.class);
        logger.info("[添加用户成功]" + integerResponseEntity1.getBody());
//        获取
        ResponseEntity<List<UserPO>> response2 = testRestTemplate.exchange(url + "/users", HttpMethod.GET,
                null, new ParameterizedTypeReference<List<UserPO>>() {
                });
        logger.info("第一个用户初始为: user[0]={}" , response2.getBody().get(0));
        Long id = response2.getBody().get(0).getId();;
        testRestTemplate.put(url+"/users/"+id, new UserPO("user111", "pass111"), id);
        ResponseEntity<UserPO> result = testRestTemplate.getForEntity(url + "/users/" + id, UserPO.class, id);
        logger.info("第一个用户修改后: user[0]={}" , result.getBody());
        testRestTemplate.delete(url+"/users/"+id, id);
        result = testRestTemplate.getForEntity(url + "/users/" + id, UserPO.class, id);
        logger.info("第一个用户删除后: 是否存在？result={}" , result.getBody()==null);



    }

    @Test
    public void testGetAll() {
        String url = "http://localhost:" + port + "/test";
        ResponseEntity<List> result = testRestTemplate.getForEntity(url + "/users", List.class);
        logger.info("用户为: users={}", result.getBody());
        ResponseEntity<List<UserPO>> response2 = testRestTemplate.exchange(url + "/users", HttpMethod.GET,
                null, new ParameterizedTypeReference<List<UserPO>>() {
        });
        logger.info("用户为1: users={}", response2.getBody());
    }

}
