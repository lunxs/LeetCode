package com.lunx.sort.algorithm;

import com.google.gson.Gson;

/**
 * @author lunx
 * @version 1.0
 * @date 2020/09/01
 * @description 归并排序
 */
public class MergeSort {

    public static void mergeSort(int[] arr) {
        if (null == arr || arr.length < 1) return;

        sort(arr, 0, arr.length - 1);
    }

    /**
     * 归并排序 主方法 - 递归实现
     * @param arr 主数组
     * @param start 排序起始索引
     * @param end 排序终止索引
     */
    public static void sort(int[] arr, int start, int end) {
        if (start == end) return;

        int mid = (start + end) / 2;
        // 左区间递归
        sort(arr, start, mid);
        // 右区间递归
        sort(arr, mid + 1, end);
        // 合并
        merge(arr, start, end, mid);
    }

    /**
     * 数组合并
     * @param arr
     * @param left 左索引
     * @param right 右索引
     * @param min 中间索引
     */
    public static void merge(int[] arr, int left, int right, int min) {
        // [left, min],[min+1, right]
        int[] temp = new int[right - left + 1];

        // 定义数组遍历的左起始位置，和右起始位置
        int ls = left, rs = min + 1;
        int tempIndex = 0;
        while (ls <= min && rs <= right) {
            if (arr[ls] < arr[rs]) {
                temp[tempIndex] = arr[ls];
                ls++;
            } else {
                temp[tempIndex] = arr[rs];
                rs++;
            }
            tempIndex++;
        }

        while (ls <= min) {
            temp[tempIndex] = arr[ls];
            ls++;
            tempIndex++;
        }

        while (rs <= right) {
            temp[tempIndex] = arr[rs];
            rs++;
            tempIndex++;
        }

        // 将排序好的临时数组，写会原需排序数组
        for (int i = 0; i < temp.length; i++) {
            arr[left + i] = temp[i];
        }
    }

    /**
     * 两已经排序数组合并为一个排序数组
     * @param left
     * @param right
     * @return
     */
    public static int[] merge(int[] left, int[] right) {
        int leftLength = left.length, rightLength = right.length;
        int[] temp = new int[leftLength + rightLength];

        int l = 0, r = 0;
        while (l < leftLength && r < rightLength) {
            if (left[l] < right[r]) {
                temp[l + r] = left[l];
                l++;
            } else {
                temp[l + r] = right[r];
                r++;
            }
        }

        while (l < leftLength) {
            temp[l + r] = left[l];
            l++;
        }

        while (r < rightLength) {
            temp[l + r] = right[r];
            r++;
        }

        return temp;
    }

    public static void main(String[] args) {
        int[] ints = {1,5,6,9, 2,3,4,5,6,7,8,9,10,11,12};

        mergeSort(ints);

        System.out.println(new Gson().toJson(ints));

    }
}
