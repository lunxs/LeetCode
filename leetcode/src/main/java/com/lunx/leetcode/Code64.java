package com.lunx.leetcode;

/**
 * @author desong.xie
 * @version 1.0
 * @date 2020/07/21
 * @description
 */
public class Code64 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        if (m < 1) return 0;
        int n = obstacleGrid[0].length;
        if (n < 1) return 0;

        if (obstacleGrid[0][0] == 1) return 0;

        obstacleGrid[0][0] = 1;
        for (int i = 1; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                obstacleGrid[i][0] = 0;
            } else {
                obstacleGrid[i][0] = obstacleGrid[i - 1][0];
            }
        }

        for (int j = 1; j < n; j++) {
            if (obstacleGrid[0][j] == 1) {
                obstacleGrid[0][j] = 0;
            } else {
                obstacleGrid[0][j] = obstacleGrid[0][j - 1];
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    obstacleGrid[i][j] = 0;
                } else {
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
                }
            }
        }

        return obstacleGrid[m - 1][n - 1];
    }

    public static void main(String[] args) {
        Code64 code63 = new Code64();

        int[][] ints = {{0, 1, 0}, {0, 1, 0}, {0, 1, 0}};

        int i = code63.uniquePathsWithObstacles(ints);
        System.out.println(i);
    }
}
