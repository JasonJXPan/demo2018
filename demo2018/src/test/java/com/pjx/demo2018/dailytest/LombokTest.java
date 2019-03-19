package com.pjx.demo2018.dailytest;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Test;

/**
 * 类作用描述
 *
 * @author panjinxin
 * @since 19/3/14
 */
public class LombokTest {
    @Test
    public void test() {
        LombokObj lombokObj = new LombokObj();
        lombokObj.setAge(12);
        lombokObj.setText("haha");
        System.out.println(lombokObj);
    }
}

@Data
class LombokObj {
    private String text;
    private Integer age;
}