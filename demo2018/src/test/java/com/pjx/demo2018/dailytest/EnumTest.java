package com.pjx.demo2018.dailytest;

import com.pjx.demo2018.dailytest.domain.UnitTestStatusEnum;
import org.junit.Test;

/**
 * Created by juqi on 18/8/14.
 */
public class EnumTest {
    @Test
    public void test1(){
        System.out.println(UnitTestStatusEnum.FAIL);
        System.out.println(UnitTestStatusEnum.valueOf("FAIL"));
        System.out.println(UnitTestStatusEnum.valueOf(UnitTestStatusEnum.PASSED.name()));
        System.out.println(UnitTestStatusEnum.FAIL.name());
    }
}
