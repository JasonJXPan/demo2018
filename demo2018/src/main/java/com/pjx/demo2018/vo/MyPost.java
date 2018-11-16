package com.pjx.demo2018.vo;

/**
 *
 * @author juqi
 * @date 18/11/13
 */
public class MyPost {
    private String x;
    private String y;

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "MyPost{" +
                "x='" + x + '\'' +
                ", y='" + y + '\'' +
                '}';
    }
}
