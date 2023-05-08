package com.lunx.java.test;

/**
 * @author lunx
 * @version 1.0
 * @date 2022/11/14
 * @description
 */
public class Test extends AbstractTest {

//    String a = "b";

    @Override
    public String test1() {
        return null;
    }

    protected String test2() {
        String s = super.test2();
        System.out.println("test:" + s);

        return "test";
    }
}
