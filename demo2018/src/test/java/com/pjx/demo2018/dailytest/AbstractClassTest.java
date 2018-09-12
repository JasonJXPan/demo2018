package com.pjx.demo2018.dailytest;

import com.pjx.demo2018.dailytest.abs.Animal;
import com.pjx.demo2018.dailytest.abs.impl.Dog;
import org.junit.Test;

/**
 * Created by juqi on 18/8/21.
 */
public class AbstractClassTest {
    @Test
    public void test(){
        Animal animal = new Dog();
        animal.intro();
        ((Dog)animal).intro();
        Dog dog = new Dog();
        dog.intro();
        new Dog();
    }

    @Test
    public void test2(){
        Dog dog = new Dog();
        dog.setAge(1);
        dog.setName("dog-Doggy");
        System.out.println(dog.introduce());
    }

    @Test
    public void test3() {
        Dog dog = new Dog();
        dog.setAge(99);
        dog.introduce();
    }
}
