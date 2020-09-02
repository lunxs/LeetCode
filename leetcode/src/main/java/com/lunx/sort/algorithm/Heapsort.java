package com.lunx.sort.algorithm;

import com.google.gson.Gson;

/**
 * @author lunx
 * @version 1.0
 * @date 2020/09/01
 * @description 堆排序
 */
public class Heapsort {

    /**
     * 升序 - 大顶堆实现
     * @param arr
     */
    public static void heapSort(int[] arr) {
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
        int largestIndex = i;

        if (left < length && arr[left] > arr[largestIndex]) {
            largestIndex = left;
        }
        if (right < length && arr[right] > arr[largestIndex]) {
            largestIndex = right;
        }

        if (largestIndex != i) {
            swap(arr, i, largestIndex);
            heapify(arr, largestIndex, length);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 降序 - 小顶堆实现
     */
    public static void heapSortDescending(int[] arr) {
        if (null == arr || arr.length < 1) return;

        int length = arr.length;
        buildMinHeap(arr, length);

        for (int i = length - 1; i >= 0; i--) {
            swap(arr, 0, i);
            length--;
            heapifyMin(arr, 0, length);
        }
    }

    public static void buildMinHeap(int[] arr, int length) {
        for (int i = length / 2; i >= 0; i--) {
            heapifyMin(arr, i, length);
        }
    }

    public static void heapifyMin(int[] arr, int i, int length) {
        // 递归实现 start
        /*int minIndex = i;

        int leftNodeIndex = 2 * i + 1;
        int rightNodeIndex = 2 * i + 2;

        if (leftNodeIndex < length && arr[leftNodeIndex] < arr[minIndex]) {
            minIndex = leftNodeIndex;
        }
        if (rightNodeIndex < length && arr[rightNodeIndex] < arr[minIndex]) {
            minIndex = rightNodeIndex;
        }

        if (minIndex != i) {
            swap(arr, i, minIndex);
            heapifyMin(arr, minIndex, length);
        }*/
        // 递归实现 end

        // 迭代实现 start
        while (i < length) {
            // 假设当前索引为最小索引
            int minIndex = i;
            // 左孩子索引
            int leftNodeIndex = 2 * minIndex + 1;
            // 右孩子索引
            int rightNodeIndex = 2 * minIndex + 2;

            if (leftNodeIndex < length && arr[leftNodeIndex] < arr[minIndex]) {
                minIndex = leftNodeIndex;
            }
            if (rightNodeIndex < length && arr[rightNodeIndex] < arr[minIndex]) {
                minIndex = rightNodeIndex;
            }

            if (minIndex != i) {
                swap(arr, i, minIndex);
                i = minIndex;
            } else {
                break;
            }
        }
        // 迭代实现 end
    }



    public static void main(String[] args) {
        int[] ints = {5,2,3,7,6,8,9,35,1,13,23,61,31,15,16};

        heapSortDescending(ints);

        System.out.println(new Gson().toJson(ints));
    }
}
