package com.lunx.leetcode;

/**
 * @author XieDesong
 * @version 1.0
 * @title Code24
 * @description
 * @date 2019/04/30
 */
public class Code24 {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode swapPairs(ListNode head) {
        if (null == head || null == head.next) return head;

        ListNode result = new ListNode(0);
        ListNode k = result;
        ListNode p1 = head;
        ListNode p2 = head.next;

        while (p2 != null) {
            k.next = p2;
            p1.next = p2.next;
            p2.next = p1;

            if (p1.next != null) {
                k = p1;
                p1 = p1.next;
                p2 = p1.next;
            } else {
                break;
            }
        }

        return result.next;
    }

    public static void main(String[] args) {
        Code24 code24 = new Code24();

        ListNode listNode1 = new ListNode(9);
        for (int i = 8; i > 0; i--) {
            ListNode l = new ListNode(i);
            l.next = listNode1;

            listNode1 = l;
        }

        print(listNode1);
        System.out.println("*********");

        ListNode listNode = code24.swapPairs(listNode1);
        print(listNode);
    }

    private static void print(ListNode listNode) {
        ListNode p = listNode;

        while (p.next != null) {
            System.out.println(p.val);
            p = p.next;
        }

        System.out.println(p.val);
    }
}
