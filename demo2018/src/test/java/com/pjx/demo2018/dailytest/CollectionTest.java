package com.pjx.demo2018.dailytest;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.*;

/**
 * Created by juqi on 18/9/25.
 */
public class CollectionTest {
    @Test
    public void test1(){
//        Set<String> set = null;
//        Set<String> all = new HashSet<>();
//        all.add("a");
//        all.add("B");
//        all.removeAll(set);
//        System.out.println(all);

        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        List<String> list1 = new ArrayList<>();
        list1.add("1");
        list.removeAll(list1);
        System.out.println(list);
    }

    @Test
    public void test2(){
        List<String> list = new ArrayList<>();
        list.add("1");
        System.out.println(list);
        list.addAll(Collections.emptyList());
        System.out.println(list);

        List<String> ids = new ArrayList<>();
        ids.add("1");
        ids.add("2");
        ids.add("3");

        Map<String, String> map = new HashMap<>();
        for (String id : ids) {
            String x = null;
            if (StringUtils.equals(id, "1")) {
                 x = "a";
            } else if (StringUtils.equals(id, "2")) {
                x = "b";
            }
            if (x == null) {
                System.out.println("continue");
                continue;
            }
            map.put(x, x);
        }
        System.out.println(map);

    }

    @Test
    public void test3() {
        A a = new A();
        a.setX("x");
        a.setY("y");
        A a1 = new A();
        a1.setY("y1");
        a1.setX("x");
        Set<A> testSet = new HashSet<>();
        testSet.add(a);
        testSet.add(a1);
        System.out.println(testSet);
        final Object PRESENT = new Object();
        Map<A, Object> testObjMap = new HashMap<>();
        testObjMap.put(a, PRESENT);
        testObjMap.put(a1, PRESENT);
        System.out.println(testObjMap);
        Map<A, A> testMap = new HashMap<>();
        testMap.put(a, a);
        testMap.put(a1, a1);
        System.out.println(testMap);
    }

    @Test
    public void test4() {
        List<String> strings = Arrays.asList("1", "2", "3");
        ArrayList<String> strings1 = new ArrayList<>(strings);
//        strings.remove(0);
        strings1.remove(0);
    }



    class A {
        private String x;
        private String y;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            A a = (A) o;

            return getX() != null ? getX().equals(a.getX()) : a.getX() == null;
        }

        @Override
        public int hashCode() {
            return getX() != null ? getX().hashCode() : 0;
        }

        public String getY() {
            return y;
        }

        public void setY(String y) {
            this.y = y;
        }

        public String getX() {
            return x;
        }

        public void setX(String x) {
            this.x = x;
        }

        @Override
        public String toString() {
            return "A{" +
                    "x='" + x + '\'' +
                    ", y='" + y + '\'' +
                    '}';
        }
    }
}
