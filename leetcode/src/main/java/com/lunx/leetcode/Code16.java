package com.lunx.leetcode;


import java.util.Arrays;

public class Code16 {

    public int threeSumClosest(int[] nums, int target) {
        if (nums.length < 3)
            throw new IllegalArgumentException("input nums error");

        Arrays.sort(nums);

        int result = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length; i++) {
            int l = i + 1, r = nums.length - 1;

            while (l < r) {
                int temp = nums[i] + nums[l] + nums[r];

                result = Math.abs(result - target) > Math.abs(temp - target) ? temp : result;

                if (temp == target) {
                    return temp;
                } else if (temp > target) {
                    r--;
                } else {
                    l++;
                }
            }

            while (i + 1 < nums.length && nums[i] == nums[i + 1])
                i++;
        }

        return result;
    }

    public static void main(String[] args) {
        Code16 code16 = new Code16();

        int[] nums = {-1,2,1,-4};

        System.out.println(code16.threeSumClosest(nums, 1));
    }
}
