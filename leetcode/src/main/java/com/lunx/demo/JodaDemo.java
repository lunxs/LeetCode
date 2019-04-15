package com.lunx.demo;

import org.joda.time.LocalDate;

/**
 * @author XieDesong
 * @version 1.0
 * @title JodaDemo
 * @description
 * @date 2019/02/28
 */
public class JodaDemo {

    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        System.out.println(now);

        System.out.println(now.minusDays(1));
    }
}
