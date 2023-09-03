package com.lunx.leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author lunx
 * @version 1.0
 * @date 2022/06/29
 * @description
 */
public class Code113 {

    Deque<Integer> deque = new LinkedList<>();
    List<List<Integer>> result = new ArrayList<>();

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

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        pathSum1(root, targetSum);
        return result;
    }

    public void pathSum1(TreeNode node, int targetSum) {
        if (null == node) {
            return;
        }

        deque.offerLast(node.val);
        if (null == node.left && null == node.right && targetSum == node.val) {
            result.add(new ArrayList<>(deque));
        }

        pathSum1(node.left, targetSum - node.val);
        pathSum1(node.right, targetSum - node.val);
        deque.pollLast();
    }


    public static void main(String[] args) {
//        root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
//        输出：[[5,4,11,2],[5,8,4,5]]

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        List<List<Integer>> result = new Code113().pathSum(root, 22);
        System.out.println(result);
    }

}
