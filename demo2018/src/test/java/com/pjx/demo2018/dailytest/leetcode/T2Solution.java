package com.pjx.demo2018.dailytest.leetcode;

/**
 * Created by juqi on 18/10/5.
 */
/*
给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。将两数相加返回一个新的链表。

你可以假设除了数字 0 之外，这两个数字都不会以零开头。

示例：

输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 0 -> 8
原因：342 + 465 = 807

*/

public class T2Solution {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(2);
        listNode1.next = new ListNode(4);
        listNode1.next.next = new ListNode(3);
        ListNode listNode2 = new ListNode(5);
        listNode2.next = new ListNode(6);
        listNode2.next.next = new ListNode(4);
        addTwoNumbers(listNode1, listNode2);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int addFlag = 0;
        ListNode first = null;
        ListNode previous = null;
        while (l1 != null || l2 != null) {
            int int1 = 0;
            int int2 = 0;
            if (l1 != null) {
                int1 = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                int2 = l2.val;
                l2 = l2.next;
            }
            int sum = int1 + int2 + addFlag;
            addFlag = 0;
            if (sum >= 10) {
                addFlag = 1;
            }
            String sumStr = String.valueOf(sum);
            if (first == null) {
                first = new ListNode(Integer.parseInt(String.valueOf(sumStr.charAt(sumStr.length() - 1))));
                previous = first;
                continue;
            }
            if (previous != null) {
                previous.next = new ListNode(Integer.parseInt(String.valueOf(sumStr.charAt(sumStr.length() - 1))));
                previous = previous.next;
            }
        }
        if (addFlag > 0) {
            if (first == null) {
                first = new ListNode(Integer.parseInt(String.valueOf(addFlag)));
                previous = first;
            }
            if (previous != null) {
                previous.next = new ListNode(Integer.parseInt(String.valueOf(addFlag)));;
            }
        }

        return first;

    }

    public ListNode addTwoNumbersBest(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
