package com.lunx.test;

public class Test12 implements Runnable {
    @Override
    public void run() {
        JavaTest1 instance = JavaTest1.getInstance();
        instance.print("Test12");
        instance.setA("Test12");
        instance.print("Test12");
    }
}
