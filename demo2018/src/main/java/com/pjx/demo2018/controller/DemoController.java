package com.pjx.demo2018.controller;

import com.pjx.demo2018.config.FavorProperties;
import com.pjx.demo2018.config.My2Properties;
import com.pjx.demo2018.mapper.UserMapper;
import com.pjx.demo2018.po.Mytest;
import com.pjx.demo2018.po.PurchPo;
import com.pjx.demo2018.vo.MyPost;
import com.pjx.demo2018.vo.MyPostXML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 * @author juqi
 * @date 18/5/17
 */
@RestController
public class DemoController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private FavorProperties favorProperties;

    @Autowired
    private My2Properties my2Properties;

    @RequestMapping(value = "/health_check", method = RequestMethod.GET)
    public String checkProjectHealth(){
        return "health check done";
    }

    @GetMapping(value = "/favor_properties")
    public String findFavorProperties(){
        return favorProperties.toString();
    }

    @GetMapping(value = "/my2_properties")
    public String findMy2Properties(){
        System.out.println(my2Properties.getRandom_int());
        System.out.println(my2Properties.getRandomInt());
        return my2Properties.toString();
    }

    @RequestMapping(value = "/check", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
    produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Object createTest(@RequestBody List<Mytest> mytest) {
        System.out.println(mytest.get(0).getName());
        System.out.println(mytest.get(0).getAddress());
//        System.out.println(mytest.get(1).getName());
//        System.out.println(mytest.get(1).getAddress());
        return null;
    }

    @RequestMapping(value = "/test/{value}", method = RequestMethod.GET)
    public String testGet1(@PathVariable("value") String value){
        return value+"value";
    }

    @RequestMapping(value = "/test/health_check/a", method = RequestMethod.GET)
    public String testGet1(){
        return "test1";
    }

    @RequestMapping(value = "/my_post", method = RequestMethod.POST ,produces = MediaType.APPLICATION_XML_VALUE)
    public MyPostXML myPost(){
//        MyPost myPost = new MyPost();
//        myPost.setX("x");
//        myPost.setY("Y");
        MyPostXML myPost = new MyPostXML();
        myPost.setReturn_code("123");
        return myPost;
    }

    @RequestMapping(value = "/secret", method = RequestMethod.GET)
    public PurchPo find() {
        PurchPo byId = userMapper.findById();
        System.out.println(byId.getOverdue());
        System.out.println(byId.getOverdue().getTime());
        System.out.println(byId.getId());
        return byId;
    }
}
