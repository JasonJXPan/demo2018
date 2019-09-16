package com.pjx.demo2018.dailytest.leetcode;

import org.apache.commons.collections.CollectionUtils;
import org.apache.el.parser.Node;
import org.junit.Test;

import java.util.List;

/**
 * Created by juqi on 19/5/13.
 */
public class ViewTest {

    @Test
    public void test() {
    }

    private List<Node> generate(int total, int round) {
        if (round == 0) {
            return null;
        }
        for (int i =1; i<= total/2; i++) {
            for (int j =1; j<=total;j++) {

            }
        }
        return null;
    }


    class MyObj {
        private List<Integer> nodes;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof MyObj)) return false;

            MyObj myObj = (MyObj) o;

            return nodes != null ? nodes.equals(myObj.nodes) : myObj.nodes == null;

        }

        @Override
        public int hashCode() {
            if (CollectionUtils.isEmpty(nodes)) {
                return -1;
            }
            int sum = -1;
            for (Integer nodeVale : nodes) {
                sum += nodeVale;
            }
            return sum;
        }
    }
}
