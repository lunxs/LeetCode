package com.lunx.leetcode;

/**
 * @author desong.xie
 * @version 1.0
 * @date 2020/07/21
 * @description
 */
public class Code64 {

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        if (m < 1) return 0;
        int n = grid[0].length;
        if (n < 1) return 0;

        for (int i = 1; i < m; i++) {
            grid[i][0] += grid[i - 1][0];
        }

        for (int j = 1; j < n; j++) {
            grid[0][j] += grid[0][j - 1];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }

        return grid[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] ints = {{1,3,1}, {1,5,1}, {4,2,1}};

        Code64 code64 = new Code64();
        int i = code64.minPathSum(ints);
        System.out.println(i);
    }
}
