package com.lunx.test;

import com.lunx.LeetcodeApplicationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

/**
 * @author desong.xie
 * @version 1.0
 * @title ConfigTest
 * @date 2019/09/27
 * @description
 */
public class ConfigTest extends LeetcodeApplicationTests {

    @Autowired
    private Environment environment;

    @Test
    public void test() {
        System.out.println(environment.getProperty("spring.datasource.url"));
        System.out.println(environment);


        System.out.println(1);
    }
}
