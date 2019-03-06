package com.lunx.leetcode;

/**
 * @author XieDesong
 * @version 1.0
 * @title Code6
 * @description
 * @date 2019/03/05
 * Coffee Box 连咖啡
 */
public class Code6 {

    public String convert(String s, int numRows) {
        char[] chars = s.toCharArray();
        int length = chars.length;

        if (numRows <= 1) return s;

        int row = numRows - 1;
        int jlength = length / row / 2 + 1;
        String result = "";
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j <= jlength; j++) {
                int index = i + j * row * 2;
                if (i == 0 || i == row) {
                    if (index < length) {
                        result += chars[index];
                    }
                } else {
                    if ((index - 2 * i) > 0 && (index - 2 * i) < length) {
                        result += chars[index - 2 * i];
                    }
                    if (index < length) {
                        result += chars[index];
                    }
                }
            }
        }

        return result;
    }

    public String first(String s, int numRows) {
        char[] chars = s.toCharArray();
        int length = chars.length;

        if (numRows <= 1) return s;

        int row = numRows - 1;
        int jLength = (length / row >> 1) + 1;
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j <= jLength; j++) {
                int index = i + (j * row << 1);
                if (i == 0 || i == row) {
                    if (index < length) {
                        out.append(chars[index]);
                    }
                } else {
                    if ((index - (i << 1)) > 0 && (index - (i << 1)) < length) {
                        out.append(chars[index - (i << 1)]);
                    }
                    if (index < length) {
                        out.append(chars[index]);
                    }
                }
            }
        }

        return out.toString();
    }

    public static void main(String[] args) {
        Code6 code6 = new Code6();
        String input = "PAYPALISHIRING";
        System.out.println(input.length());
        String str = code6.convert(input, 5);
        System.out.println(str.length());
        System.out.println(str);


    }
}
