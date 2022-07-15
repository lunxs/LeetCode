package com.lunx.test;

import com.sun.org.apache.regexp.internal.RE;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class ThreadPoolTest {

    private static void number() {
        ThreadLocalRandom random = ThreadLocalRandom.current();

        Set<Integer> reds = new HashSet<>();
        while (reds.size() < 5) {
            int red = random.nextInt(1, 36);
            reds.add(red);
        }
        System.out.println("reds:" + reds);

        Set<Integer> blues = new HashSet<>();
        while (blues.size() < 2) {
            int blue = random.nextInt(1, 13);
            blues.add(blue);
        }
        System.out.println("blue:" + blues);
    }

    public static void main(String[] args) {
        number();
    }
}
