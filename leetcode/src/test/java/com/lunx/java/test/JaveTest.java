package com.lunx.java.test;

public class JaveTest {

    private static int getaaa(int i) {
        if (1 == i) {
            throw new RuntimeException("runtime");
        }

        return i << 1;
    }

    private static int retry(int i) {
        try {
            return getaaa(i);
        } catch (Exception e) {
            System.out.println("try again");
        }

        return retry(++i);
    }


    public static void main(String[] args) {
        String a = null;
        String b = "1";
        System.out.println(a.equals(b));
    }

}
