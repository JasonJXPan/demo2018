package com.pjx.demo2018.expire;

import java.util.LinkedList;
import java.util.List;

public class NewExample3 {
 
    private static final int MIN_MONEY = 1;
 
    private static final int MAX_MONEY = 5;
 

    public List<Integer> splitRedPacket(int money, int count) {
        List<Integer> moneys = new LinkedList<>();
 
        if (MAX_MONEY * count < money) {
            System.err.println("请调大最大红包金额 MAX_MO最大NEY=[" + MAX_MONEY + "]");
            return moneys ;
        }
 
        MyDto myDto = null;
        for (int i = 0; i < count; i++) {
            //随机获取红包
            Integer redPacket = null;
            int tempMax = MAX_MONEY;
            int tempMin = MIN_MONEY;
            myDto = new MyDto();
            do {

                if (myDto.getMyMax() != null) {
                    tempMax = myDto.getMyMax();
                }
                if (myDto.getMyMin() != null) {
                    tempMin = myDto.getMyMin();
                }
                redPacket = randomRedPacket(money, tempMin, tempMax, count - i, myDto);
            } while (redPacket== null);
            moneys.add(redPacket);
            //总金额每次减少
            money -= redPacket;
        }
 
        return moneys;
    }
    class MyDto {
        private Integer myMin;
        private Integer myMax;

        public Integer getMyMin() {
            return myMin;
        }

        public void setMyMin(Integer myMin) {
            this.myMin = myMin;
        }

        public Integer getMyMax() {
            return myMax;
        }

        public void setMyMax(Integer myMax) {
            this.myMax = myMax;
        }
    }
 
    private Integer randomRedPacket(int totalMoney, int minMoney, int maxMoney, int count, MyDto myDto) {
        if (count == 1) {
            return totalMoney;
        }
 
        if (minMoney == maxMoney) {
            return minMoney;
        }
 
        maxMoney = maxMoney > totalMoney ? totalMoney : maxMoney;
 
        //在 minMoney到maxMoney 生成一个随机红包
        int redPacket = (int) (Math.random() * (maxMoney - minMoney) + minMoney);
 
        int leftMoney = totalMoney - redPacket;

        boolean result = checkMoney(leftMoney, count - 1, myDto, redPacket);
        if (result) {
            return redPacket;
        }
        return null;

    }


    private boolean checkMoney(int lastMoney, int count, MyDto myDto, int redPacket) {
        double avg = lastMoney / count;
        if (avg < MIN_MONEY ) {
            myDto.setMyMax(redPacket);
            return false;
        }
        if (avg > MAX_MONEY) {
            myDto.setMyMin(redPacket);
            return false;
        }

        return true;
    }
 
 
    public static void main(String[] args) {
        NewExample3 newExample3 = new NewExample3();
        List<Integer> redPackets = newExample3.splitRedPacket(100, 60);
        System.out.println(redPackets);
 
        int sum = 0;
        for (Integer red : redPackets) {
            sum += red;
        }
        System.out.println(sum);
        System.out.println(redPackets.size());
    }
 
}
