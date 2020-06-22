package com.lunx.leetcode;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author desong.xie
 * @version 1.0
 * @date 2020/06/18
 * @description
 */
public class Code56 {

    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }
        List<int[]> collect = Arrays.asList(intervals).stream().sorted(Comparator.comparingInt(a -> a[0])).collect(Collectors.toList());

        List<int[]> result = new ArrayList<>();

        int[] ints = collect.get(0);
        int min = ints[0], max = ints[1];
        int size = collect.size();
        for (int i = 1; i < size; i++) {
            int[] l = collect.get(i);

            if (l[0] <= max) {
                max = Math.max(max, l[1]);
                continue;
            }

            int[] temp = {min, max};
            result.add(temp);
            min = l[0];
            max = l[1];
        }

        int[] temp = {min, max};
        result.add(temp);

        return result.toArray(new int[result.size()][]);
    }


    public static void main(String[] args) {
        int[][] aa = {{1,3},{15,18},{8,10},{2,6}};

        Code56 code56 = new Code56();
        int[][] merge = code56.merge(aa);
        System.out.println(new Gson().toJson(merge));


    }

}
