package com.lunx.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author XieDesong
 * @version 1.0
 * @title Code9
 * @description
 * @date 2019/03/15
 */
public class Code9 {

    public boolean isPalindrome(int x) {
        if (x < 0) return false;

        List<Integer> sList = new ArrayList<>();
        while (x / 10 > 0) {
            sList.add(x % 10);
            x = x / 10;
        }
        sList.add(x % 10);

        for (int i = 0, j = sList.size() - 1; i < j; i++, j--) {
            if (!sList.get(i).equals(sList.get(j))) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Code9 code9 = new Code9();
        boolean palindrome = code9.isPalindrome(-121);
        System.out.println(palindrome);
    }
}
