package com.pjx.demo2018.dailytest;

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
}
