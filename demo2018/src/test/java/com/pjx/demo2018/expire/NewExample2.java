package com.pjx.demo2018.expire;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class NewExample2 {
    @Test
    public void test() {
        //
//        2. 对1000万人进行抽奖，奖金总额100万，要求
//                * 至少50万人中奖
//                * 最少1元，最多5元
//   变和不变的 拆分

//        Random random = new Random();
//        for (int i =0; i<18; i++) {
//            System.out.println(random.nextInt(10-2)+1);
//        }
//        for (int i =0; i<18; i++) {
//            System.out.println(random.nextInt(10));
//        }
//        System.out.println(random.nextInt(10));

        System.out.println(test1(20000, 100, 5));
//        int totalMoney = 10000000;
//        int totalCandidates = 600000;
//        int leastCandidates = 500000;
//        int currentTotalCandidates = new Random().nextInt(totalCandidates-leastCandidates)+leastCandidates;
//        int bestLuck = 5;
//
//        int batch = 100;
//
////        int batchCount = Math.min(currentTotalCandidates/batch, totalMoney/batch);
//        int batchCount =currentTotalCandidates/batch;
//        List<List<Integer>> pools = new ArrayList<>(batchCount + 1);
//        for (int i = 0; i< batchCount; i++) {
//            pools.add(test1(totalMoney/batchCount, batch, bestLuck));
//        }
//        int leftCandidates = currentTotalCandidates - (batch * batchCount);
//        int leftMoney = totalMoney % batchCount;
//        System.out.println("currentTotalCandidates"+currentTotalCandidates);
//        System.out.println("batchCount"+batchCount);
//        System.out.println("left="+leftCandidates);
//        System.out.println("leftMoney="+leftMoney);
//
//        if (leftCandidates > 0 && leftMoney >0) {
//            pools.add(test1(leftMoney,leftCandidates, bestLuck));
//        }
//        int sum = 0;
//        int qty = 0;
//        for (List<Integer> pool : pools) {
//            for (int x : pool) {
//                sum += x;
//                qty++;
//            }
//        }
//        System.out.println("多少组="+pools.size());
//        System.out.println("总红包金额="+sum);
//        System.out.println("多少人抢到="+qty);
//        System.out.println(pools);


    }

    public List<Integer> test1(int totalAmount, int bingoCandidatesCount, int max) {

        List<Integer> places = new ArrayList<>(bingoCandidatesCount);
        Random random = new Random();
        int i =1;
        //取点 每个点就是被领取红包之和
        places.add(totalAmount);
        while (i < bingoCandidatesCount && i <=totalAmount) {
            int place = random.nextInt(totalAmount);
            if (!places.contains(place)) {
                places.add(place);
                i++;
            }
        }
        Collections.sort(places);
        System.out.println(places);
        List<Integer> pool = new ArrayList<>(bingoCandidatesCount);
        int currentAmount = 0;
        for (int place : places) {
            if (place - currentAmount> max) {
                pool.add(max);
                currentAmount += max;
            } else {
                pool.add(place-currentAmount);
                currentAmount = place;
            }
        }
        int sum = 0;

        for (int x : pool) {
            sum += x;
        }
        System.out.println("sum"+sum);
        System.out.println("size="+pool.size());
        return pool;

    }



}
