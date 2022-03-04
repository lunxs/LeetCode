package com.lunx.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author lunx
 * @version 1.0
 * @date 2022/03/04
 * @description
 */
public class Code107 {

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

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();

        if (null == root) {
            return result;
        }

        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        treeNodeQueue.offer(root);
        while (!treeNodeQueue.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int size = treeNodeQueue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = treeNodeQueue.poll();
                temp.add(node.val);

                if (node.left != null) treeNodeQueue.offer(node.left);
                if (node.right != null) treeNodeQueue.offer(node.right);
            }

            result.add(0, temp);
        }

        return result;
    }

    public static void main(String[] args) {

    }

}
