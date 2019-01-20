package com.pjx.demo2018.dailytest;

import com.pjx.demo2018.dailytest.abs.impl.Dog;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
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
            if (item.equals("D")) { //删除倒数第二个不会有问题
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
        list.add("D");
        list.add("D1");
        list.add("e");
        list.add("D");
        for (int i=0; i< list.size(); i++) {
            String item = list.get(i);
            if (item.equals("D")) {
                System.out.println(item);
                item = "d";
                list.remove("D");
                i--;
            }
        }
        System.out.println(list);
    }
    @Test
    public void test2_1(){
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("D");
        list.add("D");
        list.add("D1");
        list.add("e");
        list.add("D");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().equals("D")) {
                iterator.remove();
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

    @Test
    public void test5(){
        List<String> list = Arrays.asList("1", "2");
        System.out.println(list);
        abc(list);
        System.out.println(list);
        //Arrays.asList 使用工具类 Arrays.asList()把数组转换成集合时，不能使用其修改集合相关的方
//        法，它的 add/remove/clear 方法会抛出 UnsupportedOperationException 异常。
//        说明： asList 的返回对象是一个 Arrays 内部类，并没有实现集合的修改方法。Arrays.asList
//        体现的是适配器模式，只是转换接口，后台的数据仍是数组
//        list.add("3");
//        System.out.println(list);
    }
    public void abc(List<String> list){
        list.add("4");
    }

    @Test
    public void test6(){
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("1");
        list.add("2");
        list.add("3");
        //会报错 java.util.ConcurrentModificationException
        for (String x : list) {
            if ("2".equals(x)) {
                list.remove(x);
            }
        }
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String x = iterator.next();
            if (x.equals("1")) {
                iterator.remove();
            }
        }
        System.out.println(list);
    }
}
