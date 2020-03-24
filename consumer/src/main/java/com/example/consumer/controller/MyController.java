package com.example.consumer.controller;

import com.example.consumer.vo.UserVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 类作用描述
 *
 * @author panjinxin
 * @since 2020/3/24
 */
@RestController
@Api(value = "MyController")
public class MyController {

    @GetMapping("/v1/users/{userId}")
    @ApiOperation("根据id查询用户")
    public UserVo getUsersById(@PathVariable("userId") String userId) {
        UserVo userVo = new UserVo();
        userVo.setUserId(userId);
        return userVo;
    }
}
