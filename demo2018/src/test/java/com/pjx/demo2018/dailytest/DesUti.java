package com.pjx.demo2018.dailytest;

import com.juqitech.service.utils.DESUtils;
import org.junit.Test;

/**
 * Created by juqi on 18/8/23.
 */
public class DesUti {
    private static String DESKEY="juqitech";
    @Test
    public void test(){
        String password = "ofwj0lBdaL4OoAsV6mDDUQ==";
        try {
            String pwd = DESUtils.decryptBase64(password, DESKEY);
            System.out.println(pwd);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
