package com.pjx.demo2018.dailytest.abs;

/**
 * Created by juqi on 18/8/21.
 */
public abstract class Animal {
    private String name;
    private String color;

    //抽象类中可以有构造器
    public Animal() {
    }

    public static void intro() {
        System.out.println("I am animal");
    }

    public abstract boolean isAlive();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
