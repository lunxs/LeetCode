package com.lunx.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author XieDesong
 * @version 1.0
 * @title Code5
 * @description
 * @date 2019/02/27
 * Coffee Box 连咖啡
 */
public class Code5 {
    public String longestPalindrome(String s) {
        if (null == s) {
            return null;
        }
        if (s.length() == 0) {
            return "";
        }

        int max = 1;
        int index = 0;

        int oddMax = 1;
        int evenMax = 1;
        Map<Integer, Character> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(i, c);

            // even
            if ((i - evenMax) >= 0 && c == map.get(i - evenMax)) {
                if (max <= (evenMax + 1)) {
                    max = evenMax + 1;
                    index = i;
                }
                evenMax += 2;
            } else {
                evenMax = 1;
            }

            // odd
            if ((i - oddMax) >= 0 && (i + 1) < s.length() && map.get(i - oddMax) == s.charAt(i + 1)) {
                if (max <= (oddMax + 2)) {
                    max = oddMax + 2;
                    index = i + 1;
                }
                oddMax += 2;
            } else {
                oddMax = 1;
            }
        }

        return s.substring(index - max + 1, index + 1);
    }

    private String first(String s) {
        if (null == s) {
            return null;
        }
        if (s.length() == 0) {
            return "";
        }

        int max = 1;
        int index = 0;
        int temp = 1;

        Map<Integer, Character> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(i, c);

            while ((i - temp) >= 0 && c == map.get(i - temp)) {
                temp++;

                if (max < temp) {
                    max = temp;
                    index = i;
                }
            }

            if ((i - temp) >= 0 && (i + 1) < s.length() && map.get(i - temp) == s.charAt(i + 1)) {
                if (max <= (temp + 2)) {
                    max = temp + 2;
                    index = i + 1;
                }
                temp += 2;
            } else {
                temp = 1;
            }

        }

        return s.substring(index - max + 1, index + 1);
    }

    private String second(String s) {
        if (null == s) {
            return null;
        }
        if (s.length() == 0) {
            return "";
        }

        char[] chars = s.toCharArray();
        int length = chars.length;
        int left = 0;
        int right = 0;

        for (int i = 0; i < length; i++) {

            int left1 = i - 1;
            int right1 = i + 1;

            while (right1 < length && chars[right1] == chars[i]) {
                right1++;
            }

            i = right1 - 1;
            while (left1 >= 0 && right1 < length && chars[left1] == chars[right1]) {
                left1--;
                right1++;
            }

            if ((right1 - left1) > (right - left)) {
                right = right1;
                left = left1 + 1;
            }

        }

        return s.substring(left, right);
    }

    public static void main(String[] args) {

        String s = "aaa";

        Code5 code5 = new Code5();
        String s1 = code5.second(s);
        System.out.println(s1);
    }
}
