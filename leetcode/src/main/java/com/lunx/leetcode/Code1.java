package com.lunx.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author XieDesong
 * @version 1.0
 * @title Code1
 * @description
 * @date 2019/02/21
 */
public class Code1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int b = target - nums[i];
            if (map.containsKey(b)) {
                return new int[]{i, map.get(b)};
            }

            map.put(nums[i], i);
        }

        throw new IllegalArgumentException("input error!");
    }

    public static void main(String[] args) {

    }
}
