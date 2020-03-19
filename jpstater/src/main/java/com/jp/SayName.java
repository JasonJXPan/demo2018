package com.jp;

/**
 * 测试-告知自己的名字
 *
 * @author panjinxin
 * @since 2020/2/16
 */
public class SayName {
    private String name;

    public SayName(String name) {
        this.name = name;
    }

    public String sayMyName() {
        return this.name;
    }
}
