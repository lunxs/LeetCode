package com.lunx.test;

public class Test11 implements Runnable {
    @Override
    public void run() {
        try {
            JavaTest1 instance = JavaTest1.getInstance();
            instance.print("Test11");
            instance.setA("Test11");

            Thread.sleep(3000);


            instance.print("Test11");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
