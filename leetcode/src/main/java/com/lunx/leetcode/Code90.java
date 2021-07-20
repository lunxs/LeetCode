package com.lunx.leetcode;

import com.google.gson.Gson;

import java.util.*;

/**
 * @author lunx
 * @version 1.0
 * @date 2021/06/21
 * @description
 */
public class Code90 {

    public static void main(String[] args) {
        Code90 code90 = new Code90();

        int[] nums = new int[]{1};
        List<List<Integer>> lists = code90.subsetsWithDup(nums);
        System.out.println(new Gson().toJson(lists));
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());

        for (int i = 1; i <= nums.length; i++) {
            Choose choose = new Choose(nums, i);
            Set<List<Integer>> res = choose.getResult();
            result.addAll(res);
        }

        return result;
    }

    public static class Choose {
        private int N;
        private int M;
        private int[] a;
        private int[] b;
        private Set<List<Integer>> result = new HashSet<>();

        public Choose(int[] nums, int m) {
            this.a = nums;
            Arrays.sort(this.a);
            this.M = m;
            this.b = new int[M];
            this.N = nums.length;
        }

        public Set<List<Integer>> getResult() {
            if (this.a.length == 0 || this.M == 0) {
                return result;
            }
            this.c(N, M);
            return result;
        }

        private void c(int m, int n) {
            int i, j;
            for (i = n; i <= m; i++) {
                b[n - 1] = i - 1;
                if (n > 1) {
                    c(i - 1, n - 1);
                } else {
                    List<Integer> temp = new ArrayList<>();
                    for (j = 0; j <= M - 1; j++) {
                        temp.add(a[b[j]]);
                    }
                    result.add(temp);
                }
            }
        }
    }
}
