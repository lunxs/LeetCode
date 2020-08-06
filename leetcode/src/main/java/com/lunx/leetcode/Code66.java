package com.lunx.leetcode;

import com.google.gson.Gson;

/**
 * @author desong.xie
 * @version 1.0
 * @date 2020/07/22
 * @description
 */
public class Code66 {
    public int[] plusOne(int[] digits) {
        int i = digits.length;
        while (--i >= 0) {
            if (digits[i] < 9) {
                digits[i] += 1;
                return digits;
            }
            digits[i] = 0;
        }

        int[] newDigits = new int[digits.length + 1];
        newDigits[0] = 1;
        return newDigits;
    }

    public int[] plusOne1(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i] += 1;
                return digits;
            }
            digits[i] = 0;
        }

        int[] newDigits = new int[digits.length + 1];
        newDigits[0] = 1;
        return newDigits;
    }

    public static void main(String[] args) {
        int[] digits = {9,9};

        Code66 code66 = new Code66();
        int[] ints = code66.plusOne1(digits);
        System.out.println(new Gson().toJson(ints));
    }
}
