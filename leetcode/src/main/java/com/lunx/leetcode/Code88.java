package com.lunx.leetcode;

import com.google.gson.Gson;

/**
 * @author lunx
 * @version 1.0
 * @date 2021/01/20
 * @description
 */
public class Code88 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1, p2 = n - 1;
        int i = m + n;
        while (--i >= 0) {
            if (p1 < 0 || p2 < 0) {
                break;
            }

            if (nums1[p1] < nums2[p2]) {
                nums1[i] = nums2[p2];
                p2--;
            } else {
                nums1[i] = nums1[p1];
                p1--;
            }
        }

        if (++i > 0 && p2 >= 0) {
            while (--i >= 0) {
                nums1[i] = nums2[p2];
                p2--;
            }
        }
    }

    public static void main(String[] args) {
        int[] num1 = {1,2,3,0,0,0};
        int m = 3;

        int[] num2 = {2,5,6};
        int n = 3;

        Code88 code88 = new Code88();
        code88.merge(num1, m, num2, n);

        System.out.println(new Gson().toJson(num1));
    }
}
