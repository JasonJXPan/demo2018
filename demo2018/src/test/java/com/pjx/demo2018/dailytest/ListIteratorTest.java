package com.pjx.demo2018.dailytest;

import com.pjx.demo2018.dailytest.abs.Animal;
import com.pjx.demo2018.dailytest.abs.impl.Dog;
import com.sun.tools.corba.se.idl.constExpr.And;
import org.junit.Test;

import javax.sound.midi.Soundbank;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by juqi on 18/9/10.
 */
public class ListIteratorTest {

    @Test
    public void test1() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("D");
        list.add("e");
        for (String item : list) {
            if (item.equals("D")) {
                System.out.println(item);
                item = "d";
                list.remove("D");
            }
        }
        list.add("d");
        System.out.println(list);
    }
    @Test
    public void test2(){
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("D");
        list.add("e");
        for (int i=0; i< list.size(); i++) {
            String item = list.get(i);
            if (item.equals("D")) {
                System.out.println(item);
                item = "d";
                list.remove("D");
                list.add("d");
            }
        }
        System.out.println(list);
    }

    @Test
    public void test3(){
        List<Dog> animals = new ArrayList<>();
        Dog dog1 = new Dog();
        dog1.setAge(1);
        Dog dog2 = new Dog();
        dog2.setAge(2);
        Dog dog3 = new Dog();
        dog3.setAge(3);
        animals.add(dog1);
        animals.add(dog2);
        animals.add(dog3);
        Dog dogA = new Dog();
        dogA.setAge(11);
        Iterator<Dog> dogIterator = animals.iterator();
        while (dogIterator.hasNext()) {
            Dog dog = dogIterator.next();
            if (dog.getAge() ==1){
                dogIterator.remove();
                //        throw ConcurrentModificationException
//                animals.add(dogA);
            }
        }
        animals.add(dogA);
//        throw ConcurrentModificationException
//        for (Dog dog : animals) {
//            if (dog.getAge() ==1){
//                animals.remove(dog);
//            }
//        }
        System.out.println(animals);

    }

    @Test
    public void test4(){
        List<Dog> animals = new ArrayList<>();
        Dog dog1 = new Dog();
        dog1.setAge(1);
        Dog dog2 = new Dog();
        dog2.setAge(2);
        Dog dog3 = new Dog();
        dog3.setAge(3);
        animals.add(dog1);
        animals.add(dog2);
        animals.add(dog3);
        Dog dogA = new Dog();
        dogA.setAge(11);
        long count = animals.stream().filter(dog -> dog.getAge() == 23).count();
        System.out.println(count);
//        System.out.println(animals);
//        animals.stream().filter(dog -> dog.getAge()==1).forEach(dog -> changeDog(dog, dogA));

        System.out.println(animals);

        animals.removeIf(dog -> dog.getAge()==1);
        System.out.println(animals);

    }
    public void changeDog(Dog dogFrom, Dog dog){
        dogFrom = dog;
    }
}
