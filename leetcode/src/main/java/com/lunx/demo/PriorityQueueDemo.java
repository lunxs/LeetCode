package com.lunx.demo;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author XieDesong
 * @version 1.0
 * @title PriorityQueueDemo
 * @description
 * @date 2019/04/29
 */
public class PriorityQueueDemo {

    public static void main(String[] args) {
        int[] is = {1,3,2,2,0,7,9,3};

        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(is.length, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        for (int i : is) {
            System.out.println(i);
            queue.add(i);
        }

        queue.poll();
        queue.poll();
        queue.poll();
        queue.poll();
        queue.poll();

        System.out.println(1);
    }
}
