package com.lunx.leetcode;

import com.sun.org.apache.xerces.internal.dom.PSVIAttrNSImpl;

/**
 * @author lunx
 * @version 1.0
 * @date 2021/09/03
 * @description
 */
public class Code92 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) return head;

        ListNode pre = head;
        int count = 1;
        while (pre != null && ++count < left) {
            pre = pre.next;
        }

        while (pre != null && ++count < right) {
            ListNode ln = pre.next;
            pre.next = ln.next;
            ln.next = ln.next.next;
            pre.next.next = ln;
        }

        return head;
    }

    public static void main(String[] args) {
        Code92 code92 = new Code92();
        ListNode init = code92.init();

        ListNode listNode = code92.reverseBetween(init, 2, 4);
        while (listNode != null) {
            System.out.print(listNode.val);
            System.out.print(",");
            listNode = listNode.next;
        }
    }

    public ListNode init() {
        ListNode head = new ListNode(1);
        ListNode h = head;

        for (int i = 2; i < 10; i++) {
            h.next = new ListNode(i);
            h = h.next;
        }

        ListNode sHead = head;
        while (sHead != null) {
            System.out.print(sHead.val);
            System.out.print(",");
            sHead = sHead.next;
        }

        System.out.println("");
        return head;
    }
}
