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

    public List<List<Integer>> combine1(int n, int k) {
        // init first combination
        LinkedList<Integer> nums = new LinkedList<Integer>();
        for(int i = 1; i < k + 1; ++i)
            nums.add(i);
        nums.add(n + 1);

        List<List<Integer>> output = new ArrayList<List<Integer>>();
        int j = 0;
        while (j < k) {
            // add current combination
            output.add(new LinkedList(nums.subList(0, k)));
            // increase first nums[j] by one
            // if nums[j] + 1 != nums[j + 1]
            j = 0;
            while ((j < k) && (nums.get(j + 1) == nums.get(j) + 1))
                nums.set(j, j++ + 1);
            nums.set(j, nums.get(j) + 1);
        }
        return output;
    }

    public static void main(String[] args) {
        Code77 code77 = new Code77();

        int n = 5, k = 2;
        List<List<Integer>> combine = code77.combine(n, k);
        System.out.println(new Gson().toJson(combine));

        List<List<Integer>> lists = code77.combine1(n, k);
        System.out.println(new Gson().toJson(lists));
    }
}
