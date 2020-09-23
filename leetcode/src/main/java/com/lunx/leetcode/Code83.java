package com.lunx.leetcode;

/**
 * @author lunx
 * @version 1.0
 * @date 2020/09/23
 * @description
 */
public class Code83 {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode l = head, r = head;

        while (r != null) {
            while (r != null && l.val == r.val) {
                r = r.next;
            }

            l.next = r;
            l = l.next;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);

        ListNode n1 = new ListNode(1);
        head.next = n1;

        ListNode n2 = new ListNode(2);
        n1.next = n2;

        ListNode n3 = new ListNode(3);
        n2.next = n3;

        ListNode n4 = new ListNode(3);
        n3.next = n4;

        System.out.println("************");
        Code83 code82 = new Code83();
        ListNode listNode1 = code82.deleteDuplicates(head);
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
