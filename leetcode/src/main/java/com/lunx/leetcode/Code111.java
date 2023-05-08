package com.lunx.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lunx
 * @version 1.0
 * @date 2022/06/29
 * @description
 */
public class Code111 {

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

    public int minDepth(TreeNode root) {
        if (null == root)
            return 0;

        List<TreeNode> treeNodes = new ArrayList<>();
        treeNodes.add(root);

        int minDepth = 1;
        do {
            List<TreeNode> tempTreeNodes = new ArrayList<>();
            for (TreeNode node : treeNodes) {
                if (null == node.left && null == node.right) return minDepth;

                if (null != node.left) tempTreeNodes.add(node.left);
                if (null != node.right) tempTreeNodes.add(node.right);
            }

            minDepth++;
            treeNodes = tempTreeNodes;
        } while (treeNodes.size() > 0);

        return minDepth;
    }



    public static void main(String[] args) {
    }

}
