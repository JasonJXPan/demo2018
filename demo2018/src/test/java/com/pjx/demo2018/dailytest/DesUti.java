package com.pjx.demo2018.dailytest;

import com.juqitech.service.utils.DESUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

/**
 * Created by juqi on 18/8/23.
 */
public class DesUti {
    private static String DESKEY="juqitech";
    @Test
    public void test(){
        String password = "s0tJweBqCUAOoAsV6mDDUQ==";
        try {
            String pwd = DESUtils.decryptBase64(password, DESKEY);
            System.out.println(pwd);
            pwd = DigestUtils.md5Hex(pwd);
            System.out.println(pwd);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void test1(){
        String password = "ec495f598ea52046d2fd338299a14b21";
        try {
            String pwd = DESUtils.decryptHex(password, DESKEY);
            System.out.println(pwd);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
