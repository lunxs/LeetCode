package com.lunx.demo;

import java.util.Hashtable;
import java.util.Properties;

/**
 * @author XieDesong
 * @version 1.0
 * @title Demo
 * @description
 * @date 2019/05/31
 */
public class Demo {


    public static void main(String[] args) {

        Properties properties = System.getProperties();

        Hashtable<Object, Object> table = properties;

        table.forEach((k, v) -> {
            System.out.println(k + ":::" + v);
        });


    }
}
