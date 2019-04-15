package com.lunx.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author XieDesong
 * @version 1.0
 * @title Code3
 * @description
 * @date 2019/02/22
 */
public class Code3 {

    public int first(String s) {

        char[] chars = s.toCharArray();

        int max = 0;
        for (int i = 0; i < chars.length; i++) {

            Map<Character, Integer> map = new HashMap<>();
            for (int j = i + 1; j < chars.length; j++) {
                if (map.containsKey(chars[i])) {
                    max = (j - i) > max ? (j - i) : max;
                    break;
                }
                map.put(chars[j], j);
            }
        }

        return max == 0 ? chars.length : max;
    }

    public int lengthOfLongestSubstring(String s) {

        char[] chars = s.toCharArray();

        int max = 0;
        int start = 0;
        Map<Character, Integer> map = new HashMap<>();
        LinkedList<Character> chr = new LinkedList<>();

        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if (map.containsKey(aChar)) {
                max = (i - start) > max ? (i - start) : max;
                start = map.get(aChar) + 1;

                Character pop;
                while ((pop = chr.pop()) != aChar) {
                    map.remove(pop);
                }
                map.remove(aChar);
            }

            map.put(aChar, i);
            chr.add(aChar);
        }

        return (chars.length - start) > max ? (chars.length - start) : max;

    }

    public int second(String s) {

        char[] chars = s.toCharArray();

        int max = 0;
        int start = 0;
        String temp = "";

        int length = chars.length;
        for (int i = 0; i < length; i++) {
            char aChar = chars[i];

            int index = temp.indexOf(aChar);
            if (index >= 0) {
                max = (i - start) > max ? (i - start) : max;

                temp = temp.substring(index + 1);

                start += index + 1;
            }

            temp += aChar;
        }

        return (length - start) > max ? (length - start) : max;

    }

    public int three(String s) {

        int max = 0;
        int start = 0;
        String temp = "";

        for (int i = 0; i < s.length(); i++) {
            char aChar = s.charAt(i);

            int index = temp.indexOf(aChar);
            if (index >= 0) {
                max = (i - start) > max ? (i - start) : max;

                temp = temp.substring(index + 1);

                start += index + 1;
            }

            temp += aChar;
        }

        return (s.length() - start) > max ? (s.length() - start) : max;

    }

    public static void main(String[] args) {
        String input = "abcabcbb";

        int result = new Code3().second(input);
        System.out.println(result);

        int result1 = new Code3().lengthOfLongestSubstring(input);
        System.out.println(result1);
    }

}
