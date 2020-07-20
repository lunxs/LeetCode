package com.lunx.leetcode;

/**
 * @author desong.xie
 * @version 1.0
 * @date 2020/07/20
 * @description
 */
public class Code61 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
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

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return head;

        int length = 1;
        ListNode p = head;
        while (p.next != null) {
            length++;
            p = p.next;
        }

        k = k % length;
        if (k == 0) return head;

        ListNode result = head;
        ListNode p1 = head;
        int n = length - k;
        int i = 1;
        while (i++ < n) {
            p1 = p1.next;
            result = result.next;
        }
        result = result.next;
        p1.next = null;
        p.next = head;

        return result;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(5);
        for (int i = 4; i > 0; i--) {
            ListNode l = new ListNode(i);
            l.next = listNode;

            listNode = l;
        }

//        print(listNode);
        Code61 code61 = new Code61();
        ListNode listNode1 = code61.rotateRight(listNode, 6);
        print(listNode1);
    }

    private static void print(ListNode listNode) {
        ListNode listNode1 = listNode;

        while (listNode1 != null) {
            System.out.println(listNode1.val);
            listNode1 = listNode1.next;
        }
    }
}
