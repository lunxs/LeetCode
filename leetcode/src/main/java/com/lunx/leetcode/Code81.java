package com.lunx.leetcode;

/**
 * @author lunx
 * @version 1.0
 * @date 2020/09/17
 * @description
 */
public class Code81 {

    public boolean search(int[] nums, int target) {
        if (nums.length < 1) return false;

        return search(nums, target, 0, nums.length - 1);
    }

    private boolean search(int[] nums, int target, int left, int right) {
        if (nums[left] == target || nums[right] == target) return true;
        if (left == right) return false;

        if (nums[right] > nums[left]) {
            if (nums[left] < target && nums[right] > target) {
                int midIndex = (right + left) >> 1;
                boolean flag1 = search(nums, target, left, midIndex);
                boolean flag2 = search(nums, target, midIndex + 1, right);
                return flag1 | flag2;
            }
        } else {
            int midIndex = (right + left) >> 1;
            boolean flag1 = search(nums, target, left, midIndex);
            boolean flag2 = search(nums, target, midIndex + 1, right);
            return flag1 | flag2;
        }

        return false;
    }

    public static void main(String[] args) {
        Code81 code81 = new Code81();

        int[] nums = {2,5,6,0,0,1,2};
        int target = 3;

        boolean search = code81.search(nums, target);
        System.out.println(search);
    }
}
