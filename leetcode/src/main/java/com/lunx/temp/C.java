package com.lunx.temp;

import com.google.gson.Gson;

/**
 * @author lunx
 * @version 1.0
 * @date 2021/08/24
 * @description
 */
public class C {

    private static final Gson GSON = new Gson();

    public static void main(String[] args) {
        A a = new A();
        a.setA(1);

        String s = GSON.toJson(a);

        System.out.println("s:" + s);
        B b = GSON.fromJson(s, B.class);


        System.out.println(GSON.toJson(b));
    }
}
