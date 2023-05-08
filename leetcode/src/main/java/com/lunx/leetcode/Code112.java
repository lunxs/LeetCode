package com.lunx.leetcode;

/**
 * @author lunx
 * @version 1.0
 * @date 2022/06/29
 * @description
 */
public class Code112 {

    public static class TreeNode {
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

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (null == root) return false;

        if (null == root.left && null == root.right) {
            return targetSum == root.val;
        }

        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }


    public static void main(String[] args) {
    }

}
