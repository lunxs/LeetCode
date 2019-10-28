package com.lunx.demo;

import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;

import javax.print.attribute.IntegerSyntax;
import javax.validation.constraints.NotNull;
import java.util.Date;


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

    private static void test3() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime startTime = now.minusMinutes(60);

        Date today = now.toLocalDate().toDate();

        System.out.println(today);
        System.out.println(now.minusDays(1).toString("yyyyMMdd"));
    }

    public static void main(String[] args) {
        LocalDateTime initTime = LocalDateTime.now().minusHours(1).withSecondOfMinute(0).withMillisOfSecond(0);

        System.out.println(initTime);

        System.out.println(Long.MAX_VALUE);

        System.out.println(Integer.MAX_VALUE);

    }

}
