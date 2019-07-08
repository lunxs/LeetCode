package com.lunx.leetcode;

/**
 * @author XieDesong
 * @version 1.0
 * @title Code35
 * @description
 * @date 2019/06/20
 */
public class Code35 {
    public int searchInsert(int[] nums, int target) {

        int l = 0, r = nums.length - 1, mid;
        while (l <= r) {
            mid = (l + r) >> 1;

            if (target == nums[mid]) {
                return mid;
            }

            if (target > nums[mid]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return l;
    }

    public static void main(String[] args) {
        Code35 code35 = new Code35();
        int[] nums = {1,3,5,6};
        int i = code35.searchInsert(nums, 8);
        System.out.println(i);
    }
}
