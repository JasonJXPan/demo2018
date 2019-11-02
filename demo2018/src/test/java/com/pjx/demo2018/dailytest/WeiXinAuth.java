package com.pjx.demo2018.dailytest;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.juqitech.service.utils.HttpUtils;
import com.juqitech.service.utils.net.CommonResult;
import com.juqitech.service.utils.net.StatusCode;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

/**
 * Created by juqi on 19/6/14.
 */
public class WeiXinAuth {
    private static Logger logger = LoggerFactory.getLogger(WeiXinAuth.class);

    @Test
    public void test() {
        String shortUrl = null;
        String authTokenURL = System.getProperty("auth_access_token_url");
        if (authTokenURL == null) {
//            authTokenURL = "https://www.tking.cn/authapi/pub/tm/weixin/token";
            authTokenURL = "https://www.moretickets.com/authapi/pub/tm/weixin/token";
        }
        JsonNode accesstokenResponse = HttpUtils
                .getData(authTokenURL, null);
        CommonResult commonResult = null;
        try {
            commonResult = new ObjectMapper()
                    .readValue(accesstokenResponse.toString(), CommonResult.class);
//            logger.info("response for getting access_token value={}", commonResult);
            if (StatusCode.success != commonResult.getStatusCode()) {
//                return shortUrl;
            }
        }catch (Exception e) {

        }
    }

    @Test
    public void test2() {
        shortUrl("http://mtl12kstage666.juqitech.com/promotion/booking");
    }

    public static String shortUrl(String url) {
        try {
            String httpUrl = "http://api.t.sina.com.cn/short_url/shorten.json?source=3213676317&url_long=";
            String jsonResult = request(httpUrl, url);
            JsonNode jsonNode = new ObjectMapper().readTree(jsonResult);
            logger.info("第一次返回为 result={}", jsonNode==null?null:jsonNode.toString());
            if (jsonNode.size() > 0) {
                Map<String, Object> obj = new ObjectMapper().readValue(String.valueOf(jsonNode.get(0)), Map.class);
                if (obj.containsKey("url_short")) {
                    return obj.get("url_short").toString().replaceAll("http://", "");
                }
            }
        } catch (Exception e) {
            logger.warn("第一次尝试失败");
            logger.warn(e.getMessage(), e);
        }
        try {
            //重试一次  临时方案，紧急给线上使用
            String httpUrl = "http://api.t.sina.com.cn/short_url/shorten.json?source=3271760578&url_long=";
            String jsonResult = request(httpUrl, url);
            JsonNode jsonNode = new ObjectMapper().readTree(jsonResult);
            logger.info("第一次重试返回为 result={}", jsonNode==null?null:jsonNode.toString());
            if (jsonNode.size() > 0) {
                Map<String, Object> obj = new ObjectMapper().readValue(String.valueOf(jsonNode.get(0)), Map.class);
                if (obj.containsKey("url_short")) {
                    return obj.get("url_short").toString().replaceAll("http://", "");
                }
            }
        } catch (IOException e) {
            logger.warn("第一次重试失败");
            logger.warn(e.getMessage(), e);
        }
        try {
            //重试第二次
            String httpUrl = "http://api.t.sina.com.cn/short_url/shorten.json?source=2815391962&url_long=";
            String jsonResult = request(httpUrl, url);
            JsonNode jsonNode = new ObjectMapper().readTree(jsonResult);
            logger.info("第二次重试返回为 result={}", jsonNode==null?null:jsonNode.toString());
            if (jsonNode.size() > 0) {
                Map<String, Object> obj = new ObjectMapper().readValue(String.valueOf(jsonNode.get(0)), Map.class);
                if (obj.containsKey("url_short")) {
                    return obj.get("url_short").toString().replaceAll("http://", "");
                }
            }
        } catch (IOException e) {
            logger.error("第二次重试失败");
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    private static String request(String httpUrl, String httpArg) throws IOException {
        StringBuffer sbf = new StringBuffer();
        httpUrl = httpUrl + httpArg;
        URL url = new URL(httpUrl);
        HttpURLConnection connection = (HttpURLConnection) url
                .openConnection();
        connection.setRequestMethod("GET");
        connection.connect();
        InputStream is = connection.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
        String strRead = null;
        while ((strRead = reader.readLine()) != null) {
            sbf.append(strRead);
            sbf.append("\r\n");
        }
        reader.close();
        String result = sbf.toString();
        return result;
    }
}
