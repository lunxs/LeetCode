package com.lunx.leetcode;

public class Code38 {
    public String countAndSay(int n) {
        StringBuilder sb = new StringBuilder("1");
        StringBuilder temp;
        char say;
        int count;
        for (int i = 1; i < n; i++) {
            temp = new StringBuilder();
            say = sb.charAt(0);
            count = 1;
            for (int j = 1, length = sb.length(); j < length; j++) {
                if (sb.charAt(j) != say) {
                    temp.append(count).append(say);
                    count = 1;
                    say = sb.charAt(j);
                } else {
                    count++;
                }
            }

            temp.append(count).append(say);
            sb = temp;
        }

        return sb.toString();
    }


    public static void main(String[] args) {
        Code38 c = new Code38();
        System.out.println(c.countAndSay(6));
    }
}
