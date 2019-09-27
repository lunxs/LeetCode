package com.lunx.demo;

import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;

import javax.validation.constraints.NotNull;


/**
 * @author XieDesong
 * @version 1.0
 * @title JodaDemo
 * @description
 * @date 2019/02/28
 */
public class JodaDemo {

    private static void test1() {
        LocalDate yyyyMMdd = LocalDate.parse("20190805", DateTimeFormat.forPattern("yyyyMMdd")).plusDays(1);

        System.out.println(yyyyMMdd);

    }

    private static boolean test2(@NotNull String a) {
        System.out.println(a);
        return false;
    }

    public static void main(String[] args) {
        String a = null;
        boolean b = test2(a);

        System.out.println(b);
    }

    private void word() {


    }
}
