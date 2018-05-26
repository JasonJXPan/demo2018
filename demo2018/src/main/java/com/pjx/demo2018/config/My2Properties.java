package com.pjx.demo2018.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author juqi
 * @date 18/5/24
 */
@Component
@PropertySource("classpath:my2.properties")
@ConfigurationProperties(prefix = "my2")
public class My2Properties {
    private String name;
    private int count;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "My2Properties{" +
                "name='" + name + '\'' +
                ", count=" + count +
                '}';
    }
}
