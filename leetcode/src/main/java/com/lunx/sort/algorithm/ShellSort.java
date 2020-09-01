package com.lunx.sort.algorithm;

import com.google.gson.Gson;

/**
 * @author lunx
 * @version 1.0
 * @date 2020/09/01
 * @description 希尔排序
 */
public class ShellSort {

    public static void shellSort(int[] arr) {
        if (null == arr || arr.length < 1) return;

        int temp, preIndex;
        int length = arr.length;
        int increment = length;
        while ((increment /= 2) >= 1) {
            // 不难看出以下循环，若令increment=1，则为简单插入排序
            for (int i = increment; i < length; i++) {
                temp = arr[i];
                preIndex = i;
                while (preIndex >= increment && arr[preIndex - increment] > temp) {
                    arr[preIndex] = arr[preIndex - increment];
                    preIndex -= increment;
                }

                arr[preIndex] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] ints = {7,8,9,5,3,7,2,6,0,1,2,5,1};

        shellSort(ints);

        System.out.println(new Gson().toJson(ints));
    }
}
