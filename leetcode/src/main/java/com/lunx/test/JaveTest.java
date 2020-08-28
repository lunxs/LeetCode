package com.lunx.test;

public class JaveTest {

    public static void main(String[] args) throws Exception {
        Thread thread11 = new Thread(new Test11());
        Thread thread12 = new Thread(new Test12());

        thread11.start();
        Thread.sleep(1000);

        thread12.start();
    }

}
