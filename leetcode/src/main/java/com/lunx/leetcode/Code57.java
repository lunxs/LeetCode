package com.lunx.leetcode;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * @author desong.xie
 * @version 1.0
 * @date 2020/07/16
 * @description
 */
public class Code57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int length = intervals.length;

        int min = newInterval[0], max = newInterval[1];
        int i = 0;
        while (i < length) {
            if (intervals[i][1] < newInterval[0]) {
                result.add(intervals[i]);
            } else {
                min = Math.min(intervals[i][0], newInterval[0]);
                break;
            }
            i++;
        }

        while (i < length) {
            if (intervals[i][0] > newInterval[1]) {
                max = newInterval[1];
                break;
            }

            if (intervals[i][1] >= newInterval[1]) {
                max = Math.max(intervals[i][1], newInterval[1]);
                break;
            }

            i++;
        }

        int[] temp = {min, max};
        result.add(temp);

        while (i < length) {
            if (intervals[i][0] > newInterval[1]) {
                result.add(intervals[i]);
            }
            i++;
        }

        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = {{6, 9}, {13, 19}};
        int[] newInterval = {20, 21};

        int[][] insert = new Code57().insert(intervals, newInterval);
        System.out.println(new Gson().toJson(insert));
    }
}
