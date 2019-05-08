package com.lunx.leetcode;

/**
 * @author XieDesong
 * @version 1.0
 * @title Code25
 * @description
 * @date 2019/05/07
 */
public class Code25 {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k == 1) return head;

        ListNode result = new ListNode(0);
        result.next = head;

        int count = 0;
        ListNode p = result;
        ListNode p1 = result;
        ListNode temp = p.next;
        while (p1.next != null) {
            count++;
            p1 = p1.next;

            if (count == k) {
                count = 0;
                ListNode tail = p1.next;
                p1.next = null;
                p.next = swop(temp, tail);

                p = temp;
                p1 = p;
                temp = p.next;
            }
        }

        return result.next;
    }

    public ListNode swop(ListNode head, ListNode tail) {
        if (head.next == null) {
            head.next = tail;
            return head;
        }

        ListNode p = head;
        ListNode p1 = head;
        ListNode p2 = tail;

        while (null != p1) {
            p = p1;
            p1 = p1.next;
            p.next = p2;
            p2 = p;
        }

        return p;
    }

    public static void main(String[] args) {
        Code25 code25 = new Code25();

        ListNode listNode = new ListNode(9);
        for (int i = 8; i > 0; i--) {
            ListNode l = new ListNode(i);
            l.next = listNode;

            listNode = l;
        }

        print(listNode);

        ListNode node = code25.reverseKGroup(listNode, 1);
        System.out.println("*****************");
        print(node);
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
