package com.pjx.demo2018.controller;

import com.pjx.demo2018.config.FavorProperties;
import com.pjx.demo2018.config.My2Properties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
}
