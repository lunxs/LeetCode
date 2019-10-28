package com.lunx.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author desong.xie
 * @version 1.0
 * @title ExecutorTest
 * @date 2019/10/24
 * @description
 */
public class ExecutorTest {
    private static ExecutorService es = new ThreadPoolExecutor(5, 5, 300L,
            TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());


    private void test() {
        for (int i = 0; i < 1000; i++) {
            es.execute(new Runnable() {
                @Override
                public void run() {
                    test1();
                }
            });
        }

        es.shutdown();
    }

    private void test1() {
        String name = Thread.currentThread().getName();

        System.out.println(name + " test1 start");
        long sum = 0;
        for (long i = 0; i < Integer.MAX_VALUE; i++) {
            sum += i;
        }

        System.out.println(name + " test1 end, sum:" + sum);
    }

    public static void main(String[] args) {
        ExecutorTest executorTest = new ExecutorTest();
//        executorTest.test();


        while (true) {
            try {
                // 更新ttf中bipBankId
                System.out.println(1);
            } finally {
                es.shutdown();
            }

            while (true) {
                if (es.isTerminated()) {
                    System.out.println("break");
                    break;
                }
            }

            System.out.println(2);

        }

    }
}
