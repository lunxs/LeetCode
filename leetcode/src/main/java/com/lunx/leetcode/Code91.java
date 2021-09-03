package com.lunx.leetcode;

/**
 * @author lunx
 * @version 1.0
 * @date 2021/06/24
 * @description
 */
public class Code91 {

    private String[] mapCode = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13",
            "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26"};

    public int numDecodings(String s) {
        if (null == s || s.length() == 0) return 0;

        char[] chars = s.toCharArray();
        String lastS = "0";
        int a = 0, b = 1, result = 0;
        for (char c : chars) {
            result = 0;
            if (c != '0') {
                result += b;
                if (contains(lastS + c)) {
                    result += a;
                }
            } else {
                if (!contains(lastS + c)) {
                    return 0;
                }
            }
            lastS = String.valueOf(c);

            a = b;
            b = result;
        }
        return result;
    }

    private boolean contains(String s) {
        for (String code : mapCode) {
            if (code.equals(s)) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Code91 code91 = new Code91();

        int num = code91.numDecodings("12");
        System.out.println(num);
    }

}
