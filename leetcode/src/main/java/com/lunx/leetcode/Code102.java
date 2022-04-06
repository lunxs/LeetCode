package com.lunx.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lunx
 * @version 1.0
 * @date 2022/02/17
 * @description
 */
public class Code102 {

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

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (null == root) return result;

        List<TreeNode> treeNodes = new ArrayList<>();
        treeNodes.add(root);

        while (treeNodes.size() >0) {
            List<TreeNode> tempTreeNodes = new ArrayList<>();
            List<Integer> temp = new ArrayList<>();

            for (TreeNode n : treeNodes) {
                temp.add(n.val);

                if (n.left != null) tempTreeNodes.add(n.left);
                if (n.right != null) tempTreeNodes.add(n.right);
            }

            result.add(temp);
            treeNodes = tempTreeNodes;
        }

        return result;
    }

    public static void main(String[] args) {

    }
}
