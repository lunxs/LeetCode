package com.lunx.test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author lunx
 * @version 1.0
 * @date 2020/10/10
 * @description
 */
public class CompletableFutureDemo {

    public int test1(int num) {
        System.out.println(1);
        if (num < 10) {
            throw new RuntimeException("num less ten!");
        }
        return num;
    }

    public static void main(String[] args) {
        CompletableFutureDemo completableFutureDemo = new CompletableFutureDemo();
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> completableFutureDemo.test1(9));


        try {
            future.get();
        } catch (RuntimeException e) {
            System.out.println("runtime");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("exception");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
