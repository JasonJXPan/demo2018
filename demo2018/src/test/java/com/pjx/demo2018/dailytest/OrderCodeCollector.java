package com.pjx.demo2018.dailytest;

import com.pjx.demo2018.dailytest.enums.ResponseCode;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class OrderCodeCollector {

    @Test
    public void test() {
        Map<String, String> code = new HashMap<>();
        for (ResponseCode value : ResponseCode.values()) {
            String value1 = value.getMsg();
            if (code.containsKey(value.getCode())) {
                value1 = StringUtils.join(code.get(value.getCode()), " 或者 ",value1);
            }
            code.put(value.getCode(), value1);
//            System.out.println(value.getCode() +"--"+value.getMsg());
//            System.out.println(value.getCode());
//            System.out.println(value.getMsg());
        }
        ArrayList<Integer> strings = new ArrayList<>();
        code.keySet().forEach(item -> {
            strings.add(Integer.parseInt(item));
        });

        Collections.sort(strings);
        strings.forEach(item  ->{
            System.out.println(item+"--"+code.get(item+""));
        });
//        code.forEach((k, v) -> System.out.println(k+"--"+v));

    }
}
