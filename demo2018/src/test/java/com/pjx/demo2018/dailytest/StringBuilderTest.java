package com.pjx.demo2018.dailytest;

/**
 * Created by juqi on 18/7/27.
 */
public class StringBuilderTest {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("a").append("b").append("c");
        System.out.println(stringBuilder.subSequence(0, stringBuilder.length()-1));
    }
}
