package com.lunx.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author desong.xie
 * @version 1.0
 * @date 2020/05/18
 * @description
 */
public class Code54 {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        if (matrix.length == 0) {
            return result;
        }

        int ls = 0, rs = 0;
        int le = matrix.length - 1, re = matrix[0].length - 1;
        int l = 0, r = 0;
        while (true) {
            // down
            if (r > re) {
                break;
            }
            while (r <= re) {
                result.add(matrix[l][r]);
                r++;
            }
            ls++;
            r--;
            l++;
            // right
            if (l > le) {
                break;
            }
            while (l <= le) {
                result.add(matrix[l][r]);
                l++;
            }
            re--;
            l--;
            r--;
            // up
            if (r < rs) {
                break;
            }
            while (r >= rs) {
                result.add(matrix[l][r]);
                r--;
            }
            le--;
            r++;
            l--;
            // left
            if (l < ls) {
                break;
            }
            while (l >= ls) {
                result.add(matrix[l][r]);
                l--;
            }
            rs++;
            l++;
            r++;
        }

        return result;
    }


    public static void main(String[] args) {
        int[][] as = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};

        Code54 code54 = new Code54();
        List<Integer> integers = code54.spiralOrder(as);
        for (int a : integers) {
            System.out.print(a + " ");
        }
    }
}
