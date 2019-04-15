package com.lunx.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author XieDesong
 * @version 1.0
 * @title Code15
 * @description
 * @date 2019/04/08
 */
public class Code15 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3) return result;
        Arrays.sort(nums);

        for (int i = 0; i + 1 < nums.length; i++) {

            int temp = nums[i];
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                if (temp + nums[l] + nums[r] == 0) {
                    List<Integer> tempList = new ArrayList<>();
                    tempList.add(temp);
                    tempList.add(nums[l]);
                    tempList.add(nums[r]);

                    result.add(tempList);

                    while (r - 1 > l && nums[r] == nums[r - 1])
                        r--;
                    while (l + 1 < r && nums[l] == nums[l + 1])
                        l++;

                    l++;
                    r--;
                } else if (temp + nums[l] + nums[r] > 0) {
                    while (r - 1 > l && nums[r] == nums[r - 1])
                        r--;
                    r--;
                } else {
                    while (l + 1 < r && nums[l] == nums[l + 1])
                        l++;
                    l++;
                }

            }

            while (i + 1 < nums.length && nums[i] == nums[i + 1])
                i++;
        }

        return result;
    }

    public static void main(String[] args) {
        Code15 code15 = new Code15();

        // {-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0}
        int[] nums = {-5,-5,-4,-4,-4,-2,-2,-2,0,0,0,1,1,3,4,4};
        System.out.println(nums);

        System.out.println(code15.threeSum(nums));
    }
}
