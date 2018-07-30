package com.pjx.demo2018.dailytest.util;


import org.apache.commons.lang3.StringUtils;

/**
 * Created by juqi on 18/7/30.
 */
public class StringProcessUtil {
    public static String getBreviaryValue(String content, int limitLengthFromStart, String placeHolder){
        if (StringUtils.isBlank(content) || StringUtils.length(content) <= limitLengthFromStart) {
            return content;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(content.substring(0, limitLengthFromStart));
        stringBuilder.append(placeHolder);
        return stringBuilder.toString();
    }
}
