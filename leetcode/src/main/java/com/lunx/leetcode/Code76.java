package com.lunx.leetcode;

import javax.xml.stream.FactoryConfigurationError;
import java.util.HashMap;
import java.util.Map;

/**
 * @author desong.xie
 * @version 1.0
 * @date 2020/07/30
 * @description
 */
public class Code76 {
    public String minWindow(String s, String t) {
        int sLength = s.length();
        int tLength = t.length();
        if (sLength < 1 || tLength < 1) {
            return "";
        }

        Map<Character, Integer> tMap = new HashMap();
        for (int i = 0; i < tLength; i++) {
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
        }

        int l = 0, r = 0;
        int idx = l;
        int subLength = sLength;

        Map<Character, Integer> map = new HashMap();

        while (l < sLength && t.indexOf(s.charAt(l)) < 0) {
            l++;
        }
        r = l;

        while (r < sLength) {
            char ch = s.charAt(r);
            if (t.indexOf(ch) > -1) {
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }

            if (fullContains(tMap, map)) {
                while (l <= r) {
                    char c = s.charAt(l);
                    if (t.indexOf(c) < 0) {
                        l++;
                        continue;
                    }
                    if (map.get(c) > tMap.get(c)) {
                        map.put(c, map.get(c) - 1);
                        l++;
                        continue;
                    }

                    if (r - l + 1 < subLength) {
                        subLength = r - l + 1;
                        idx = l;
                    }
                    break;
                }
            }
            r++;
        }

        if (fullContains(tMap, map)) {
            return s.substring(idx, idx + subLength);
        }
        return "";
    }

    private boolean fullContains(Map<Character, Integer> tMap, Map<Character, Integer> map) {
        for (Character c : tMap.keySet()) {
            if (map.getOrDefault(c, 0) < tMap.get(c)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Code76 code76 = new Code76();

        String s = "aa", t = "aa";
        String s1 = code76.minWindow(s, t);
        System.out.println(s1);

    }
}
