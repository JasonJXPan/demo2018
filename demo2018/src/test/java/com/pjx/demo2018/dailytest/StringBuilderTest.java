package com.pjx.demo2018.dailytest;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.Test;

/**
 * Created by juqi on 18/7/27.
 */
public class StringBuilderTest {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("a").append("b").append("c");
        System.out.println(stringBuilder.subSequence(0, stringBuilder.length()-1));
    }

    @Test
    public void test1(){
        boolean flag = true;
        int i = 0;
        while (flag) {
            i ++;
            if (i == 9) {
                break;
            }
            System.out.println(i);
        }
    }
    @Test
    public void testSubString(){
        String a = "this is Jason";
        System.out.println(a.substring(1, 3));
    }
    @Test
    public void test2(){
        StringBuilder stringBuilder = new StringBuilder();
        String x = null;
        String x1 = "1";
        stringBuilder.append(x).append("a").append(1);
        String value = x+x1;
        System.out.println(value);
//        System.out.println(x.toString());

        Integer a = null;
        System.out.println(String.valueOf(a));
    }

    @Test
    public void test3(){
        RowsGroupBaseDTO baseDTO = new RowsGroupBaseDTO();
        baseDTO.setRowStart(4);
        baseDTO.setRowEnd(6);
        RowsGroupBaseDTO rowsGroupBaseDTO = RowsGroupGenerate.generateRowsGroupName(baseDTO);
        System.out.println(rowsGroupBaseDTO.getRowsGroupName());
    }



    class RowsGroupBaseDTO {
        private Integer row;
        private Integer rowStart;
        private Integer rowEnd;
        private String rowsGroupName;

        public RowsGroupBaseDTO() {
        }

        public Integer getRow() {
            return this.row;
        }

        public void setRow(Integer row) {
            this.row = row;
        }

        public Integer getRowStart() {
            return this.rowStart;
        }

        public void setRowStart(Integer rowStart) {
            this.rowStart = rowStart;
        }

        public Integer getRowEnd() {
            return this.rowEnd;
        }

        public void setRowEnd(Integer rowEnd) {
            this.rowEnd = rowEnd;
        }

        public String getRowsGroupName() {
            return this.rowsGroupName;
        }

        public void setRowsGroupName(String rowsGroupName) {
            this.rowsGroupName = rowsGroupName;
        }

        public String toString() {
            return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
        }
    }
}
class RowsGroupGenerate {
    public static StringBuilderTest.RowsGroupBaseDTO generateRowsGroupName(StringBuilderTest.RowsGroupBaseDTO rowsGroupBaseDTO) {
        StringBuilder rowsGroupName = (new StringBuilder()).append(rowsGroupBaseDTO.getRowStart());
        if(rowsGroupBaseDTO.getRowStart().intValue() > 3) {
            rowsGroupName = (new StringBuilder()).append(rowsGroupBaseDTO.getRowStart()).append("-").append(rowsGroupBaseDTO.getRowEnd());
        }

        rowsGroupBaseDTO.setRowsGroupName(rowsGroupName.append("排").toString());
        return rowsGroupBaseDTO;
    }
}
