package com.lunx.leetcode;

/**
 * @author desong.xie
 * @version 1.0
 * @date 2020/07/16
 * @description
 */
public class Code58 {
    public int lengthOfLastWord(String s) {
        int i = s.length();
        while (--i >= 0 && ' ' == s.charAt(i));
        int end = i;
        while (i >= 0) {
            if (' ' == s.charAt(i)) {
                return end - i;
            }
            i--;
        }
        return end + 1;
    }

    public int lengthOfLastWord1(String s) {
        int end = s.length();
        boolean flag = false;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (' ' == s.charAt(i)) {
                if (flag) return end - i - 1;
                end = i;
                continue;
            }

            flag = true;
        }

        return end;
    }

    public int lengthOfLastWord2(String s) {
        int len = 0;
        boolean ifLast = false;
        for(int i = s.length() - 1; i >= 0; i--){
            if(s.charAt(i) == ' '){
                if(ifLast) break;
                continue;
            }

            len++;
            ifLast = true;
        }
        return len;
    }

    public static void main(String[] args) {
        String s = "a";
        int length = new Code58().lengthOfLastWord1(s);
        System.out.println(length);
    }
}
