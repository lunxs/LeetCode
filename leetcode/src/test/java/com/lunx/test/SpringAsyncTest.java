package com.lunx.test;

import com.lunx.LeetcodeApplicationTests;
import com.lunx.service.SpringAsyncService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author lunx
 * @version 1.0
 * @date 2020/12/03
 * @description
 */
public class SpringAsyncTest extends LeetcodeApplicationTests {

    @Autowired
    private SpringAsyncService springAsyncService;

    @Test
    public void test() throws Exception {
        for (int i = 0; i < 1000; i++) {
            springAsyncService.asyncDemo(i);
        }

        Thread.sleep(60 * 1000);
    }
}
