package com.pjx.demo2018.dailytest;

import org.junit.Test;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * 类作用描述
 *
 * @author panjinxin
 * @since 19/3/6
 */
public class ZhongTongTest {
    public static final String UTF8 = "UTF-8";
    public static String buildQuery(Map<String, Object> params, String charset) throws IOException {
        if (params == null || params.isEmpty()) {
            return null;
        }

        StringBuffer data = new StringBuffer();
        boolean flag = false;

        for (Map.Entry<String, Object> entry : params.entrySet()) {
            if (flag) {
                data.append("&");
            } else {
                flag = true;
            }
            data.append(entry.getKey()).append("=").append(URLEncoder.encode(entry.getValue().toString(), charset));
        }
        return data.toString();

    }
    public static void main(String[] args) {
        Map<String, Object> params = new HashMap<>();
        Map<String, Object> params1 = new HashMap<>();
        params1.put("receive_district", "徐汇区");
        params1.put("unionCode", "5c7e3797a8e206173df447f9");
        params1.put("send_address", "华山路2018号汇银大厦北楼10楼");
        params1.put("send_province", "上海市");
        params1.put("receive_province", "上海市");
        params1.put("receive_city", "上海市");
        params1.put("receive_address", "XXX路XXX弄XXX号XXX室");

        params.put("data_digest", "oZNctucMxy6tN78J5yOf5A==");
        params.put("data", params1);
        params.put("company_id", "9a4321f19ba14987a28b651022102afa");
        params.put("msg_type", "TRACEABLEMARK_GETMARK");

        try {
            System.out.println(buildQuery(params, UTF8));
        } catch (IOException e) {

        }
    }
}