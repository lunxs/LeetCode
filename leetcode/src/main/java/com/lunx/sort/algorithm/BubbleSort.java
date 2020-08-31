package com.lunx.sort.algorithm;

import com.google.gson.Gson;

/**
 * @author lunx
 * @version 1.0
 * @date 2020/08/31
 * @description 冒泡排序
 */
public class BubbleSort {

    public static void bubbleSort(int[] arr) {
        if (null == arr || arr.length < 1) return;

        int temp;
        int length = arr.length;
        // 循环length-1次，令i=1, i<length 或 i=0, i<length-1
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static void bubbleSort1(int[] arr) {
        if (null == arr || arr.length < 1) return;

        boolean flag;
        int temp;
        int length = arr.length;
        // 循环length-1次，令i=1, i<length 或 i=0, i<length-1
        for (int i = 1; i < length; i++) {
            flag = true;
            for (int j = 0; j < length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;

                    flag = false;
                }
            }

            if (flag) break;
        }
    }

    public static void main(String[] args) {
        int[] ints = {0,2,3,4,5,5,6,6,7,8,9};

        bubbleSort1(ints);

        System.out.println(new Gson().toJson(ints));
    }
}
