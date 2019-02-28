package com.lunx.demo;

import sun.misc.BASE64Encoder;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author XieDesong
 * @version 1.0
 * @title ImageDemo
 * @description
 * @date 2018/11/16
 * Coffee Box 连咖啡
 */
public class ImageDemo {

    public static void test1() {
        InputStream inputStream = null;
        byte[] data = null;
        try {
            inputStream = new FileInputStream("https://qaimages.lyancafe.com/giftPacks/daily/1542104368357.jpg");
            data = new byte[inputStream.available()];
            inputStream.read(data);
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 加密
        BASE64Encoder encoder = new BASE64Encoder();
        String encode = encoder.encode(data);

        System.out.println(encode);
    }

    public static void main(String[] args) {
        test1();
    }
}
