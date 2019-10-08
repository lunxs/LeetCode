package com.lunx.leetcode;

import java.util.Arrays;

/**
 * @author desong.xie
 * @version 1.0
 * @title Code41
 * @date 2019/09/27
 * @description
 */
public class Code41 {

    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);

        int start = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0) {
                continue;
            }

            if (nums[i] > start) {
                return start;
            }

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            start++;
        }

        return start;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2,2,2};
        Code41 code41 = new Code41();
        int i = code41.firstMissingPositive(nums);
        System.out.println(i);
    }
}
