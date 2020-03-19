package com.pjx.demo2018.controller;

import com.pjx.demo2018.service.ControllerVersionStore;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 类作用描述
 *
 * @author panjinxin
 * @since 2019/12/2
 */
@RestController
public class TestController {

    @Autowired
    private ControllerVersionStore controllerVersionStore;

    @RequestMapping(value = "/test123_123", method = RequestMethod.GET)
    public void find(@RequestParam(value = "a")String a){
        if (StringUtils.equals("a", a)) {
//            try {
//                Thread.sleep(3000L);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            controllerVersionStore.setVersion(ControllerVersionStore.ControllerVersion.V2);
        }
        if (StringUtils.equals("b", a)) {
//            try {
//                Thread.sleep(5000L);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            controllerVersionStore.setVersion(ControllerVersionStore.ControllerVersion.V1);
        }
        System.out.println(a +"------"+controllerVersionStore.getVersion());
    }
}
