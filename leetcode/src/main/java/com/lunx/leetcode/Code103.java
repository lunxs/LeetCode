package com.lunx.leetcode;

import java.util.*;

/**
 * @author lunx
 * @version 1.0
 * @date 2022/02/17
 * @description
 */
public class Code103 {

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

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (null == root) return result;

        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        treeNodeQueue.offer(root);
        int level = 0;

        while (!treeNodeQueue.isEmpty()) {
            List<Integer> temp = new LinkedList<>();

            int currentLevelSize = treeNodeQueue.size();
            for (int i = 1; i <= currentLevelSize; ++i) {
                TreeNode node = treeNodeQueue.poll();

                if (1 == (level & 1)) {
                    temp.add(node.val);
                } else {
                    temp.add(0, node.val);
                }

                if (node.right != null) {
                    treeNodeQueue.offer(node.right);
                }
                if (node.left != null) {
                    treeNodeQueue.offer(node.left);
                }
            }
            level++;
            result.add(temp);
        }

        return result;
    }

    public static void main(String[] args) {

    }
}
