package com.lunx.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author XieDesong
 * @version 1.0
 * @title Code13
 * @description
 * @date 2019/04/03
 * Coffee Box 连咖啡
 */
public class Code13 {

    private static Map<String, Integer> roman = new HashMap();

    static {
        System.out.println("put");
        roman.put("I", 1);
        roman.put("V", 5);
        roman.put("X", 10);
        roman.put("L", 50);
        roman.put("C", 100);
        roman.put("D", 500);
        roman.put("M", 1000);
    }

    public int romanToInt(String s) {
        try {
            String[] split = s.split("");

            int result = 0;
            for (int i = 0; i < split.length; i++) {
                if (i + 1 < s.length() && roman.get(split[i]) < roman.get(split[i + 1])) {
                    result -= roman.get(split[i]);
                } else {
                    result += roman.get(split[i]);
                }
            }

            return result;
        } catch (Exception e) {
            throw new IllegalArgumentException("input error");
        }
    }

    public static void main(String[] args) {
        System.out.println("main 1");
        Code13 code13 = new Code13();
        System.out.println("IKL".substring(2,3));


        System.out.println(code13.romanToInt("MCMXCIV"));


    }
}
