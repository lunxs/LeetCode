package com.lunx.leetcode;

/**
 * @author lunx
 * @version 1.0
 * @date 2022/02/16
 * @description
 */
public class Code100 {

    public static class TreeNode {
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

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (null == p && null != q) return false;
        if (null != p && null == q) return false;

        if (p != null && q != null) {
            if (p.val != q.val) return false;
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }

        return true;
    }

    public static void main(String[] args) {

    }
}
