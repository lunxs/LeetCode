package com.lunx.leetcode;

/**
 * @author XieDesong
 * @version 1.0
 * @title Code2
 * @description
 * @date 2019/02/21
 */
public class Code2 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int add = l1.val + l2.val;
        ListNode result = new ListNode(add % 10);
        int carry = add / 10;
        addTwoNumbers(l1.next, l2.next, carry, result);
        return result;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2, int carry, ListNode result) {
        if (l1 == null && l2 == null && carry == 0) {
            return result;
        }

        if (l1 != null) {
            carry += l1.val;
            l1 = l1.next;
        }
        if (l2 != null) {
            carry += l2.val;
            l2 = l2.next;
        }

        result.next = new ListNode(carry % 10);
        return addTwoNumbers(l1, l2, carry / 10, result.next);
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(3);
        ListNode l2 = new ListNode(8);

        System.out.println(l1);

        ListNode listNode = new Code2().addTwoNumbers(l1, l2);
        System.out.println(listNode);
    }
}
