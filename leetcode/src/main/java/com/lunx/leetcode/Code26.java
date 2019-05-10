package com.lunx.leetcode;

/**
 * @author XieDesong
 * @version 1.0
 * @title Code26
 * @description
 * @date 2019/05/10
 */
public class Code26 {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 1) return nums.length;

        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[index] < nums[i]) {
                nums[++index] = nums[i];
            }
        }

        return index + 1;
    }

    public static void main(String[] args) {
        Code26 code26 = new Code26();

        int[] nums = {0,0,0};

        int length = code26.removeDuplicates(nums);

        for (int i = 0; i < length; i++) {
            System.out.println(nums[i]);
        }
    }
}
