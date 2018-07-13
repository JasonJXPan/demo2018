package com.pjx.demo2018.singletest;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by juqi on 18/5/25.
 */
public class SingleTest {

    public static void main(String[] args) {
        System.out.println(Boolean.TRUE.equals(null));
        System.out.println(Boolean.TRUE.equals(true));
        System.out.println(Boolean.TRUE.equals(false));
        System.out.println(Boolean.FALSE.equals(null));
        System.out.println(Boolean.FALSE.equals(false));
        System.out.println(Boolean.FALSE.equals(true));


//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        Set<String> setA = new HashSet<>();
//        Set<String> setB = new HashSet<>();
//        try {
//            String value = reader.readLine();
//            while (!value.equals("end")){
//                setA.add(value);
//                value = reader.readLine();
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        try {
//            String value = reader.readLine();
//            while (!value.equals("end")){
//                setB.add(value);
//                value = reader.readLine();
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println(setA.retainAll(setB));
//        System.out.println(setA);
//        System.out.println(setB);


    }
}
