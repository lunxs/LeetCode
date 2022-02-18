package com.lunx.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author lunx
 * @version 1.0
 * @date 2022/02/18
 * @description
 */
public class Code104 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int maxDepth(TreeNode root) {
        int result = 0;
        if (null == root) return result;

        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        treeNodeQueue.offer(root);
        while (!treeNodeQueue.isEmpty()) {
            result++;

            int size = treeNodeQueue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = treeNodeQueue.poll();
                if (null != poll.left) treeNodeQueue.offer(poll.left);
                if (null != poll.right) treeNodeQueue.offer(poll.right);
            }

        }
        return result;
    }

    public static void main(String[] args) {

    }
}
