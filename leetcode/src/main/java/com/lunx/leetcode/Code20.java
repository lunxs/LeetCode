package com.lunx.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author XieDesong
 * @version 1.0
 * @title Code20
 * @description
 * @date 2019/04/22
 */
public class Code20 {

    // (   )  [  ]  {    }
    // 40 41  91 93 123 125

    private boolean isLeft(char c) {
        return c == 40 || c == 91 || c == 123;
    }

    private boolean checkRight(char c, char pop) {
        return pop == 40 && c == 41 || pop == 91 && c == 93 || pop == 123 && c == 125;
    }

    public boolean isValid(String s) {
        final List<Character> symbol = new ArrayList<>();
        char[] chars = s.toCharArray();

        for (char c : chars) {
            if (isLeft(c)) {
                symbol.add(c);
                continue;
            }

            char pop = symbol.size() == 0 ? 0 : symbol.remove(symbol.size() - 1);

            if (!checkRight(c, pop))
                return false;
        }

        return symbol.isEmpty();
    }

    public static void main(String[] args) {
        String s = "{[]}";

        Code20 code20 = new Code20();
        System.out.println(code20.isValid(s));
    }
}
