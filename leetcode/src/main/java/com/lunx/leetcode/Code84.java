package com.lunx.leetcode;

/**
 * @author lunx
 * @version 1.0
 * @date 2020/09/24
 * @description
 */
public class Code84 {

    public int largestRectangleArea(int[] heights) {
        int length = heights.length;
        int maxArea = 0;
        for (int i = 0; i < length; i++) {
            int height = heights[i];
            for (int j = i; j < length; j++) {
                height = Math.min(height, heights[j]);
                // 判断 height * (length - i) < maxArea
                // 注意 height * (length - i) 超出int最大值
                if (height < maxArea / (length - i)) break;

                maxArea = Math.max(maxArea, height * (j - i + 1));
            }
        }

        return maxArea;
    }


    public static void main(String[] args) {
        Code84 code84 = new Code84();

        int[] heights = {2147483647,0,2147483647,0,2147483647,0,2147483647,0,2147483647,0};
        int area = code84.largestRectangleArea(heights);
        System.out.println(area);
    }
}
