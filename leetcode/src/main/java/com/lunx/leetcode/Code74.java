package com.lunx.leetcode;

/**
 * @author desong.xie
 * @version 1.0
 * @date 2020/07/28
 * @description
 */
public class Code74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rLength = matrix.length;
        if (rLength == 0) return false;
        int cLength = matrix[0].length;
        if (cLength == 0) return false;

        int rl = 0, rr = rLength;
        while (rl < rr) {
            int min = (rl + rr) >> 1;
            if (matrix[min][0] == target) {
                return true;
            } else if (matrix[min][0] < target) {
                rl = min + 1;
            } else {
                rr = min;
            }
        }

        if (--rl < 0) return false;

        int cl = 0, cr = cLength - 1;
        while (cl <= cr) {
            int min = (cl + cr) >> 1;
            if (matrix[rl][min] == target) {
                return true;
            } else if (matrix[rl][min] < target) {
                cl = min + 1;
            } else {
                cr = min - 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Code74 code74 = new Code74();

        int[][] ints = {{1,3,5,7},{10,11,16,20},{23,30,34,50}};
        int target = 3;
        boolean b = code74.searchMatrix(ints, target);
        System.out.println(b);

    }
}
