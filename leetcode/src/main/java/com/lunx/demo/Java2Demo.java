package com.lunx.demo;

import com.lunx.model.Play;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author XieDesong
 * @version 1.0
 * @title Java1Demo
 * @description
 * @date 2019/01/07
 */
public class Java2Demo {

    private static void test1() {

        StringBuilder sb = new StringBuilder();
        sb.append("a").append(2).append("^");
        System.out.println(sb);

        System.out.println("a2^".equals(sb.toString()));
        System.out.println(sb.toString());

    }

    private static void test2() {
        String a = "123456";
        BigDecimal divide = new BigDecimal(a).divide(new BigDecimal(1000));
        String format = String.format("%.2f", divide);
        System.out.println(format);
    }

    private static void test3() {
        String a = "123456.23";
        int i = Integer.parseInt(a);
        System.out.println(i);
    }

    public static void main(String[] args) {
//        test3();
        String a = "aaa";
        System.out.println(a.contains("aaa"));
    }


}
