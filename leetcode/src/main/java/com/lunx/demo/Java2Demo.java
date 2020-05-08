package com.lunx.demo;

import com.lunx.model.Play;

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

    public static void main(String[] args) {
        test1();
    }


}
