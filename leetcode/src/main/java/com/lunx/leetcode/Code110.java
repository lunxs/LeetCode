package com.lunx.leetcode;

import javax.xml.crypto.KeySelector;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lunx
 * @version 1.0
 * @date 2022/06/29
 * @description
 */
public class Code110 {

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

    public boolean isBalanced(TreeNode root) {
        return height(root) >= 0;
    }

    private int height(TreeNode node) {
        if (null == node) return 0;

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    public static void main(String[] args) {
        // [3,9,20,null,null,15,7]
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        Code110 code110 = new Code110();
        boolean balanced = code110.isBalanced(root);
        System.out.println(balanced);
    }

    public static void test() {
        // [1,2,3,4,5,6,null,8]

        TreeNode left1 = new TreeNode(2);
        TreeNode right1 = new TreeNode(3);
        TreeNode root = new TreeNode(1, left1, right1);

    }
}
