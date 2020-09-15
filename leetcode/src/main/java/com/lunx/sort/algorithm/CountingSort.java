package com.lunx.sort.algorithm;

import com.google.gson.Gson;

/**
 * @author lunx
 * @version 1.0
 * @date 2020/09/15
 * @description
 */
public class CountingSort {

    public static void countingSort(int[] arr, int max) {
        if (null == arr || arr.length < 1) return;

        int[] resultTemp = new int[max + 1];
        for (int value : arr) {
            resultTemp[value]++;
        }

        int index = 0;
        for (int i = 0; i <= max; i++) {
            while (resultTemp[i]-- > 0) {
                arr[index++] = i;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {5,2,3,4,1,6,8,4,7,6,9,5,2,3,10};

        countingSort(arr, 10);

        System.out.println(new Gson().toJson(arr));
    }

}
