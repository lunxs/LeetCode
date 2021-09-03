package com.lunx.test;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class JaveTest {

    public static void main(String[] args) {
        List<String> aList = new ArrayList<>();
        aList.add("1");
        System.out.println(new Gson().toJson(aList));

        aList.forEach(a -> System.out.print(a + ","));
        System.out.println("*******");

        aList.clear();

        aList.add("2");
        aList.add("3");
        aList.forEach(a -> System.out.print(a + ","));
        System.out.println(new Gson().toJson(aList));
    }
}
