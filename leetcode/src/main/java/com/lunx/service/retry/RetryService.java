package com.lunx.service.retry;

import com.lunx.exception.TestException;
import org.springframework.core.NestedRuntimeException;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Component;

/**
 * @author lunx
 * @version 1.0
 * @date 2022/10/25
 * @description
 */
@Component
@EnableRetry
public class RetryService {

    @Retryable(label = "retryTest", value = NestedRuntimeException.class, maxAttemptsExpression = "2")
    public void send(String a) {
        System.out.println("send:" + a + ", time:" + System.currentTimeMillis());

        if (a.equals("run")) {
            throw new RuntimeException("run");
        }

        if (a.equals("nested")) {
            throw new TestException("nested");
        }
    }

    @Recover
    public void sendRecover(NestedRuntimeException ex) {
        System.out.println("sendRecover:" + ex);
    }
}
