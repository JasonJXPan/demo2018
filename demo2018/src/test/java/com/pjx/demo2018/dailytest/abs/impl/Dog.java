package com.pjx.demo2018.dailytest.abs.impl;

import com.pjx.demo2018.dailytest.abs.Animal;

/**
 * Created by juqi on 18/8/21.
 */
public class Dog extends Animal {
    private int age;
    @Override
    public boolean isAlive() {
        return age>=100;
    }
    public static void intro(){
        System.out.println("I am dog");
    }
    static {
        System.out.println("static code");
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
