package com.lunx.demo;

import com.google.gson.Gson;

import java.util.Map;

/**
 * @author XieDesong
 * @version 1.0
 * @title GsonDemo
 * @description
 * @date 2019/01/22
 * Coffee Box 连咖啡
 */
public class GsonDemo {

    private static Gson GSON = new Gson();

    public static void test1() {
        String a = "{\"ab\":\"123\",\"abc\":\"gasf\"}";

        Map<String, String> map = GSON.fromJson(a, Map.class);
        int ab = Integer.parseInt(map.get("ab"));
        String abc = map.get("abc");

        System.out.println(ab);
        System.out.println(abc);
    }

    private static void test2() {

    }

    public static void main(String[] args) {
        test1();
    }
}
