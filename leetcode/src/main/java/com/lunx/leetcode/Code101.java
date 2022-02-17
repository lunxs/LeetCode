package com.lunx.leetcode;

/**
 * @author lunx
 * @version 1.0
 * @date 2022/02/17
 * @description
 */
public class Code101 {

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

    public boolean isSymmetric(TreeNode root) {
        if (null == root) return true;

        return isSameTree(root.left, root.right);
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (null == p && null != q) return false;
        if (null != p && null == q) return false;

        if (p != null && q != null) {
            if (p.val != q.val) return false;
            return isSameTree(p.left, q.right) && isSameTree(p.right, q.left);
        }

        return true;
    }

    public static void main(String[] args) {

    }
}
