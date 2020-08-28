package com.lunx.test;

public class JavaTest1 {

    private static JavaTest1 instance = new JavaTest1();

    public static JavaTest1 getInstance() {
        return instance;
    }

    private String a = "a";

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public void print(String name) {
        System.out.println(name + this.a);
    }
}
