package com.lunx.demo;

import java.util.concurrent.CompletableFuture;

/**
 * @author desong.xie
 * @version 1.0
 * @date 2020/07/08
 * @description
 */
public class CompletableFutureDemo {

    private static int calc(int a) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {

        }
        return a + 1;
    }

    private static int calc1(int a) {
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {

        }
        return a + 2;
    }

    private static int calc2(int a) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {

        }
        return a + 3;
    }

    public static void main(String[] args) throws Exception {
        long startTime = System.currentTimeMillis();
        int a = 5;
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> calc(a))
                .thenApply((b) -> calc2(b));

        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> calc1(a));

        long time1 = System.currentTimeMillis();
        System.out.println("time1:" + (time1 - startTime));

        System.out.println("future1:" + future1.get());

        long time2 = System.currentTimeMillis();
        System.out.println("time2:" + (time2 - startTime));

        System.out.println("future2:" + future2.get());

        long time3 = System.currentTimeMillis();
        System.out.println("time3:" + (time3 - startTime));
    }
}
