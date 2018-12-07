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
    private String random;
    private int random_int;
    private int randomInt;

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

    public String getRandom() {
        return random;
    }

    public void setRandom(String random) {
        this.random = random;
    }

    public int getRandom_int() {
        return random_int;
    }

    public void setRandom_int(int random_int) {
        this.random_int = random_int;
    }

    public int getRandomInt() {
        return randomInt;
    }

    public void setRandomInt(int randomInt) {
        this.randomInt = randomInt;
    }

    @Override
    public String toString() {
        return "My2Properties{" +
                "name='" + name + '\'' +
                ", count=" + count +
                ", random='" + random + '\'' +
                ", random_int=" + random_int +
                ", randomInt=" + randomInt +
                '}';
    }
}
