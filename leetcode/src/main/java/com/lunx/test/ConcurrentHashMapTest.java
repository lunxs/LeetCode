package com.lunx.test;

import java.util.concurrent.*;

/**
 * @author lunx
 * @version 1.0
 * @date 2021/01/29
 * @description
 */
public class ConcurrentHashMapTest {

    private static ExecutorService es = new ThreadPoolExecutor(10, 10, 3000L,
            TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());


    private void add(ConcurrentHashMap<String, Integer> map) {
//        map.computeIfAbsent("aa", k -> 180);

//        map.computeIfPresent("aa", (k, v) -> v + 1);

        map.compute("aa", (k, v) -> (v == null ? 0 : v) + 1);

//        map.put("a", 2);
        System.out.println(map.get("a"));


        Integer a = map.putIfAbsent("a", 3);
        System.out.println(map.get("a"));
        System.out.println("a=" + a);
    }

    public static void main(String[] args) {

        ConcurrentHashMap<String, Integer> concurrentHashMap = new ConcurrentHashMap();

        concurrentHashMap.put("a", 1);

        concurrentHashMap.compute("a", (k, v) -> v == null ? 0 : v + 1);

        System.out.println(concurrentHashMap);

    }


}
