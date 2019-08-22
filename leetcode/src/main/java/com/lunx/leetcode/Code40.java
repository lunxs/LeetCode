package com.lunx.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Code40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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

        if (num >= candidates.length || candidates[num] > target) return;

        for (int i = num; i < candidates.length; i++) {
            if (i > num && candidates[i] == candidates[i - 1]) continue;
            List<Integer> tem = new ArrayList<>(temp);

            tem.add(candidates[i]);

            calc(result, tem, candidates, i+1, target - candidates[i]);
        }

    }

    public static void main(String[] args) {
        Code40 c = new Code40();

        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        List<List<Integer>> lists = c.combinationSum2(candidates, target);
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
