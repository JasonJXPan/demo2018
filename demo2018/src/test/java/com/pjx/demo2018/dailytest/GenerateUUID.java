package com.pjx.demo2018.dailytest;

import com.juqitech.service.utils.CommonUtil;
import com.juqitech.service.utils.ObjectId;

/**
 * GenerateUUID
 *
 * @author zhuhaitao
 * @since 2019-07-24
 */
public class GenerateUUID {

    private static final char[] HEX_CHARS = new char[]{
            '0', '1', '2', '3', '4', '5', '6', '7',
            '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    private static final char[] TEN_CHARS = new char[]{
            '0', '1', '2', '3', '4', '5', '6', '7',
            '8', '9'
    };

    public static String generate(int length){
        return toHexString(length);
    }

    public static String generateTen(int length){
        return toCharString(length);
    }

    private static String toHexString(int chartLength) {
        ObjectId objectId = new ObjectId();
        if (0 == chartLength){
            chartLength = 24;
        }
        char[] chars = new char[chartLength];
        int i = 0;
        for (byte b : objectId.toByteArray()) {
            chars[i++] = HEX_CHARS[b >> 4 & 0xF];
            chars[i++] = HEX_CHARS[b & 0xF];
        }
        return new String(chars);
    }

    private static String toCharString(int chartLength){
        ObjectId objectId = new ObjectId();
        char[] chars = new char[chartLength];
        int i = 0;
        for (byte b : objectId.toByteArray()){
            chars[i++] = TEN_CHARS[b >> 0 & 9];
            chars[i++] = TEN_CHARS[b & 9];
        }
        return new String(chars);
    }
}
