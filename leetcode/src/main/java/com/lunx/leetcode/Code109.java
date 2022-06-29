package com.lunx.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lunx
 * @version 1.0
 * @date 2022/06/29
 * @description
 */
public class Code109 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode sortedListToBST(ListNode head) {
        if (null == head) return null;

        List<Integer> numList = new ArrayList<>();
        do {
            numList.add(head.val);
            head = head.next;
        } while (null != head);

        int[] nums = new int[numList.size()];
        for (int i = 0; i < numList.size(); i++) {
            nums[i] = numList.get(i);
        }

        return helper(nums, 0, numList.size() - 1);
    }

    public TreeNode helper(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        int mid = (left + right) / 2;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, left, mid - 1);
        root.right = helper(nums, mid + 1, right);
        return root;
    }


    public static void main(String[] args) {
        Code109 code108 = new Code109();
    }
}
