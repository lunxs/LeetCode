package com.lunx.leetcode;

import java.util.Arrays;
import java.util.List;

public class Code86 {

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode partition(ListNode head, int x) {
        if (head == null) return null;

        ListNode resList = null;
        ListNode result = resList;
        ListNode temp = head;

        // 过滤所有小于x的元素
        while (temp != null && temp.val < x) {
            if (null == resList) {
                resList = temp;
                result = resList;
            } else {
                resList = temp;
            }
            temp = temp.next;
        }
        if (temp == null) return result;

        // 右边部分（即 >= x 部分）起始位置
        ListNode rightPart = temp;

        ListNode temp1 = temp;
        while (null != (temp = temp.next)) {
            if (temp.val >= x) {
                temp1 = temp;
            } else {
                // 连接元素
                if (resList == null) {
                    resList = temp;
                    result = resList;
                } else {
                    resList.next = temp;
                    resList = resList.next;
                }
                // 删除<x的元素
                temp1.next = temp.next;
//                temp1 = temp1.next;
            }
        }

        if (resList == null) return head;

        resList.next = rightPart;
        return result;
    }


    public static void main(String[] args) {
        int[] ints = {1};
        ListNode listNode = init(ints);

        Code86 code86 = new Code86();
        ListNode partition = code86.partition(listNode, 2);
        print(partition);
    }

    /**
     * 初始化一个链表
     * @param ints
     * @return
     */
    private static ListNode init(int[] ints) {
        if (null == ints || ints.length == 0) return null;

        ListNode head = new ListNode(ints[0]);
        ListNode n = head;

        for (int i = 1; i < ints.length; i++) {
            n = add(n, new ListNode(ints[i]));
        }
        print(head);
        return head;
    }

    /**
     * 链表添加一个元素
     * @param listNode
     * @param next
     * @return
     */
    private static ListNode add(ListNode listNode, ListNode next) {
        listNode.next = next;
        listNode = listNode.next;
        return listNode;
    }

    /**
     * 打印链表 1 2 3 4 5 6
     * @param listNode
     */
    private static void print(ListNode listNode) {
        ListNode p = listNode;

        while (p != null) {
            System.out.print(p.val + " ");
            p = p.next;
        }

        System.out.println("");
    }
}
