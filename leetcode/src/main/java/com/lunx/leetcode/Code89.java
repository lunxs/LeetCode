package com.lunx.leetcode;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lunx
 * @version 1.0
 * @date 2021/04/07
 * @description
 */
public class Code89 {

    /**
     * 递归实现，当n
     * @param n
     * @return
     */
    public List<Integer> grayCode(int n) {
        if (n >= 31) throw new IllegalArgumentException("integer number too large");

        List<Integer> result = new ArrayList<>(1 << n);
        if (n < 1) {
            result.add(0);
            return result;
        }

        int[] ns = new int[n];
        this.grayCode(result, ns, n);

        return result;
    }

    private void grayCode(List<Integer> result, int[] ns, int index) {
        index--;
        if (index < 1) {
            result.add(getNum(ns));
            ns[0] = ns[0] ^ 1;
            result.add(getNum(ns));
            return;
        }

        this.grayCode(result, ns, index);
        ns[index] = 1 ^ ns[index];
        this.grayCode(result, ns, index);
    }

    private int getNum(int[] ns) {
        int result = 0;
        for (int i = 0; i < ns.length; i++) {
            result += (ns[i] << i);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(1 << 30);

        Code89 code89 = new Code89();

        List<Integer> integerList = code89.grayCode(28);
        System.out.println(integerList);

    }
}
