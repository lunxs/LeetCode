package com.lunx.test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class JaveTest {

    public static void main(String[] args) throws Exception {
        test();
    }


    public static void test() {
        retry:
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.println("i:" + i + ",j:" + j);
                if (i == 2) {
                    break retry;
                }

                /*if (j == 3) {
                    continue retry;
                }*/

                if (j == 5) {
                    continue;
                }
                System.out.println("continue");

                if (j == 6) {
                    break;
                }
            }
        }
    }

}
