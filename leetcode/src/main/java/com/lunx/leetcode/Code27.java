package com.lunx.leetcode;

/**
 * @author XieDesong
 * @version 1.0
 * @title Code27
 * @description
 * @date 2019/05/10
 */
public class Code27 {
    public int removeElement(int[] nums, int val) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[index++] = nums[i];
            }
        }

        return index;
    }

    public static void main(String[] args) {
        Code27 code27 = new Code27();

        int[] nums = {3};
        int length = code27.removeElement(nums, 3);
        for (int i = 0; i < length; i++) {
            System.out.println(nums[i]);
        }
    }
}
