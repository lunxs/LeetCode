package com.lunx.leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author XieDesong
 * @version 1.0
 * @title Code17
 * @description
 * @date 2019/04/15
 */
public class Code17 {

    // first method is use enum
    enum PhoneNum {
        TWO('2', Arrays.asList("a","b","c")),
        THREE('3', Arrays.asList("d","e","f")),
        FOUR('4', Arrays.asList("g","h","i")),
        FIVE('5', Arrays.asList("j","k","l")),
        SIX('6', Arrays.asList("m","n","o")),
        SEVEN('7', Arrays.asList("p","q","r", "s")),
        EIGHT('8', Arrays.asList("t","u","v")),
        NINE('9', Arrays.asList("w","x","y", "z"));

        private char num;
        private List<String> letter;

        PhoneNum(char num, List<String> letter) {
            this.num = num;
            this.letter = letter;
        }

        public char getNum() {
            return num;
        }

        public List<String> getLetter() {
            return letter;
        }

        public static PhoneNum getByNum(char num) {
            for (PhoneNum n : PhoneNum.values()) {
                if (n.getNum() == num) {
                    return n;
                }
            }

            return null;
        }
    }

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (null == digits || digits.length() < 1) {
            return result;
        }

        List<String> letterList = PhoneNum.getByNum(digits.charAt(0)).getLetter();
        result.addAll(letterList);

        for (int i = 1; i < digits.length(); i++) {
            List<String> letters = PhoneNum.getByNum(digits.charAt(i)).getLetter();
            result = result
                    .stream()
                    .flatMap(s -> letters.stream().map(l -> s + l))
                    .collect(Collectors.toList());
        }

        return result;
    }

    // second method is use map
    private static final Map<Character, List<String>> PhoneMap = new HashMap<>(8);
    static {
        PhoneMap.put('2', Arrays.asList("a","b","c"));
        PhoneMap.put('3', Arrays.asList("d","e","f"));
        PhoneMap.put('4', Arrays.asList("g","h","i"));
        PhoneMap.put('5', Arrays.asList("j","k","l"));
        PhoneMap.put('6', Arrays.asList("m","n","o"));
        PhoneMap.put('7', Arrays.asList("p","q","r", "s"));
        PhoneMap.put('8', Arrays.asList("t","u","v"));
        PhoneMap.put('9', Arrays.asList("w","x","y", "z"));
    }

    public List<String> letterCombinations1(String digits) {
        List<String> result = new ArrayList<>();
        if (null == digits || digits.length() < 1) {
            return result;
        }

        List<String> letterList = PhoneMap.get(digits.charAt(0));
        result.addAll(letterList);

        for (int i = 1; i < digits.length(); i++) {
            List<String> letters = PhoneMap.get(digits.charAt(i));
            result = result
                    .stream()
                    .flatMap(s -> letters.stream().map(l -> s + l))
                    .collect(Collectors.toList());
        }

        return result;
    }

    public static void main(String[] args) {
        Code17 code17 = new Code17();
        String digits = "";
        List<String> strings = code17.letterCombinations1(digits);

        strings.stream().forEach(System.out::println);

    }
}
