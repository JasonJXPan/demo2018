package com.pjx.demo2018.dailytest;

import com.pjx.demo2018.dailytest.domain.UnitTestStatusEnum;
import com.pjx.demo2018.dailytest.enums.CodeStatus;
import org.junit.Test;

import java.util.List;

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

    @Test
    public void test2() {
        myEnum(UnitTestStatusEnum.FAIL);
    }

    public void myEnum(Enum<? extends Enum> enumValue) {
        System.out.println(enumValue);
    }
    public void myEnums(List<Enum<? extends Enum>> enumValues) {
    }

    @Test
    public void test3() {
        CodeStatus codeStatus = CodeStatus.valueOf("VALID");
        System.out.println(codeStatus);
    }
}
