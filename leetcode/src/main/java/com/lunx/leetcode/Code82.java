package com.lunx.leetcode;

/**
 * @author lunx
 * @version 1.0
 * @date 2020/09/23
 * @description
 */
public class Code82 {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode l = head, r = head.next;

        if (r != null && l.val == r.val) {
            while (r != null) {
                while (r != null && l.val == r.val) {
                    r = r.next;
                }

                if (r == null) return null;
                l = r;
                if (r.next == null) return l;
                r = r.next;
                if (l.val != r.val) break;
            }

            head = l;
        }
        ListNode cur = head;

        while (r != null) {
            while (r != null && l.val == r.val) {
                r = r.next;
            }

            if (r == null) {
                cur.next = null;
            } else {
                l = r;
                if (r.next == null) {
                    cur.next = l;
                    r = r.next;
                } else {
                    r = r.next;
                    if (l.val != r.val) {
                        cur.next = l;
                        cur = cur.next;
                    }
                }
            }
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

//        print(listNode);

        System.out.println("************");
        Code82 code82 = new Code82();
        ListNode listNode1 = code82.deleteDuplicates(listNode);
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
