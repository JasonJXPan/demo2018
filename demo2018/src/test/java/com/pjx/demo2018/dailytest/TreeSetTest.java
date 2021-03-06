package com.pjx.demo2018.dailytest;

import com.pjx.demo2018.dailytest.comparator.MyComparator;
import com.pjx.demo2018.dailytest.domain.TreeSetObj;
import org.junit.Test;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

/**
 * Created by juqi on 18/8/14.
 */
public class TreeSetTest {
    @Test
    public void test1(){
        TreeSet<TreeSetObj>  treeSet = new TreeSet<>();
        TreeSetObj obj1 = new TreeSetObj();
        obj1.setContent("a");
        obj1.setSequence(1);
        TreeSetObj obj2 = new TreeSetObj();
        obj2.setContent("b");
        obj2.setSequence(2);
        TreeSetObj obj3 = new TreeSetObj();
        obj3.setContent("b");
        obj3.setSequence(3);
        treeSet.add(obj1);
        treeSet.add(obj2);
        treeSet.add(obj3);
        System.out.println(treeSet);
    }

    @Test
    public void test2(){
        TreeSet<TreeSetObj>  treeSet = new TreeSet<>();
        List<TreeSetObj> list = new ArrayList<>();
        TreeSetObj obj1 = new TreeSetObj();
        obj1.setContent("a");
        obj1.setSequence(1);
        TreeSetObj obj2 = new TreeSetObj();
        obj2.setContent("b");
        obj2.setSequence(2);
        TreeSetObj obj3 = new TreeSetObj();
        obj3.setContent("b");
        obj3.setSequence(3);
        treeSet.add(obj1);
        treeSet.add(obj3);
        treeSet.add(obj2);
        list.add(obj1);
        list.add(obj3);
        list.add(obj2);
        TreeSet<TreeSetObj>  treeSet1 = new TreeSet<>(list);
        System.out.println(list);
        System.out.println(treeSet1);
    }

    @Test
    public void test3(){
        List<TreeSetObj> list = new ArrayList<>();
        TreeSetObj obj1 = new TreeSetObj();
        obj1.setContent("a");
        obj1.setSequence(1);
        TreeSetObj obj2 = new TreeSetObj();
        obj2.setContent("b");
        obj2.setSequence(2);
        TreeSetObj obj3 = new TreeSetObj();
        obj3.setContent("b");
        obj3.setSequence(3);
        list.add(obj1);
        list.add(obj3);
        list.add(obj2);
        System.out.println(list);
        MyComparator myComparator = new MyComparator();
        list.sort(myComparator);
        System.out.println(list);
    }
}
