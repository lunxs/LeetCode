package com.lunx.test;

import com.lunx.LeetcodeApplicationTests;
import com.lunx.service.TestInterface;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 * @author XieDesong
 * @version 1.0
 * @title TestInterfaceDemo
 * @description
 * @date 2019/03/13
 * Coffee Box 连咖啡
 */
public class TestInterfaceDemo extends LeetcodeApplicationTests {

    @Autowired
    private Map<String, TestInterface> interfaceMap;

    @Test
    public void test() {
        interfaceMap.forEach((key, value) -> System.out.println(key + ":" + value.getClass().getName()));

        TestInterface testService2 = interfaceMap.get("testService2");
        testService2.test();
    }
}
