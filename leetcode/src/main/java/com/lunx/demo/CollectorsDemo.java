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
 * @title CollectorsDemo
 * @description
 * @date 2019/01/24
 * Coffee Box 连咖啡
 */
public class CollectorsDemo {

    private void test() {
        List<Play> init = init1();
        Map<Integer, Play> collect = init.stream()
                .collect(Collectors.toMap(item -> item.getId(), item -> item, (o, n) -> merge(o, n)));

        System.out.println(collect);
    }

    private Play merge(Play oldValue, Play newValue) {
        oldValue.setAge(oldValue.getAge() + newValue.getAge());
        return oldValue;
    }

    private void test1() {
        List<Play> init = init();
        init.stream()
                .collect(HashMap::new, (m, v) -> m.put(v.getId(), v), HashMap::putAll);
    }

    private void test2() {
        List<Play> init = init1();
        Map<Integer, Play> collect = init.stream()
                .collect(HashMap::new, (m, v) -> put(m, v), (m, v) -> merge(m, v));

        System.out.println(collect);
    }

    private Map<Integer, Play> put(Map<Integer, Play> m, Play v) {
        System.out.println("****************");
        System.out.println(m);
        System.out.println(v);
        System.out.println("****************");

        m.put(v.getId(), v);

        return m;
    }

    private void merge(Map<Integer, Play> m1, Map<Integer, Play> m2) {
        System.out.println("----------------------");
        System.out.println(m1);
        System.out.println(m2);
        System.out.println("----------------------");
        m1.putAll(m2);
//        return m1;
    }

    public static void main(String[] args) {
        CollectorsDemo demo = new CollectorsDemo();

        demo.test2();
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

    public static List<Play> init1() {
        List<Play> playList = new ArrayList<>();

        Play play = new Play();
        play.setId(1);
        play.setAge(1);
        play.setName("p" + 1);
        playList.add(play);

        Play play1 = new Play();
        play1.setId(2);
        play1.setAge(2);
        play1.setName("p" + 2);
        playList.add(play1);

        Play play2 = new Play();
        play2.setId(2);
        play2.setAge(3);
        play2.setName("p" + 3);
        playList.add(play2);

        Play play3 = new Play();
        play3.setId(4);
        play3.setAge(4);
        play3.setName("p" + 4);
        playList.add(play3);

        Play play4 = new Play();
        play4.setId(5);
        play4.setAge(5);
        play4.setName("p" + 5);
        playList.add(play4);

        Play play5 = new Play();
        play5.setId(4);
        play5.setAge(6);
        play5.setName("p" + 6);
        playList.add(play5);

        return playList;
    }
}
