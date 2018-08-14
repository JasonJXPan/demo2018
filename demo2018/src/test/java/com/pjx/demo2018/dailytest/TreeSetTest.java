package com.pjx.demo2018.dailytest;

import com.pjx.demo2018.dailytest.domain.TreeSetObj;
import org.junit.Test;

import java.util.Comparator;
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
}
