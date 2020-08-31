package com.lunx.sort.algorithm;

import com.google.gson.Gson;

/**
 * @author lunx
 * @version 1.0
 * @date 2020/08/31
 * @description 插入排序
 */
public class InsertionSort {

    public static void insertionSort(int[] arr) {
        if (null == arr || arr.length < 1) return;

        int temp, preIndex;
        int length = arr.length;
        for (int i = 1; i < length; i++) {
            temp = arr[i];
            preIndex = i;
            while (preIndex > 0 && arr[preIndex - 1] > temp) {
                arr[preIndex] = arr[preIndex - 1];
                preIndex--;
            }

            arr[preIndex] = temp;
        }
    }

    public static void main(String[] args) {
        int[] ints = {7,8,9,5,3,7,2,6,0,1,2,5,1};

        insertionSort(ints);

        System.out.println(new Gson().toJson(ints));
    }
}
