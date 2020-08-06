package com.lunx.leetcode;

/**
 * @author desong.xie
 * @version 1.0
 * @date 2020/07/24
 * @description
 */
public class Code69 {
    public int mySqrt(int x) {
        long left = 0L, right = (x >> 1) + 1L;
        while (left < right) {
            long mid = (left + right + 1) >> 1;
            long temp = mid * mid;
            if (temp > x) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }

        return (int) left;
    }

    public static void main(String[] args) {
        Code69 code69 = new Code69();

        for (int i = 0; i <= 16; i++) {

            int i1 = code69.mySqrt(i);
            System.out.println(i1);
        }
    }
}
