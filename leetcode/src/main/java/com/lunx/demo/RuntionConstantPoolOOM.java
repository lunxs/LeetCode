package com.lunx.demo;

public class RuntionConstantPoolOOM {

    public static void main(String[] args) {
        String st1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(st1.intern() == st1);

        String st2 = new StringBuilder("ja").append("va").toString();
        System.out.println(st2.intern() == st2);

    }
}
