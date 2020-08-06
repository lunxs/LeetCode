package com.lunx.leetcode;

import java.util.Arrays;

/**
 * @author desong.xie
 * @version 1.0
 * @date 2020/07/20
 * @description
 */
public class Code62 {
    public int uniquePaths(int m, int n) {
        int[] ints = new int[n];
        Arrays.fill(ints, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                ints[j] += ints[j - 1];
            }
        }

        return ints[n - 1];
    }

    public static void main(String[] args) {
        Code62 code62 = new Code62();
        int i = code62.uniquePaths(3, 3);
        System.out.println(i);
    }
}
