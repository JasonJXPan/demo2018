package com.pjx.demo2018.dailytest.xxljob;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by juqi on 19/7/12.
 */
public abstract class AbstractHandler {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public void test() {
        logger.info("{} statrs", this.getClass().getSimpleName());
        testA();
    }
    protected abstract void testA();
}
