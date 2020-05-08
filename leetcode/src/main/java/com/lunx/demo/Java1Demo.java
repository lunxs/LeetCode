package com.lunx.demo;

import com.lunx.model.Play;

import javax.sound.midi.Soundbank;
import java.math.BigDecimal;
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

    public static void main(String[] args) {

//        test1();

        String a = null;

        System.out.println(a.equals("c"));

        System.out.println("a".equals(null));
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
