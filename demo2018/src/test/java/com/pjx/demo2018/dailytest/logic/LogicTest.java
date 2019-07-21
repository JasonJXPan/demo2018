package com.pjx.demo2018.dailytest.logic;

import com.pjx.demo2018.dailytest.logic.impl.Handsome;
import com.pjx.demo2018.dailytest.logic.impl.HandsomeWeak;
import com.pjx.demo2018.dailytest.logic.interfaces.MyInterface;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.*;

/**
 * Created by juqi on 19/5/23.
 */
public class LogicTest {

    @Test
    public void test1() {
        String s = outMethod();
        System.out.println(s);
    }

    @Test
    public void test2() {
        Handsome handsome = new Handsome();
        HandsomeWeak handsomeWeak = new HandsomeWeak();
        MyInterface myInterface1 = new Handsome();
        MyInterface myInterface2 = new HandsomeWeak();

        System.out.println(handsome.amIAwesome());
        System.out.println(handsomeWeak.amIAwesome());
        System.out.println(myInterface1.amIAwesome());
        System.out.println(myInterface2.amIAwesome());
    }

    static int i=0;
    @Test
    public void test3() {
        for (int i =0 ; i<=100; i++) {
            List<BigDecimal> randomRedPacketList = getRandomRedPacketList(3, new BigDecimal(100));
            System.out.println(randomRedPacketList);
        }
    }

public List<BigDecimal> getRandomRedPacketList(int n, BigDecimal amount) {
    if (n <= 1 || amount.compareTo(BigDecimal.ZERO) <= 0) {
        return Collections.emptyList();
    }

    BigDecimal maxLimitRatio = new BigDecimal("0.9");
    BigDecimal minLimit = BigDecimal.ZERO;

    List<BigDecimal> randomRedPackets = new ArrayList<>(n);

    BigDecimal maxForeachround = new BigDecimal(amount.doubleValue());
    BigDecimal sum = BigDecimal.ZERO;

    if (n == 2) {
        //如果是两个，对第一个有最低和最高的要求
        BigDecimal redPacket =
                getRandomRedPacket(maxForeachround.multiply(maxLimitRatio), maxForeachround.multiply(BigDecimal.ONE.subtract(maxLimitRatio)));
        randomRedPackets.add(redPacket.setScale(2, BigDecimal.ROUND_CEILING));
        sum = sum.add(redPacket);
    } else {
        //如果大于两个，如果前面n-2个数的和小于10%，那么对第n-1个数有最低限制要求
        for (int i = 0; i < n - 2; i++) {
            BigDecimal redPacket =
                    getRandomRedPacket(maxForeachround.multiply(maxLimitRatio), minLimit);
            randomRedPackets.add(redPacket.setScale(2, BigDecimal.ROUND_CEILING));
            sum = sum.add(redPacket);
            maxForeachround = maxForeachround.subtract(redPacket);
        }
        if (sum.compareTo(amount.multiply(BigDecimal.ONE.subtract(maxLimitRatio))) < 0) {
            //amount - sum - (amount*0.9)  --> amount*.01-sum
            minLimit = amount.multiply(BigDecimal.ONE.subtract(maxLimitRatio)).subtract(sum);
            BigDecimal redPacket = getRandomRedPacket(maxForeachround.multiply(maxLimitRatio), minLimit);
            randomRedPackets.add(redPacket.setScale(2, BigDecimal.ROUND_CEILING));
            sum = sum.add(redPacket);
            System.out.println("转交");
        } else {
            BigDecimal redPacket =
                    getRandomRedPacket(maxForeachround.multiply(maxLimitRatio), minLimit);
            randomRedPackets.add(redPacket.setScale(2, BigDecimal.ROUND_CEILING));
            sum = sum.add(redPacket);
            maxForeachround = maxForeachround.subtract(redPacket);
        }
    }

    if (amount.compareTo(sum) <= 0) {
        randomRedPackets.add(BigDecimal.ZERO);
    } else {
        BigDecimal subtract = amount.subtract(sum).setScale(2, BigDecimal.ROUND_CEILING);
        randomRedPackets.add(subtract);
    }

    return randomRedPackets;

}

private BigDecimal getRandomRedPacket(BigDecimal max, BigDecimal min) {
    if (i ==0) {
        i++;
        return BigDecimal.ONE;
    }else {

        BigDecimal random = new BigDecimal(Math.random());
        BigDecimal result = min.add(random.multiply((max.subtract(min))));
        return result.setScale(2, BigDecimal.ROUND_CEILING);
    }
}

    private String outMethod() {
        try {
            inMethod();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        } finally {
            System.out.println("this is finally");
        }
        return "success";
    }

    private void inMethod() {
        int x = 1/0;
    }


}
