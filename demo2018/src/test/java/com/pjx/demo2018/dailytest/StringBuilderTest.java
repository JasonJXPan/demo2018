package com.pjx.demo2018.dailytest;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

/**
 * Created by juqi on 18/7/27.
 */
public class StringBuilderTest {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("a").append("b").append("c");
        System.out.println(stringBuilder.subSequence(0, stringBuilder.length()-1));
    }

    @Test
    public void test1(){
        boolean flag = true;
        int i = 0;
        while (flag) {
            i ++;
            if (i == 9) {
                break;
            }
            System.out.println(i);
        }
    }
    @Test
    public void testSubString(){
        String a = "this is Jason";
        System.out.println(a.substring(1, 3));
    }
    @Test
    public void test2(){
        StringBuilder stringBuilder = new StringBuilder();
        String x = null;
        String x1 = "1";
        stringBuilder.append(x).append("a").append(1);
        String value = x+x1;
        System.out.println(value);
//        System.out.println(x.toString());

        Integer a = null;
        System.out.println(String.valueOf(a));
    }
}
