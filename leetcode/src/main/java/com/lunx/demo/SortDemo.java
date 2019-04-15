package com.lunx.demo;

import com.lunx.model.Play;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author XieDesong
 * @version 1.0
 * @title SortDemo
 * @description
 * @date 2018/12/26
 */
public class SortDemo {

    public static List<Play> init() {
        List<Play> ps = new ArrayList<>();
        Play p = new Play();
        p.setId(1);
        p.setAge(2);
        p.setWeight(3);
        ps.add(p);

        Play p1 = new Play();
        p1.setId(1);
        p1.setAge(2);
        p1.setWeight(3);
        ps.add(p1);

        Play p2 = new Play();
        p2.setId(0);
        p2.setAge(0);
        p2.setWeight(3);
        ps.add(p2);

        Play p3 = new Play();
        p3.setId(0);
        p3.setAge(0);
        p3.setWeight(3);
        ps.add(p3);

        Play p4 = new Play();
        p4.setId(0);
        p4.setAge(0);
        p4.setWeight(0);
        ps.add(p4);

        Play p5 = new Play();
        p5.setId(0);
        p5.setAge(1);
        p5.setWeight(1);
        ps.add(p5);

        Play p6 = new Play();
        p6.setId(0);
        p6.setAge(1);
        p6.setWeight(3);
        ps.add(p6);

        Play p7 = new Play();
        p7.setId(0);
        p7.setAge(2);
        p7.setWeight(3);
        ps.add(p7);

        Play p8 = new Play();
        p8.setId(0);
        p8.setAge(3);
        p8.setWeight(3);
        ps.add(p8);

        return ps;
    }

    public static int compareTo(Play vo1, Play vo2) {
        int doneTimes = vo1.getId() - vo2.getId();
        if (doneTimes == 0) {
            int leftTimes = (vo1.getWeight() - vo1.getAge()) - (vo2.getWeight() - vo2.getAge());
            if (leftTimes == 0) {
                return vo2.getAge() - vo1.getAge();
            }
            return leftTimes;
        }

        return doneTimes;
    }

    public static void main(String[] args) {
        List<Play> ps = init();

        List<Play> collect = ps.stream()
                .sorted((x, y) -> compareTo(y, x))
                .collect(Collectors.toList());

        for (Play p : collect) {
            System.out.println(p);
        }
    }
}
