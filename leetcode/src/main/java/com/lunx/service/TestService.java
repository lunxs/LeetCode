package com.lunx.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author XieDesong
 * @version 1.0
 * @title TestService
 * @description
 * @date 2019/04/19
 */
@Service
public class TestService implements TestInterface {

    private Map<String, String> map = new HashMap<>();

    @Override
    public void test() {
        System.out.println("TestService");
    }

    public void test1(String key) {
        String value = map.get(key);
        if (null == value) {
            System.out.println("put key:" + key);
            map.put(key, key + "a");
        } else {
            System.out.println("key is existed, value:" + value);
        }
    }
}
