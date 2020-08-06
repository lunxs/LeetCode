package com.lunx.leetcode;

import com.google.gson.Gson;

/**
 * @author desong.xie
 * @version 1.0
 * @date 2020/07/16
 * @description
 */
public class Code59 {

    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        if (n == 0) return result;
        if ((Integer.MAX_VALUE / n) < n) throw new IllegalArgumentException();

        int r = 0, l = 0;
        int ls = 0, rs = 0;
        int le = n - 1, re = n - 1;
        int temp = 1;
        // 顺时针旋转
        while (true) {
            // right
            if (r > re) {
                break;
            }
            while (r <= re) {
                result[l][r++] = temp++;
            }
            ls++;
            r--;
            l++;
            // down
            if (l > le) {
                break;
            }
            while (l <= le) {
                result[l++][r] = temp++;
            }
            re--;
            l--;
            r--;
            // left
            if (r < rs) {
                break;
            }
            while (r >= rs) {
                result[l][r--] = temp++;
            }
            le--;
            r++;
            l--;
            // up
            if (l < ls) {
                break;
            }
            while (l >= ls) {
                result[l--][r] = temp++;
            }
            rs++;
            l++;
            r++;
        }

        return result;
    }

    public int[][] generateMatrix1(int n) {
        int[][] mat = new int[n][n];
        if (n == 0) return mat;
        if ((Integer.MAX_VALUE / n) < n) throw new IllegalArgumentException();

        int l = 0, r = n - 1, t = 0, b = n - 1;
        int num = 1, tar = n * n;
        while(num <= tar){
            // right
            for(int i = l; i <= r; i++) mat[t][i] = num++;
            t++;
            // down
            for(int i = t; i <= b; i++) mat[i][r] = num++;
            r--;
            // left
            for(int i = r; i >= l; i--) mat[b][i] = num++;
            b--;
            // up
            for(int i = b; i >= t; i--) mat[i][l] = num++;
            l++;
        }
        return mat;
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] ints = new Code59().generateMatrix1(n);
        System.out.println(new Gson().toJson(ints));
    }
}
