package com.lunx.leetcode;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author desong.xie
 * @version 1.0
 * @title Code49
 * @date 2020/04/03
 * @description
 */
public class Code49 {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);

            String st = String.valueOf(chars);

            List<String> strings = map.get(st);
            if (strings == null) {
                strings = new ArrayList<>();
                map.put(st, strings);
            }
            strings.add(s);
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        Code49 code49 = new Code49();
        String[] a = {"eat", "tea", "tan", "ate", "nat", "bat"};

        List<List<String>> lists = code49.groupAnagrams(a);
        System.out.println(lists);

    }
}
