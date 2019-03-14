package com.lunx.demo;

public class ForDemo {

    private static void test() {

        for (int i = 0; i < 5; i++) {
            System.out.println("i:" + i);
            for (int j = 0; j < 3; j++) {
                if (j == 1) break;
                System.out.println("j:" + j);
            }
            System.out.println("i:" + i);
        }

    }

    public static void main(String[] args) {
        test();
    }
}
