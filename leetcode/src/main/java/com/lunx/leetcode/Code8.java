package com.lunx.leetcode;

/**
 * @author XieDesong
 * @version 1.0
 * @title Code8
 * @description
 * @date 2019/03/11
 * Coffee Box 连咖啡
 */
public class Code8 {

    public int myAtoi(String str) {
        if (null == str) return 0;
        String trim = str.trim();
        if (trim.length() == 0) return 0;
        char[] chars = trim.toCharArray();

        if ((chars[0] < 48 || chars[0] > 57) && chars[0] != 43 && chars[0] != 45) {
            return 0;
        }

        char[] chars1;
        if (chars[0] == 43 || chars[0] == 45) {
            chars1 = new char[chars.length - 1];
            System.arraycopy(chars, 1, chars1, 0, chars.length - 1);
            return cal(chars1, chars[0] == 43);
        } else {
            return cal(chars, true);
        }
    }

    private int cal(char[] chars, boolean isPos) {
        int result = 0;
        for (Character c : chars) {
            if (c < 48 || c > 57) break;

            if (Integer.MAX_VALUE / 10 < result) {
                return isPos ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            if (Integer.MAX_VALUE / 10 == result) {
                if (isPos && c >= 55) return Integer.MAX_VALUE;
                if (!isPos && c >= 56) return Integer.MIN_VALUE;
            }

            result = result * 10 + (c - 48);
        }

        return isPos ? result : -result;
    }

    public static void main(String[] args) {
        Code8 code8 = new Code8();

        System.out.println(Integer.MAX_VALUE);
        String str = "2147483646";
        System.out.println(code8.myAtoi(str));

    }
}
