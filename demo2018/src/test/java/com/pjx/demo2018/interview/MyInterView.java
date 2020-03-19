package com.pjx.demo2018.interview;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Created by juqi on 19/9/10.
 */
public class MyInterView {
    private static  String MODULE0_A = "";
    private static  String MODULE0_B = "";
    private static  String MODULE0_C = "";
    @Test
    public void mainTest() {
        System.out.println("main");
    }

    public String match(String module ,BigDecimal a,BigDecimal b,BigDecimal c){
        if (module.equals(getModule(a,b,c))){
            return module + "pipeichengong";
        }
        return module + "buchenggong";
    }

    public String getModule(BigDecimal a,BigDecimal b,BigDecimal c){
        if (a.compareTo(b) < 0 && b.compareTo(c) < 0){
            return  "a";
        }else if(b.compareTo(a) >= 0 && a.compareTo(c) >= 0){
            return "b";
        }else if (c.compareTo(b) >= 0 && b.compareTo(a) >=0 ){
            return "c";
        }
        return "other";
    }

}
