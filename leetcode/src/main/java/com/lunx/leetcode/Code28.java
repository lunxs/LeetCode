package com.lunx.leetcode;

/**
 * @author XieDesong
 * @version 1.0
 * @title Code28
 * @description
 * @date 2019/05/16
 */
public class Code28 {

    public int strStr(String haystack, String needle) {
        if (needle.length() < 1) return 0;

        char[] chars = haystack.toCharArray();
        char[] chars1 = needle.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == chars1[0]) {
                int j = 1;
                for (; j < chars1.length; j++) {
                    if (i + j >= chars.length) {
                        return -1;
                    }
                    if (chars1[j] != chars[i + j]) {
                        break;
                    }
                }

                if (j == chars1.length) return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Code28 code28 = new Code28();
        String haystack = "aaaaa";
        String needle = "a";

        System.out.println(code28.strStr(haystack, needle));
    }
}
