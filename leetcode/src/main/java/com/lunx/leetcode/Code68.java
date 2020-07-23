package com.lunx.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author desong.xie
 * @version 1.0
 * @date 2020/07/23
 * @description
 */
public class Code68 {

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();

        int wordLength = 0;
        int start = 0;

        for (int i = 0; i < words.length; i++) {
            wordLength += (words[i].length() + 1);

            if (wordLength > maxWidth + 1) {
                String row = fullJustify(words, maxWidth, (wordLength - words[i].length() - 2), start, (i - 1));
                result.add(row);

                wordLength = words[i].length() + 1;
                start = i;
            } else if (wordLength == maxWidth + 1) {
                String row = fullJustify(words, maxWidth, (wordLength - 1), start, i);
                result.add(row);

                wordLength = 0;
                start = i + 1;
            }

        }

        // 考虑尾部
        if (start == words.length) {
            return result;
        }

        StringBuilder endSb = new StringBuilder();
        for (; start < words.length - 1; start++) {
            endSb.append(words[start]).append(' ');
        }
        result.add(endSb.append(words[start]).append(spaceX(maxWidth - endSb.length())).toString());

        return result;
    }

    private String fullJustify(String[] words, int maxWidth, int wordLength, int start, int end) {
        int interval = end - start;
        int spaceNums = maxWidth - wordLength + interval;

        if (interval == 0) return words[start] + spaceX(spaceNums);

        StringBuilder sb = new StringBuilder();
        int perSpaceNum = spaceNums / interval;
        int extraSpaceNum = spaceNums % interval;

        String perSpace = spaceX(perSpaceNum);
        for (; start < end; start++) {
            sb.append(words[start]);
            if (interval - end + start < extraSpaceNum) {
                sb.append(perSpace).append(' ');
            } else {
                sb.append(perSpace);
            }
        }

        return sb.append(words[end]).toString();
    }

    private String spaceX(int nums) {
        StringBuilder sb = new StringBuilder();
        while (--nums >= 0) {
            sb.append(' ');
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Code68 code68 = new Code68();

        String[] words = {"text","justification."};
        int maxWidth = 14;

        List<String> stringList = code68.fullJustify(words, maxWidth);

        for (String s : stringList) {
            System.out.println(s + ":" + s.length());
        }

    }

}
