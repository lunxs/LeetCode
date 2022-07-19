package com.lunx.test;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class ThreadPoolTest {

    private static void number() {
        ThreadLocalRandom random = ThreadLocalRandom.current();

        Set<Integer> reds = new HashSet<>();
        while (reds.size() < 5) {
            int red = random.nextInt(1, 36);
            reds.add(red);
        }
        System.out.println("reds:" + reds.stream().sorted().collect(Collectors.toList()));

        Set<Integer> blues = new HashSet<>();
        while (blues.size() < 2) {
            int blue = random.nextInt(1, 13);
            blues.add(blue);
        }
        System.out.println("blue:" + blues.stream().sorted().collect(Collectors.toList()));
    }

    public static void main(String[] args) {
        number();
    }
}
