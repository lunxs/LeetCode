package com.lunx.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author desong.xie
 * @version 1.0
 * @date 2020/07/16
 * @description
 */
public class Code60 {

    public String getPermutation(int n, int k) {
        StringBuilder result = new StringBuilder();

        List<Integer> nList = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            nList.add(i);
        }

        int temp = 0;
        while (--n > 0) {
            int factorial = factorial(n);
            temp = k / factorial;
            k = k % factorial;

            if (k == 0) {
                result.append(nList.get(temp - 1));
                nList.remove(temp - 1);
                k = factorial;
            } else {
                result.append(nList.get(temp));
                nList.remove(temp);
            }
        }

        return result.append(nList.get(0)).toString();
    }

    private static int factorial(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
        Code60 code60 = new Code60();
        int n = 6;
        int factorial = factorial(n);
        System.out.println(factorial);

        for (int i = 1; i <= factorial; i++) {
            String permutation = code60.getPermutation(n, i);
            System.out.println(i + ":" + permutation);
        }

    }

}
