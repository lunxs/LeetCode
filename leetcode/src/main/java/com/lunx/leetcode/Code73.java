package com.lunx.leetcode;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author desong.xie
 * @version 1.0
 * @date 2020/07/28
 * @description
 */
public class Code73 {
    /**
     * map方式时间3ms，空间41.4MB
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {
        // row
        int r = matrix.length;
        if (r == 0) return;
        // list
        int l = matrix[0].length;

        Map<Integer, Integer> rMap = new HashMap<>();
        Map<Integer, Integer> lMap = new HashMap<>();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < l; j++) {
                if (matrix[i][j] == 0) {
                    rMap.put(i, 0);
                    lMap.put(j, 0);
                }
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < l; j++) {
                if (null != rMap.get(i) || null != lMap.get(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    /**
     * set方式时间 5ms，空间41MB
     * @param matrix
     */
    public void setZeroes1(int[][] matrix) {
        // row
        int r = matrix.length;
        if (r == 0) return;
        // list
        int l = matrix[0].length;

        Set<Integer> rSet = new HashSet<>();
        Set<Integer> lSet = new HashSet<>();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < l; j++) {
                if (matrix[i][j] == 0) {
                    rSet.add(i);
                    lSet.add(j);
                }
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < l; j++) {
                if (rSet.contains(i) || lSet.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Code73 code73 = new Code73();

        int[][] ints = {};
        code73.setZeroes(ints);

        for (int[] is : ints) {
            System.out.println(new Gson().toJson(is));
        }
    }
}
