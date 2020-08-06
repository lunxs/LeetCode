package com.lunx.leetcode;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author desong.xie
 * @version 1.0
 * @date 2020/07/17
 * @description
 */
public class Code46 {
    public List<List<Integer>> permute(int[] nums) {

        List<Integer> ints = new ArrayList<>();
        for (int i : nums) {
            ints.add(i);
        }

        int n = nums.length;

        List<List<Integer>> swap = swap(ints, --n);
        List<List<Integer>> permute = permute(swap, --n);

        return permute;
    }

    public List<List<Integer>> permute(List<List<Integer>> nList, int n) {
        if (n <= 0) {
            return nList;
        }

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nList.size(); i++) {
            List<Integer> integers = nList.get(i);
            List<List<Integer>> swapList = swap(integers, n);
            result.addAll(swapList);
        }

        return permute(result, --n);
    }

    public List<List<Integer>> swap(List<Integer> nList, int index) {
        List<List<Integer>> result = new ArrayList<>();

        int length = nList.size();
        Integer[] is = new Integer[length];
        nList.toArray(is);

        result.add(nList);

        int temp = is[index];
        for (int i = 0; i < index; i++) {
            Integer[] clone = is.clone();
            clone[index] = clone[i];
            clone[i] = temp;

            result.add(Arrays.asList(clone));
        }

        return result;
    }

    public static void main(String[] args) {
        Code46 code46 = new Code46();

        int[] nums = {1,2,3,4};

        List<List<Integer>> swap = code46.permute(nums);
        System.out.println(swap.size());
        System.out.println(new Gson().toJson(swap));
    }
}
