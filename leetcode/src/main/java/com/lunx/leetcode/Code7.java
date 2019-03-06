package com.lunx.leetcode;

/**
 * @author XieDesong
 * @version 1.0
 * @title Code7
 * @description
 * @date 2019/03/05
 * Coffee Box 连咖啡
 */
public class Code7 {

    public int reverse(int x) {
        boolean flag = true;
        if (x < 0) {
            x = Math.abs(x);
            flag = false;
        }

        char[] chars = String.valueOf(x).toCharArray();
        StringBuffer sb = new StringBuffer();
        for (int i = chars.length - 1; i >= 0; i--) {
            sb.append(chars[i]);
        }

        try {
            int b = Integer.parseInt(sb.toString());

            return flag ? b : -b;
        } catch (Exception e) {
            return 0;
        }
    }

    public int first(int x) {
        boolean flag = true;
        if (x < 0) {
            x = Math.abs(x);
            flag = false;
        }

        int y = 0;
        int b;
        while (x != 0) {
            b = x % 10;
            if((y>Integer.MAX_VALUE/10)||(y==Integer.MAX_VALUE/10 && b>Integer.MAX_VALUE-y*10))
            return 0;
            if((y<Integer.MIN_VALUE/10)||(y==Integer.MIN_VALUE/10 && b<Integer.MIN_VALUE-y*10))
            return 0;
            y = y * 10 + b;
            x = x / 10;
        }

        return flag ? y : -y;
    }

    private int second(int x) {
        int j;
        int y = 0;

        while (x != 0) {
            j = x % 10;

            if((y>Integer.MAX_VALUE/10)||(y==Integer.MAX_VALUE/10 && j>Integer.MAX_VALUE-y*10)) return 0;
            if((y<Integer.MIN_VALUE/10)||(y==Integer.MIN_VALUE/10 && j<Integer.MIN_VALUE-y*10)) return 0;

            y = y * 10 + j;
            x = x / 10;
        }
        return y;
    }

    public static void main(String[] args) {
        Code7 code7 = new Code7();
        System.out.println(Integer.MAX_VALUE);
        System.out.println(code7.first(568458));

        System.out.println(Integer.MAX_VALUE * 2);
    }
}
