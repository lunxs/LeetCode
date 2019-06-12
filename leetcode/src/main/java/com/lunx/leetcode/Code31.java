package com.lunx.leetcode;

import java.util.Arrays;

/**
 * @author XieDesong
 * @version 1.0
 * @title Code31
 * @description
 * @date 2019/06/03
 */
public class Code31 {

    public void nextPermutation(int[] nums) {
        int length = nums.length;
        if (length <= 1) return;


        for (int index1 = length - 2; index1 >= 0; index1--) {
            if (nums[index1] >= nums[index1 + 1]) {
                continue;
            }

            for (int index2 = index1 + 1; index2 < length; index2++) {
                if (nums[index1] < nums[index2] && index2< length - 1) {
                    continue;
                }

                if (nums[index1] >= nums[index2]) {
                    swap(nums, index1, index2 - 1);
                    sort(nums, index2 - 1, length - 1);
                } else {
                    swap(nums, index1, index2);
                    sort(nums, index2, length - 1);
                }

                return;
            }
        }

        // sort
        sort(nums, 0, length - 1);
    }

    private void sort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int times = (start + end) >> 1;
        for (int i = start; i <= times; i++) {
            swap(nums, i, start + end - i);
        }
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    public static void main(String[] args) {
        Code31 code31 = new Code31();

        int[] nums = {1,3,2};
        code31.nextPermutation(nums);

        for (int i : nums) {
            System.out.println(i);
        }
    }
}
