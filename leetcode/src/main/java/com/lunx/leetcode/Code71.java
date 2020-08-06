package com.lunx.leetcode;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.StringStack;

import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author desong.xie
 * @version 1.0
 * @date 2020/07/24
 * @description
 */
public class Code71 {
    public String simplifyPath(String path) {
        Stack<String> ss = new Stack();

        char[] chars = path.toCharArray();
        int i = -1, length = chars.length;

        while (++i < length) {
            if (chars[i] == '/') continue;

            if (chars[i] == '.') {
                if (i + 2 < length && chars[i + 1] == '.' && chars[i + 2] == '/') {
                    if (ss.size() > 0) ss.pop();
                    i += 2;
                    continue;
                }
                if (i + 2 == length && chars[i + 1] == '.') {
                    if (ss.size() > 0) ss.pop();
                    i++;
                    continue;
                }
                if (i + 1 == length || (i + 1 < length && chars[i + 1] == '/')) continue;
            }

            StringBuilder sb = new StringBuilder();
            while (i < length && chars[i] != '/') {
                sb.append(chars[i]);
                i++;
            }
            ss.push(sb.toString());
        }

        int j = ss.size();
        if (j == 0) return "/";

        StringBuilder result = new StringBuilder();
        while (--j >= 0) {
            result.insert(0, ss.pop()).insert(0, '/');
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Code71 code71 = new Code71();

        // /a/b/c
        String path = "/a/./b/../../c/";
        String s = code71.simplifyPath(path);
        System.out.println(s);

    }
}
