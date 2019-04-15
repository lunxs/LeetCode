package com.lunx.leetcode;

/**
 * @author XieDesong
 * @version 1.0
 * @title Code14
 * @description
 * @date 2019/04/03
 */
public class Code14 {

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        if (strs.length == 1) return strs[0];

        char[] chars = strs[0].toCharArray();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < chars.length; i++) {
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || chars[i] != strs[j].charAt(i)) {
                    return sb.toString();
                }
            }

            sb.append(chars[i]);
        }

        return sb.toString();
    }

    public static void main(String[] args) {

        String[] ss = {"flower","flow","flight"};
        Code14 code14 = new Code14();
        System.out.println(code14.longestCommonPrefix(ss));
    }
}
