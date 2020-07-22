package com.lunx.leetcode;

/**
 * @author desong.xie
 * @version 1.0
 * @date 2020/07/22
 * @description
 */
public class Code67 {
    public String addBinary(String a, String b) {
        if (a.length() < b.length()) {
            String temp = a;
            a = b;
            b = temp;
        }

        int lengthA = a.length();
        int lengthB = b.length();
        boolean carryFlag = false;

        char[] charsA = a.toCharArray();
        char[] charsB = b.toCharArray();

        while (--lengthB >= 0) {
            lengthA--;

            int count = 0;
            if (charsB[lengthB] == '1') {
                count++;
            }
            if (charsA[lengthA] == '1') {
                count++;
            }
            if (carryFlag) {
                count++;
            }

            if (count == 0) {
//                carryFlag = false;
                continue;
            } else if (count == 1) {
                charsA[lengthA] = '1';
                carryFlag = false;
            } else if (count == 2) {
                charsA[lengthA] = '0';
                carryFlag = true;
            } else if (count == 3) {
                charsA[lengthA] = '1';
                carryFlag = true;
            }
        }

        while (carryFlag) {
            if (--lengthA < 0) {
                break;
            }

            int count = 0;
            if (charsA[lengthA] == '1') {
                count++;
            }
            if (carryFlag) {
                count++;
            }

            if (count == 0) {
//                carryFlag = false;
                continue;
            } else if (count == 1) {
                charsA[lengthA] = '1';
                carryFlag = false;
            } else if (count == 2) {
                charsA[lengthA] = '0';
                carryFlag = true;
            }
        }

        return carryFlag ? "1" + String.valueOf(charsA) : String.valueOf(charsA);
    }

    public static void main(String[] args) {
        String a = "461321561";
        char[] chars = a.toCharArray();
        System.out.println(String.valueOf(chars));
    }
}
