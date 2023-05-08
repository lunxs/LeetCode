package com.lunx.java.test;

/**
 * @author lunx
 * @version 1.0
 * @date 2022/11/14
 * @description
 */
public abstract class AbstractTest implements TestInterface {

    protected String a = "a";

    protected String test2() {
        System.out.println("abstract test2");
        return "test2";
    }
}
