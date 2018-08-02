package com.pjx.demo2018.dailytest.util;


import org.bson.types.ObjectId;

/**
 * Created by juqi on 18/8/1.
 */
public class ObjectOIDUtil {
    public static String generateOID() {
        return new ObjectId().toString();
    }
}
