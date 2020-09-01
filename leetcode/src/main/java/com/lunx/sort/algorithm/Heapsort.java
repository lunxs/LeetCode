package com.lunx.sort.algorithm;

import com.google.gson.Gson;

/**
 * @author lunx
 * @version 1.0
 * @date 2020/09/01
 * @description 堆排序
 */
public class Heapsort {

    public static void heapsort(int[] arr) {
        if (null == arr || arr.length < 1) return;

        int length = arr.length;
        buildMaxHeap(arr, length);

        for(int i = length - 1; i > 0; i--) {
            swap(arr, 0, i);
            length--;
            heapify(arr, 0, length);
        }
    }

    public static void buildMaxHeap(int[] arr, int length) {
        for (int i = length / 2; i >= 0; i--) {
            heapify(arr, i, length);
        }
    }

    public static void heapify(int[] arr, int i, int length) {
        // 左孩子下标
        int left = 2 * i + 1;
        // 右孩子下标
        int right = 2 * i + 2;
        int largest = i;

        if (left < length && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < length && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, largest, length);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] ints = {5,2,3,7,6,8,9,35,1,13,23,61,31,15,16};

        heapsort(ints);

        System.out.println(new Gson().toJson(ints));
    }
}
