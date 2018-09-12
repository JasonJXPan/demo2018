package com.pjx.demo2018.dailytest.comparator;

import com.pjx.demo2018.dailytest.domain.TreeSetObj;

import java.util.Comparator;

/**
 * Created by juqi on 18/8/29.
 */
public class MyComparator implements Comparator<TreeSetObj> {
    @Override
    public int compare(TreeSetObj o1, TreeSetObj o2) {
        if (o1 == null) {
            return 0;
        }
        if (o2 == null) {
            return 1;
        }
        return o1.getSequence()-o2.getSequence();
    }
}
