package com.pjx.demo2018.dailytest.xxljob;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by juqi on 19/7/12.
 */
public class OrderHandler extends AbstractHandler {
    private Logger logger = LoggerFactory.getLogger(OrderHandler.class);
    @Override
    protected void testA() {
        logger.info("OrderHandler");
    }

    public static void main(String[] args) {
        OrderHandler handler = new OrderHandler();
        handler.test();
    }
}
