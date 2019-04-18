package com.lunx.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author XieDesong
 * @version 1.0
 * @title Code18
 * @description
 * @date 2019/04/16
 */
public class Code18 {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums.length < 4) return Collections.emptyList();
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 1; i + 1 < nums.length; i++) {

            int p = nums[i - 1];
            int p1 = nums[i];
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                if (p + p1 + nums[l] + nums[r] == target) {

                    result.add(Arrays.asList(p, p1, nums[l], nums[r]));

                    while (r - 1 > l && nums[r] == nums[r - 1])
                        r--;
                    while (l + 1 < r && nums[l] == nums[l + 1])
                        l++;

                    l++;
                    r--;
                } else if (p + p1 + nums[l] + nums[r] > target) {
                    while (r - 1 > l && nums[r] == nums[r - 1])
                        r--;
                    r--;
                } else {
                    while (l + 1 < r && nums[l] == nums[l + 1])
                        l++;
                    l++;
                }

            }

            if (p == p1) {
                while (i + 1 < nums.length && nums[i] == nums[i + 1])
                    i++;
            }
        }

        return result;
    }

    public List<List<Integer>> fourSum1(int[] nums, int target) {
        if (nums.length < 4) return Collections.emptyList();
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; i++) {
            int pNum = nums[i];
            int p1 = i + 1;
            while (p1 < nums.length - 2) {
                int l = p1 + 1, r = nums.length - 1;

                while (l < r) {
                    if (pNum + nums[p1] + nums[l] + nums[r] == target) {

                        result.add(Arrays.asList(pNum, nums[p1], nums[l], nums[r]));

                        while (r - 1 > l && nums[r] == nums[r - 1])
                            r--;
                        while (l + 1 < r && nums[l] == nums[l + 1])
                            l++;

                        l++;
                        r--;
                    } else if (pNum + nums[p1] + nums[l] + nums[r] > target) {
                        while (r - 1 > l && nums[r] == nums[r - 1])
                            r--;
                        r--;
                    } else {
                        while (l + 1 < r && nums[l] == nums[l + 1])
                            l++;
                        l++;
                    }

                }

                while (p1 < nums.length - 2 && nums[p1] == nums[p1 + 1])
                    p1++;
                p1++;
            }

            while (i < nums.length - 3 && nums[i] == nums[i + 1])
                i++;
        }

        return result;
    }

    public static void main(String[] args) {
        Code18 code18 = new Code18();

        int[] nums = {1, 0, -1, 0, -2, 2};
        List<List<Integer>> lists = code18.fourSum1(nums, 0);
        System.out.println(lists);
    }
}
