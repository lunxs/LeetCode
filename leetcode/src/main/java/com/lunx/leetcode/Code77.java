package com.lunx.leetcode;

import com.google.gson.Gson;

import java.util.*;

/**
 * @author desong.xie
 * @version 1.0
 * @date 2020/07/31
 * @description
 */
public class Code77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (n < k) return result;

        while (n >= k) {
            List<Integer> temp = new ArrayList<>();
            temp.add(n);
            result.add(temp);
            n--;
        }

        for (int i = 1; i < k; i++) {
            combine(result, (k - i), i);
        }

        return result;
    }

    private void combine(List<List<Integer>> result, int k, int idx) {
        List<List<Integer>> rTemp = new ArrayList<>();
        for (List<Integer> list : result) {
            int n = list.get(idx - 1);
            while (--n >= k) {
                List<Integer> temp = new ArrayList<>();
                temp.addAll(list);
                temp.add(n);
                rTemp.add(temp);
            }
        }

        result.clear();
        result.addAll(rTemp);
    }

    public static void main(String[] args) {
        Code77 code77 = new Code77();

        int n = 3, k = 2;
        List<List<Integer>> combine = code77.combine(n, k);
        System.out.println(new Gson().toJson(combine));
    }
}
