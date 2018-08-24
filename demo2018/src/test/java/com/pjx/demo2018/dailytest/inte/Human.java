package com.pjx.demo2018.dailytest.inte;

/**
 * Created by juqi on 18/8/21.
 */
public class Human implements Swimable {
    private int age;
    @Override
    public boolean swim() {
        return age>=3 && age<= 90;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
