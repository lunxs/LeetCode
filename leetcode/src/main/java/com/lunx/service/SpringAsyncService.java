package com.lunx.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author lunx
 * @version 1.0
 * @date 2020/12/03
 * @description
 */
@Service
public class SpringAsyncService {

    @Async
    public void asyncDemo(int i) throws Exception {
        System.out.println(i + ":" + Thread.currentThread().getName() + "start");
        Thread.sleep(1 * 1000);
        System.out.println(i + ":" + Thread.currentThread().getName() + "end");
    }
}
