package com.pjx.demo2018.controller;

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

    @RequestMapping(value = "/health_check", method = RequestMethod.GET)
    public boolean checkProjectHealth(){
        return true;
    }
}
