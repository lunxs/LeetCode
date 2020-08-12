package com.lunx.leetcode;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author desong.xie
 * @version 1.0
 * @date 2020/08/11
 * @description
 */
public class Code78 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> output = new ArrayList();
        int length = nums.length;
        int ntBit = 1 << length;

        int max = (int) Math.pow(2, length);
        for (int i = 0; i < max; i++) {
            String bitmask = Integer.toBinaryString(ntBit | i).substring(1);

            List<Integer> curr = new ArrayList();
            for (int j = 0; j < length; j++) {
                if (bitmask.charAt(j) == '1') curr.add(nums[j]);
            }
            output.add(curr);
        }

        return output;
    }


    public static void main(String[] args) {
        Code78 code78 = new Code78();
        int[] nums = {1, 2, 3, 4 ,5};

        List<List<Integer>> subsets = code78.subsets(nums);
        System.out.println(subsets.size());
        System.out.println(new Gson().toJson(subsets));
    }

    private static void test1(int times) {
        int[] nums = {1,2,3,4,5,6,7,8,9};
        long startTime = System.currentTimeMillis();

        while (times-- > 0) {
            int[] tempNums = new int[5];
            System.arraycopy(nums, 0, tempNums, 0, 5);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("arraycopy time:" + (endTime - startTime));
    }

    private static void test2(int times) {
        List<Integer> integerList = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            integerList.add(i);
        }

        long startTime1 = System.currentTimeMillis();

        while (times-- > 0) {
            List<Integer> integerList1 = integerList.subList(0, 5);
        }
        long endTime1 = System.currentTimeMillis();
        System.out.println("subList time:" + (endTime1 - startTime1));
    }

}
