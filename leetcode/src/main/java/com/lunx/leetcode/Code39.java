package com.lunx.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Code39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        calc(result, temp, candidates, 0, target);
        return result;
    }

    private void calc(List<List<Integer>> result, List<Integer> temp, int[] candidates, int num, int target) {
        if (target == 0) {
            result.add(temp);
            return;
        }

        if (candidates[num] > target) return;

        for (int i = num; i < candidates.length; i++) {
            List<Integer> tem = new ArrayList<>(temp);
            tem.add(candidates[i]);

            calc(result, tem, candidates, i, target - candidates[i]);
        }

    }

    public static void main(String[] args) {
        Code39 c = new Code39();

        int[] candidates = {2,3,5};
        int target = 8;
        List<List<Integer>> lists = c.combinationSum(candidates, target);
        print(lists);
    }

    private static void print(List<List<Integer>> lists) {
        for (List<Integer> is : lists) {
            for (Integer i : is) {
                System.out.print(i);
            }
            System.out.println("");
        }
    }
}
