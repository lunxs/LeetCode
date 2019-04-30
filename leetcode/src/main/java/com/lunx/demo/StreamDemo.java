package com.lunx.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author XieDesong
 * @version 1.0
 * @title StreamDemo
 * @description
 * @date 2019/04/29
 */
public class StreamDemo {

    private static void test1() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        list.stream().forEach(System.out::println);

        List<Integer> collect = list.stream().skip(2).collect(Collectors.toList());

        collect.stream().forEach(System.out::println);
    }

    public static void main(String[] args) {
        test1();
    }
}
