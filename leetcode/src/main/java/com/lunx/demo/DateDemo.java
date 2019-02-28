package com.lunx.demo;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Title ${CLASS_NAME}
 * @Description
 * @Author XieDesong
 * @Date 2018/10/18
 * Coffee Box 连咖啡
 */
public class DateDemo {

    private static void test1() {
        LocalDate now = LocalDate.now();
        System.out.println(now);

        LocalDateTime now1 = LocalDateTime.now();
        System.out.println(now1);

        System.out.println(now.isAfter(now1.toLocalDate()));
    }

    private static void test2() {
        String time = "07:11";
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");

        try {
            Date parse = sdf.parse(time);
            System.out.println(parse);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private static void test3() {
        LocalDate day = LocalDate.now();

        DateTime dateTime = DateTime.now();
        System.out.println(dateTime.getSecondOfDay());
        System.out.println(dateTime);
        DateTime now = DateTime.now();

        Minutes minutes = Minutes.minutesBetween(now, dateTime);
        System.out.println(minutes.getMinutes());

        System.out.println(Seconds.secondsBetween(day, day.plusDays(1)).getSeconds());
    }

    public static void main(String[] args) {
//        test3();

        System.out.println(LocalDate.now().toString());
    }
}
