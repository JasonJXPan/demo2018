package com.pjx.demo2018.dailytest.excel;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.metadata.Sheet;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by juqi on 19/7/21.
 */
public class EasyExcelTest {
    @Test
    public void test() {
        InputStream inputStream = getResourcesFileInputStream("2007.xls");
        List<Object> data = EasyExcelFactory.read(inputStream, new Sheet(1, 0));
        try {
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        print(data);
    }
    public void print(List<Object> datas){
        int i=0;
        for (Object ob:datas) {
            System.out.println(i++);
            System.out.println(ob);
        }
    }

    public static InputStream getResourcesFileInputStream(String fileName) {
        return Thread.currentThread().getContextClassLoader().getResourceAsStream("" + fileName);
    }
}
