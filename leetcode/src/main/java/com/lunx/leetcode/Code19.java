package com.lunx.leetcode;

/**
 * @author XieDesong
 * @version 1.0
 * @title Code19
 * @description
 * @date 2019/04/19
 */
public class Code19 {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) { val = x; }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p = head;
        ListNode p1 = head;
        int count = 0;

        while (p1.next != null) {
            count++;
            p1 = p1.next;

            if (count > n) {
                p = p.next;
            }
        }

        if (count < n) {
            head = head.next;
        } else {
            p.next = p.next.next;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(6);
        for (int i = 5; i > 0; i--) {
            ListNode l = new ListNode(i);
            l.next = listNode;

            listNode = l;
        }

        print(listNode);

        System.out.println("************");
        Code19 code19 = new Code19();
        ListNode listNode1 = code19.removeNthFromEnd(listNode, 6);
        print(listNode1);
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
