package com.lunx.demo;

public class internDemo {

    public static void main(String[] args) {

        // 它遵循以下规则：对于任意两个字符串 s 和 t，当且仅当 s.equals(t) 为 true 时，s.intern() == t.intern() 才为 true
        String st1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(st1.intern() == st1);

        // 出现在java常量池中的 返回都会false
        String st2 = new StringBuilder("ja").append("va").toString();
        System.out.println(st2.intern() == st2);

    }
}
