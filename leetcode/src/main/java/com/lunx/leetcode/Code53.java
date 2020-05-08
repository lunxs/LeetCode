package com.lunx.leetcode;

/**
 * @author desong.xie
 * @version 1.0
 * @date 2020/05/08
 * @description
 * @ 汇付天下
 */
public class Code53 {
    public int maxSubArray(int[] nums) {

        int pre = 0, result = nums[0];
        for (int n : nums) {
            pre = Math.max(pre + n, n);
            result = Math.max(pre, result);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        Code53 code53 = new Code53();
        int i = code53.maxSubArray(nums);
        System.out.println(i);
    }
}
