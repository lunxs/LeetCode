package com.lunx.demo;

import com.lunx.model.Play;
import org.joda.time.Days;
import org.joda.time.LocalDate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

/**
 * @author XieDesong
 * @version 1.0
 * @title Java1Demo
 * @description
 * @date 2019/01/07
 * Coffee Box 连咖啡
 */
public class Java1Demo {

    private static void test1() {

        // 初始化对象集合
        List<Play> init = init();
        init.stream().forEach(System.out::println);

        // 增加一个特殊对象
        Play play = new Play();
        init.add(play);

        Map<Integer, String> collect = init.stream()
                .collect(Collectors.toMap(Play::getId, Play::getName));

        // 解决方案一
        Map<Integer, String> map = new HashMap<>();
        init.stream().forEach(play1 -> map.put(play1.getId(), play1.getName()));
        // 解决方案二
        Map<Integer, String> collect1 = init.stream()
                .collect(HashMap::new, (m, v) -> m.put(v.getId(), v.getName()), HashMap::putAll);

    }

    private static void test2() {
        Map<String, String> map = new HashMap<>();
        System.out.println(map);
    }

    private static void test3() {

        System.out.println("".split(";").length);
        System.out.println("a".split(";").length);
        System.out.println(";a".split(";").length);
        System.out.println("a;".split(";").length);
        System.out.println(";".split(";").length);
        System.out.println(";;".split(";").length);

    }

    private static void test4() {
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;

        System.out.println(c == d);
        System.out.println(e == f);
        System.out.println(c == (a + b));
        System.out.println(c.equals(a + b));
        System.out.println(g == (a + b));
        System.out.println(g.equals(a + b));

    }

    private static void test5() {
        int a = 25;
        int b = 100;
        System.out.println(0 / 1);
    }

    public static void test6() {
        for (int i = 0; i < 10; i++) {
            if (i == 5) {
                System.out.println(i);
                return;
            }
        }

        System.out.println(8);
    }

    public static void test7() {
        int a = 25;
        System.out.println(a * 1.0 / 100);
    }

    public static void main(String[] args) {
//        test5();
        test7();
    }


    public static List<Play> init() {
        List<Play> playList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Play play = new Play();
            play.setId(i);
            play.setAge(i * 2);
            play.setName(i + "p");

            List<Integer> ps = new ArrayList<>();
            ps.add(i + 1);
            ps.add(i + 2);
            play.setPhones(ps);

            if (i > 4 && i < 8) {
                play.setFlag(true);
            }

            playList.add(play);
        }

        System.out.println(playList);
        return playList;
    }
}
