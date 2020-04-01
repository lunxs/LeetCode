package com.lunx.leetcode;

/**
 * @author desong.xie
 * @version 1.0
 * @title Code43
 * @date 2020/01/14
 * @description
 */
public class Code43 {

    public String multiply(String num1, String num2) {
        char[] num1s = num1.toCharArray();
        char[] num2s = num2.toCharArray();

        int length1 = num1s.length;
        int length2 = num2s.length;

        int[] result = new int[length1 + length2];

        for (int index1 = 0; index1 < length1; index1++) {
            int nn1 = num1s[length1 - index1 - 1] - '0';
            int tempR = 0;
            for (int index2 = 0; index2 < length2; index2++) {
                int nn2 = num2s[length2 - index2 - 1] - '0';
                tempR = nn1 * nn2 + result[index1 + index2] + tempR;

                result[index1 + index2] = tempR % 10;
                tempR = tempR / 10;
            }

            int index = index1 + length2;
            while (tempR > 0) {
                tempR = result[index] + tempR;

                result[index] = tempR % 10;
                tempR = tempR / 10;
                index++;
            }
        }

        StringBuilder sb = new StringBuilder();
        int index = result.length - 1;
        while (result[index] == 0 && index > 0) {
            index--;
        }

        for (; index >= 0; index--) {
            sb.append(result[index]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Code43 code43 = new Code43();

        String n1 = "99999";
        String n2 = "8888";
        String multiply = code43.multiply(n1, n2);
        System.out.println(multiply);

        int nn1 = Integer.parseInt(n1);
        int nn2 = Integer.parseInt(n2);
        System.out.println(nn1 * nn2);

    }
}
