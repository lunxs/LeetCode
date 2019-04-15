package com.lunx.leetcode;

/**
 * @author XieDesong
 * @version 1.0
 * @title Code12
 * @description
 * @date 2019/04/03
 */
public class Code12 {
    public enum RomanNum {

        M("M", 1000),
        D("D", 500),
        C("C", 100),
        L("L", 50),
        X("X", 10),
        V("V", 5),
        I("I", 1);

        private String roman;

        private int num;

        RomanNum(String roman, int num) {
            this.roman = roman;
            this.num = num;
        }
    }

    public enum Special {
        CM("CM", 900, 100),
        CD("CD", 400, 100),
        XC("XC", 90, 10),
        XL("XL", 40, 10),
        IX("IX", 9, 1),
        IV("IV", 4, 1);

        private String roman;

        private int num;

        private int num1;

        Special(String roman, int num, int num1) {
            this.roman = roman;
            this.num = num;
            this.num1 = num1;
        }
    }

    public String intToRoman(int num) {
        if (num < 1 || num > 3999) {
            throw new IllegalArgumentException("input error");
        }

        StringBuffer sb = new StringBuffer();
        for (RomanNum r : RomanNum.values()) {
            for (Special s : Special.values()) {
                int sn = num / s.num;
                int sn1 = num / s.num1;
                if (sn == 1 && (sn1 == 4 || sn1 == 9)) {
                    sb.append(s.roman);
                    num -= s.num;
                }
            }

            int d = num / r.num;
            for (int i = 0; i < d; i++) {
                sb.append(r.roman);
            }
            num %= r.num;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Code12 code12 = new Code12();
        System.out.println(code12.intToRoman(1994));
    }
}
