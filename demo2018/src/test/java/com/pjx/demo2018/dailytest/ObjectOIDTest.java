package com.pjx.demo2018.dailytest;

import com.pjx.demo2018.dailytest.util.ObjectOIDUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by juqi on 18/8/1.
 */
public class ObjectOIDTest {
    @Test
    public void test1(){
        for (int i=0; i < 4; i++) {
            System.out.println(ObjectOIDUtil.generateOID());
        }
    }

    @Test
    public void test2(){
        System.out.println(UUID.randomUUID().toString().replace("-", "").length());
        System.out.println(UUID.randomUUID().toString().replace("-", "").length());
        System.out.println(UUID.randomUUID().toString().replace("-", "").length());
        String a = "a";
        String b = "b";
        List<String> list = new ArrayList<>();
        list.add(a);
        list.add(b);
        System.out.println(list.contains("a"));
        System.out.println(list.contains("a1"));
        long x = 0L;
        x = test111();
    }

    public Long test111(){
        return null;
    }
    @Test
    public void test3(){
        int a = 1;
        int b = 1;
        System.out.println(a ==b);
        int a1 = new Integer(200);
        int b1 = new Integer(200);
        System.out.println(a1 == b1);
    }

    @Test
    public void test4() {
        String x = "5c17651ba8e20658c4a0fb1b,5c17651ba8e20658c4a0fb1c,5c17651ba8e20658c4a0fb1d,5c177a31a8e20661834f85cc,5c177a31a8e20661834f85cd,5c177a31a8e20661834f85ce,5c20794ca8e2062e11f601ce,5c20794ca8e2062e11f601cf,5c20794ca8e2062e11f601d0,5c20795fa8e2062e11f601d9,5c20795fa8e2062e11f601da,5c20795fa8e2062e11f601db,5c20795fa8e2062e11f601dc,5c2749090ffd4e225d87c60d,5c2749090ffd4e225d87c60e,5c2749090ffd4e225d87c60f,5b5a951b908c381ad85aa9de,5b5a951b908c381ad85aa9df,5b5a951b908c381ad85aa9e0,5b5a951b908c381ad85aa9e1,5b5a951b908c381ad85aa9e2,5b5a951b908c381ad85aa9e3,5b5a951b908c381ad85aa9e4,5b5a951b908c381ad85aa9e5,5b5a951b908c381ad85aa9e6,5b5a951b908c381ad85aa9e7,5b5a951b908c381ad85aa9e8,5b5a951b908c381ad85aa9e9,5b5a951b908c381ad85aa9ea,5b5a951b908c381ad85aa9eb,5b5a951b908c381ad85aa9ec,5b5a951b908c381ad85aa9ed,5b5a951b908c381ad85aa9ee,5b5a951b908c381ad85aa9ef,5b5a951b908c381ad85aa9f0,5b5a951b908c381ad85aa9f1,5b5a951b908c381ad85aa9f2,5b5a951b908c381ad85aa9f3,5b5a951b908c381ad85aa9f4,5b5a951b908c381ad85aa9f5,5b5a951b908c381ad85aa9f6,5b5a951b908c381ad85aa9f7,5b5a951b908c381ad85aa9f8,5b5a951b908c381ad85aa9f9,5b5a951b908c381ad85aa9fa,5b5a951b908c381ad85aa9fb,5b5a951b908c381ad85aa9fc,5b5a951b908c381ad85aa9fd,5b5a951b908c381ad85aa9fe,5b5a951b908c381ad85aa9ff,5b5a951b908c381ad85aaa00,5b5a951b908c381ad85aaa01,5b5a951b908c381ad85aaa02,5b5a951b908c381ad85aaa03,5b5a951b908c381ad85aaa04,5b5a951b908c381ad85aaa05,5b5a951b908c381ad85aaa06,5b5a951b908c381ad85aaa07,5b5a951b908c381ad85aaa08,5b5a951b908c381ad85aaa09,5b5a951b908c381ad85aaa0a,5b8f7a1f908c3866b022a269,5b8f7a1f908c3866b022a26a,5b8f7a1f908c3866b022a26b,5b8f7a1f908c3866b022a26c,5b8f7a1f908c3866b022a26d,5b8f7a1f908c3866b022a26e,5b8f7a1f908c3866b022a26f,5b8f7a1f908c3866b022a270,5b8f7a1f908c3866b022a271,5b8f7a1f908c3866b022a272,5b8f7a1f908c3866b022a273,5b8f7a1f908c3866b022a274,5b90b60dc756b105bcfda399,5b90b60dc756b105bcfda39a,5b90b60dc756b105bcfda39b,";
        System.out.println(x.contains("5b8f7a1f908c3866b022a2aa"));
    }
}
