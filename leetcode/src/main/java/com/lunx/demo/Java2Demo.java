package com.lunx.demo;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;

/**
 * @author XieDesong
 * @version 1.0
 * @title Java1Demo
 * @description
 * @date 2019/01/07
 */
public class Java2Demo {

    private int i = 1;

    public Java2Demo(int i) {
        System.out.println("constructor:i:" + i);
        this.i = i;
    }

    @PostConstruct
    public void init() {
        System.out.println("init");
    }

    public void test1() {
        System.out.println("test1");
    }

    public static void main(String[] args) {
        Java2Demo java2Demo = new Java2Demo(5);
        java2Demo.test1();
    }


}
