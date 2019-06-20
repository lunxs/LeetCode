package com.lunx.leetcode;

/**
 * @author XieDesong
 * @version 1.0
 * @title Code34
 * @description
 * @date 2019/06/20
 */
public class Code34 {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];

        int low = 0, high = nums.length - 1, mid;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (target <= nums[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        if (low < nums.length && nums[low] == target) {
            result[0] = low;
        } else {
            result[0] = -1;
            result[1] = -1;
            return result;
        }

        high = nums.length - 1;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (target >= nums[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        result[1] = high;
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {};

        Code34 code34 = new Code34();
        int[] ints = code34.searchRange(nums, 1);
        System.out.println(ints[0] + ":" + ints[1]);
    }
}
