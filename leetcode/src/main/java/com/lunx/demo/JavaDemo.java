package com.lunx.demo;

import com.lunx.model.Play;
import com.lunx.model.Play2;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Title ${CLASS_NAME}
 * @Description
 * @Author XieDesong
 * @Date 2018/10/19
 */
public class JavaDemo {

    public static void test1() {
        int shopId = 1;

        String everArriveShopStr = "1*5;3*1";

        String[] everArriveShopSplit = everArriveShopStr.split(";");

        String result = "";
        int count = 0;

        for (int i = 0; i < everArriveShopSplit.length; i++) {
            if (!(everArriveShopSplit[i].split("\\*")[0]).equals(shopId + "")) {
                result += everArriveShopSplit[i] + ";";
            } else {
                count = Integer.valueOf(everArriveShopSplit[i].split("\\*")[1]);
            }
        }

        if ("".equals(result) || ";".equals(result)) {
            result = shopId + "*" + ++count;
        } else {
            result = result.substring(0, result.length() - 1);
            result = shopId + "*" + ++count + ";" + result;
        }

        System.out.println(result);
    }

    public static void test2() {
    }

    public static void test3() {
        String format = String.format("%.2f", 985646546 / 1000.0);
        System.out.println(format);
    }

    public static void test4() {
        DecimalFormat df = new DecimalFormat("#.##");
        String format = df.format(984654600 / 100.0);
        System.out.println(format);

    }

    public static void test5() {
    }

    public static void test6() {
        String a = "。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。";
        System.out.println(a.replace("。", "？"));
    }

    public static void test7() {
        List<Integer> is = new ArrayList<>();

        boolean contains = is.contains(1);
    }

    public static void test8(List<Play> playList) {
        List<Play> collect = playList.stream().sorted(Comparator.comparing(Play::isFlag)).collect(Collectors.toList());
        System.out.println("");
        System.out.println(collect);
    }

    public static void test9() {
        List<Integer> as = new ArrayList<>();
        as.add(1);
        as.add(4);
        as.add(2);
        as.add(8);
        as.add(5);

        long count = as.stream()
                .sorted(Comparator.comparing(Integer::intValue).reversed())
                .reduce(0, (integer, integer2) -> integer + integer2);
        System.out.println(count);
    }

    public static void test10() {
        List<Play> playList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Play p = new Play();
            p.setId(10 - i);
            p.setAge(i * 2);
            playList.add(p);
        }

        List<Play> collect = playList.stream()
                .sorted((x, y) -> x.getAge() - x.getAge())
                .collect(Collectors.toList());

        System.out.println(collect);
    }

    public static List<Play> test11() {
        List<Play> ps = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Play2 p = new Play2();
            p.setAge(i);
            ps.add(p);
        }

        return ps;
    }

    private static void set(Play play) {
        play.setAge(1);
    }

    private static void test12() {
        List<Integer> list = null;
        List<Integer> collect = list.stream().collect(Collectors.toList());
        System.out.println(collect);
    }

    private static void test13() {
        String a = null;
        String[] split = a.split(",");
    }

    private static void test14(List<Play> playList) {
        Play play1 = playList.stream().filter(play -> "-1".equals(play.getId()))
                .reduce((a, b) -> {
                    a.setAge(a.getAge() + b.getAge());
                    return a;
                }).orElse(null);
        System.out.println(play1);
    }

    private static void test15() {
        String a = "200";
        Integer b = 200;

        System.out.println(a.equals(b));
    }

    public static void main(String[] args) {
        List<Play> init = init();

        test15();

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
