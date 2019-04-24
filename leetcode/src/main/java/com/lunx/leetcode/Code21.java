package com.lunx.leetcode;

/**
 * @author XieDesong
 * @version 1.0
 * @title Code21
 * @description
 * @date 2019/04/24
 */
public class Code21 {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (null == l1)
            return l2;

        if (null == l2)
            return l1;

        // 调整l1指向小链表
        if (l1.val > l2.val) {
            ListNode temp = l1;
            l1 = l2;
            l2 = temp;
        }
        ListNode p = l1;
        while (null != l1 && null != l2) {
            if (null == l1.next) {
                l1.next = l2;
                break;
            }

            if (l1.next.val > l2.val) {
                ListNode temp = l1.next;
                l1.next = l2;
                l2 = temp;
            } else {
                l1 = l1.next;
            }
        }

        return p;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(6);
        ListNode listNode1 = new ListNode(6);
        for (int i = 5; i > 0; i--) {
            ListNode l = new ListNode(i);
            ListNode l1 = new ListNode(i);
            l.next = listNode;
            l1.next = listNode1;

            listNode = l;
            listNode1 = l1;
        }

        Code21 code21 = new Code21();
        ListNode node = code21.mergeTwoLists(listNode1, listNode);
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
