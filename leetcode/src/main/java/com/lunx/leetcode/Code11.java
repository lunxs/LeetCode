package com.lunx.leetcode;

/**
 * @author XieDesong
 * @version 1.0
 * @title Code11
 * @description
 * @date 2019/03/15
 * Coffee Box 连咖啡
 */
public class Code11 {

    public int maxArea(int[] height) {
        if (height.length < 2) return 0;

        int max = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int temp = (j - i) * Math.min(height[i], height[j]);
                max = temp > max ? temp : max;
            }
        }

        return max;
    }

    private int first(int[] height) {
        if (height.length < 2) return 0;

        int max = 0;
        int l = 0, r = height.length - 1;
        while (l < r) {
            int temp = (r - l) * Math.min(height[l], height[r]);
            max = temp > max ? temp : max;

            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[] as = {1,8,6,2,5,4,8,3,7};
        Code11 code11 = new Code11();
        System.out.println(code11.first(as));
    }
}
