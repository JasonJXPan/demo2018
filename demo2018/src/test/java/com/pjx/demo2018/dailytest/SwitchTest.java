package com.pjx.demo2018.dailytest;

import com.pjx.demo2018.dailytest.domain.UnitTestStatusEnum;
import org.junit.Test;

/**
 * Created by juqi on 18/9/12.
 */
public class SwitchTest {

    @Test
    public void test1(){
        UnitTestStatusEnum statusEnum = UnitTestStatusEnum.FAIL;
        switch (statusEnum) {
            case PASSED:
                System.out.println("passed");
                return;
            case FAIL:
                System.out.println("fail");
                break;
            default:
                System.out.println("default");
        }
        System.out.println("the end");
    }
}
