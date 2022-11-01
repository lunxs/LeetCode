package com.lunx.exception;

import org.springframework.core.NestedRuntimeException;

/**
 * @author lunx
 * @version 1.0
 * @date 2022/10/25
 * @description
 */
public class TestException extends NestedRuntimeException {
    public TestException(String msg) {
        super(msg);
    }

    public TestException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
