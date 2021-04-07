package com.lunx.test;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author lunx
 * @version 1.0
 * @date 2021/01/29
 * @description
 */
public class ConcurrentHashMapTest {

    public static void main(String[] args) {
        Map<String, String> cmap = new ConcurrentHashMap<>();


        String put = cmap.put("a", "b");
        System.out.println(put);

        String put1 = cmap.put("a", "c");
        System.out.println(put1);
    }
}
