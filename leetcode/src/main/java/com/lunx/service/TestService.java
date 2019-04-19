package com.lunx.service;

import org.springframework.stereotype.Service;

/**
 * @author XieDesong
 * @version 1.0
 * @title TestService
 * @description
 * @date 2019/04/19
 * Coffee Box 连咖啡
 */
@Service
public class TestService implements TestInterface {

    @Override
    public void test() {
        System.out.println("TestService");
    }
}
