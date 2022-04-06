package com.lunx.leetcode;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lunx
 * @version 1.0
 * @date 2022/02/16
 * @description
 */
public class Code94 {

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

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        middle(root, result);
        return result;
    }

    public void middle(TreeNode node, List<Integer> result) {
        if (null == node) return;

        middle(node.left, result);
        result.add(node.val);
        middle(node.right, result);
    }

    public static void main(String[] args) {
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(2, treeNode3, null);
        TreeNode treeNode1 = new TreeNode(1, null, treeNode2);

        Code94 code94 = new Code94();
        List<Integer> integers = code94.inorderTraversal(treeNode1);
        System.out.println(JSONObject.toJSONString(integers));
    }
}
