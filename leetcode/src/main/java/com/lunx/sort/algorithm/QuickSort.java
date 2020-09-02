package com.lunx.sort.algorithm;

import com.google.gson.Gson;

/**
 * @author lunx
 * @version 1.0
 * @date 2020/09/01
 * @description 快速排序
 */
public class QuickSort {

    public static void quickSort(int[] arr) {
        if (null == arr || arr.length < 1) return;

        quickSort(arr, 0, arr.length - 1);
    }

    /**
     * 快速排序 主方法 - 递归实现
     * @param arr 主数组
     * @param left 排序起始索引
     * @param right 排序终止索引
     */
    public static void quickSort(int[] arr, int left, int right) {
        if (left >= right) return;

        int pivotIndex = partition(arr, left, right);
        quickSort(arr, left, pivotIndex - 1);
        quickSort(arr, pivotIndex + 1, right);
    }

    /**
     * 选取一个基准点，使小于该值置于左边，大于该值置于右边
     * @param arr 排序数组
     * @param left 左索引
     * @param right 右索引
     * @return 返回调整后该基准点位置
     */
    public static int partition(int[] arr, int left, int right) {
        // 选取第一个数为基准点
        int pivot = arr[left];

        while (left < right) {
            while (left < right && arr[right] >= pivot) {
                right--;
            }
            arr[left] = arr[right];

            while (left < right && arr[left] <= pivot) {
                left++;
            }
            arr[right] = arr[left];
        }

        arr[left] = pivot;

        return left;
    }

    public static void main(String[] args) {
        int[] ints = {5,6,2,4,8,3};

        quickSort(ints, 0, ints.length - 1);

        System.out.println(new Gson().toJson(ints));
    }
}
