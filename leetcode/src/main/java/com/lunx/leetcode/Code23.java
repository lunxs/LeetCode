package com.lunx.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author XieDesong
 * @version 1.0
 * @title Code23
 * @description
 * @date 2019/04/25
 */
public class Code23 {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode result = new ListNode(0);
        ListNode p = result;

        List<ListNode> listNodes = new ArrayList<>();
        for (ListNode n : lists) {
            if (n != null)
                listNodes.add(n);
        }

        while (listNodes.size() > 0) {
            int val = Integer.MAX_VALUE;
            int tempi = 0;
            for (int i = 0; i < listNodes.size(); i++) {
                if (null != listNodes.get(i) && listNodes.get(i).val < val) {
                    val = listNodes.get(i).val;
                    tempi = i;
                }
            }

            p.next = listNodes.get(tempi);
            p = p.next;
            ListNode next = listNodes.get(tempi).next;

            listNodes.remove(tempi);

            if (next != null) {
                listNodes.add(next);
            }
        }

        return result.next;
    }

    private boolean check(ListNode[] lists) {
        for (int i = 0; i < lists.length; i++) {
            if (null != lists[i])
                return true;
        }

        return false;
    }

    private ListNode test(ListNode[] lists) {
        if (null == lists || lists.length == 0)
            return null;

        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, (a, b) -> a.val - b.val);
        ListNode result = new ListNode(0);
        ListNode p = result;

        for (ListNode n : lists)
            if (n != null)
                queue.add(n);

        while (!queue.isEmpty()) {
            p.next = queue.poll();
            p = p.next;

            if (p.next != null) {
                queue.add(p.next);
            }
        }

        return result.next;
    }

    public static void main(String[] args) {
        Code23 code23 = new Code23();

        List<ListNode> listNodes = new ArrayList<>();
        ListNode listNode1 = new ListNode(7);
        for (int i = 6; i > 0; i--) {
            ListNode l = new ListNode(i);
            l.next = listNode1;

            listNode1 = l;
        }
        listNodes.add(listNode1);

        ListNode listNode2 = new ListNode(5);
        for (int i = 4; i > 0; i--) {
            ListNode l = new ListNode(i);
            l.next = listNode2;

            listNode2 = l;
            i--;
        }
        listNodes.add(listNode2);

//        listNodes.add(new ListNode(0));

        ListNode listNode = code23.mergeKLists(listNodes.toArray(new ListNode[3]));

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
