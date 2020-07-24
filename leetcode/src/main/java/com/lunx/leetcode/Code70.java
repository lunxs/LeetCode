package com.lunx.leetcode;

/**
 * @author desong.xie
 * @version 1.0
 * @date 2020/07/24
 * @description
 */
public class Code70 {
    /**
     * 当n增大时，栈深，时间成本过大
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    private int climbStairs1(int n) {
        int k0 = 0, k1 = 1;
        int temp = 0;
        for (int i = 1; i < n; i++) {
            temp = k1;
            k1 += k0;
            k0 = temp;
        }

        return k0 + k1;
    }

    public static void main(String[] args) {
        Code70 code70 = new Code70();

        // 512559680
//        int i = code70.climbStairs(47);
        int test = code70.climbStairs1(48);
        System.out.println(test);
    }

}
