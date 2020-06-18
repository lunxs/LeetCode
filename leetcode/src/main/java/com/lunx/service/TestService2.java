package com.lunx.service;

import org.springframework.stereotype.Service;

/**
 * @author XieDesong
 * @version 1.0
 * @title TestService2
 * @description
 * @date 2019/04/19
 */
@Service
public class TestService2 implements TestInterface {

    @Override
    public void test() {
        System.out.println("TestService2");
    }
}
