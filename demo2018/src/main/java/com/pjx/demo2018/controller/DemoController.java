package com.pjx.demo2018.controller;

import com.pjx.demo2018.config.FavorProperties;
import com.pjx.demo2018.config.My2Properties;
import com.pjx.demo2018.po.Mytest;
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
}
