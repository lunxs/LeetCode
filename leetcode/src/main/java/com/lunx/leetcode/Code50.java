package com.lunx.leetcode;

/**
 * @author desong.xie
 * @version 1.0
 * @title Code49
 * @date 2020/04/03
 * @description
 */
public class Code50 {

    public double myPow(double x, int n) {

        double recursion = recursion(x, Math.abs((long) n));

        return n < 0 ? 1 / recursion : recursion;
    }

    private double recursion(double x, long n) {
        if (n == 0) return 1;
        if (n == 1) return x;

        while (n > 1) {
            // even
            if ((n & 1) != 0) break;
            x *= x;
            n = (n >> 1);
        }

        // odd
        return x * recursion(x * x, (n - 1) / 2);
    }


    private double recursion1(double x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x;

        if ((n & 1) == 0) {
            // even
            return recursion1(x * x, n / 2);
        } else {
            // odd
            return x * recursion1(x * x, (n - 1) / 2);
        }
    }

    private double recursion2(double x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x;

        double result = 1;
        for (int i = 0; i < n; i++) {
            result *= x;
        }

        return result;
    }


    public static void main(String[] args) {
        Code50 code49 = new Code50();
//                -2147483648
        double v = code49.myPow(-1, -2147483648);

        System.out.println(v);

    }
}
