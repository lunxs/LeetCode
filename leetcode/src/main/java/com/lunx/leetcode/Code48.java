package com.lunx.leetcode;

/**
 * @author desong.xie
 * @version 1.0
 * @title Code48
 * @date 2020/03/31
 * @description
 */
public class Code48 {

    public void rotate(int[][] matrix) {
        int length = matrix.length;
        if (length == 1) return;

        int s = 0, e = length - 1;
        while (s < e) {
            rotate(matrix, s, e);
            s++;
            e--;
        }
    }

    private void rotate(int[][] matrix, int s, int e) {
        int temp;
        int temp1;
        for (int i = s; i < e; i++) {
            temp = matrix[s][i];
            matrix[s][i] = matrix[e - i + s][s];
            temp1 = matrix[i][e];
            matrix[i][e] = temp;
            temp = matrix[e][e - i + s];
            matrix[e][e - i + s] = temp1;
            matrix[e - i + s][s] = temp;
        }
    }

    public static void main(String[] args) {
        Code48 code48 = new Code48();

        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        print(matrix);

        System.out.println("*****************************");
        code48.rotate(matrix);
        print(matrix);
    }

    private static void print(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int k = 0; k < matrix[i].length; k++) {
                System.out.print(matrix[i][k] + ", ");
            }
            System.out.println();
        }
    }
}
