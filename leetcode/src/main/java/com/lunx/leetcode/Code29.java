package com.lunx.leetcode;

/**
 * @author XieDesong
 * @version 1.0
 * @title Code29
 * @description
 * @date 2019/05/16
 */
public class Code29 {
    public int divide(int dividend, int divisor) {
        boolean flag = true;
        if (dividend > 0) {
            flag = !flag;
            dividend = -dividend;
        }
        if (divisor > 0) {
            flag = !flag;
            divisor = -divisor;
        }

        int result = di(dividend, divisor);

        if (result == Integer.MIN_VALUE)
            return flag ? Integer.MAX_VALUE : result;
        return flag ? -result : result;
    }

    private int di(int dd, int dr) {
        if (dd > dr) return 0;

        int result = -1;
        int temp = dr;
        while ((dd - temp) <= temp) {
            temp += temp;
            result += result;
        }

        return result + di(dd - temp, dr);
    }

    public static void main(String[] args) {
        Code29 code29 = new Code29();

        int dividend = -2147483648;
        int divisor = 1;
        System.out.println(code29.divide(dividend, divisor));
    }
}
