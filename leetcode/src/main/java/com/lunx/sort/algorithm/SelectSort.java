package com.lunx.sort.algorithm;

import com.google.gson.Gson;

/**
 * @author lunx
 * @version 1.0
 * @date 2020/08/31
 * @description
 */
public class SelectSort {

    public static void selectSort(int[] arr) {
        if (null == arr || arr.length < 1) return;

        int length = arr.length;
        int minIndex, temp;
        for (int i = 0; i < length - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] ints = {7,8,9,5,3,7,2,6,0,1,2,5,1};

        selectSort(ints);

        System.out.println(new Gson().toJson(ints));
    }
}
