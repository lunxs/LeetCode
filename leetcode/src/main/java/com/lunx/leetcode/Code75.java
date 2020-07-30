package com.lunx.leetcode;

import com.google.gson.Gson;

/**
 * @author desong.xie
 * @version 1.0
 * @date 2020/07/30
 * @description
 */
public class Code75 {
    public void sortColors(int[] nums) {
        int l = 0, r = nums.length - 1;
        int idx = 0;
        while (idx <= r) {
            int num = nums[idx];
            if (num == 2) {
                nums[idx] = nums[r];
                nums[r] = num;
                r--;
                continue;
            }
            if (num == 0) {
                nums[idx] = nums[l];
                nums[l] = num;
                l++;
            }
            idx++;
        }
    }

    public static void main(String[] args) {
        Code75 code75 = new Code75();

        int[] nums = {1,0};
        code75.sortColors(nums);
        System.out.println(new Gson().toJson(nums));
    }
}
