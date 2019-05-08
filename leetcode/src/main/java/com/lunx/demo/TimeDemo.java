package com.lunx.demo;

import java.time.LocalDate;
import java.util.Date;

/**
 * @author XieDesong
 * @version 1.0
 * @title TimeDemo
 * @description
 * @date 2019/05/07
 */
public class TimeDemo {

    private void test() {
        LocalDate date = LocalDate.now();
        LocalDate date1 = LocalDate.now();

        Date date2 = new Date();
        Date date3 = new Date();

        System.out.println(date == date1);
        System.out.println(date2.getTime() == date3.getTime());
    }

    public static void main(String[] args) {
        TimeDemo timeDemo = new TimeDemo();
        timeDemo.test();
    }
}
