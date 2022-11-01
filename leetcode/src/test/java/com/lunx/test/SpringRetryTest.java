package com.lunx.test;

import com.lunx.LeetcodeApplicationTests;
import com.lunx.service.retry.RetryService;
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
public class SpringRetryTest extends LeetcodeApplicationTests {

    @Autowired
    private RetryService retryService;

    @Test
    public void test() {
        String a = "nested";
        retryService.send(a);
    }
}
