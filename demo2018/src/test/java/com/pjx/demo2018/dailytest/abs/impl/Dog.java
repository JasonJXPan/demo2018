package com.pjx.demo2018.dailytest.abs.impl;

import com.pjx.demo2018.dailytest.abs.Animal;

import javax.sound.midi.Soundbank;
import java.math.BigDecimal;

/**
 * Created by juqi on 18/8/21.
 */
public class Dog extends Animal {
    private int age;
    private BigDecimal ageTwo;
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

    public String introduce() {
        this.ageTwo = new BigDecimal(1L);
        validate();
        return this.getName() + "," + this.getAge();
    }

    private boolean validate(){
        BigDecimal bigDecimal = this.ageTwo;
        this.ageTwo = new BigDecimal(10L);
        System.out.println("bigDecimal:"+bigDecimal);
        System.out.println("this.ageTwo:"+this.ageTwo);
        this.age = 10;
        System.out.println("validating");
        return true;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public BigDecimal getAgeTwo() {
        return ageTwo;
    }

    public void setAgeTwo(BigDecimal ageTwo) {
        this.ageTwo = ageTwo;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "age=" + age +
                ", ageTwo=" + ageTwo +
                "} " + super.toString();
    }
}
