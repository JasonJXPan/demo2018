package com.pjx.demo2018.dailytest;

import org.junit.Test;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Base64;

/**
 * Created by juqi on 18/10/16.
 */
public class Base64Test {

    @Test
    public void test1(){
        String x = "abc我试试";
        byte[] encode = new byte[0];
        try {
            encode = Base64.getEncoder().encode(x.getBytes("utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(new String(encode));

        byte[] decode = new byte[0];
        try {
            decode = Base64.getDecoder().decode(new String(encode).getBytes("utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(new String(decode));
        try {
            System.out.println(InetAddress.getLocalHost().getCanonicalHostName());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
