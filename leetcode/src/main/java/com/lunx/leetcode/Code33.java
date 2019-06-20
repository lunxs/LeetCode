package com.lunx.leetcode;

/**
 * @author XieDesong
 * @version 1.0
 * @title Code33
 * @description
 * @date 2019/06/20
 */
public class Code33 {
    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        boolean flag;
        int cur = nums[0];
        if (target == cur) {
            return 0;
        } else if (target > cur) {
            flag = true;
        } else {
            flag = false;
        }

        int l = 0, r = nums.length - 1, mid = 0;
        while (l <= r) {
            mid = (l + r) >> 1;
            if (nums[mid] == target) {
                return mid;
            }

            if (flag) {
                if (nums[mid] > target) {
                    r = mid - 1;
                } else {
                    if (nums[mid] >= cur) {
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
            } else {
                if (nums[mid] >= cur) {
                    l = mid + 1;
                } else {
                    if (nums[mid] > target) {
                        r = mid - 1;
                    } else {
                        l = mid + 1;
                    }
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {3,1};

        Code33 code33 = new Code33();
        int search = code33.search(nums, 1);
        System.out.println(search);
    }
}
