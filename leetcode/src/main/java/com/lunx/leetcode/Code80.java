package com.lunx.leetcode;

import com.google.gson.Gson;

/**
 * @author desong.xie
 * @version 1.0
 * @date 2020/08/21
 * @description
 */
public class Code80 {
    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        if (length < 1) return length;

        int r = 1;
        int count = 1;
        int currentN = nums[0];
        while (r < length) {
            if (nums[r] == currentN) {
                count++;
            } else {
                currentN = nums[r];
                count = 1;
            }
            if (count == 3) {
                break;
            }
            r++;
        }

        int l = r;
        while (r < length) {
            if (nums[r] == currentN) {
                count++;
            } else {
                currentN = nums[r];
                count = 1;
            }

            if (count > 2) {
                r++;
                continue;
            }
            nums[l] = nums[r];
            l++;
            r++;
        }

        return l;
    }

    public static void main(String[] args) {
        Code80 code80 = new Code80();

        int[] nums = {};

        int length = code80.removeDuplicates(nums);
        System.out.println(length);
        System.out.println(new Gson().toJson(nums));
    }
}
