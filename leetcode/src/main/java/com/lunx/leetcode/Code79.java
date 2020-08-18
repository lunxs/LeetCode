package com.lunx.leetcode;

import java.util.*;

/**
 * @author desong.xie
 * @version 1.0
 * @date 2020/08/17
 * @description
 */
public class Code79 {

    private static Integer START = 0;
    private static Integer UP = 1;
    private static Integer RIGHT = 2;
    private static Integer DOWN = 3;
    private static Integer LEFT = 4;

    public boolean exist(char[][] board, String word) {
        int rowLength = board.length;
        if (rowLength < 0) return false;
        int colLength = board[0].length;

        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean exist = exist(board, word, i, j);
                    if (exist) return true;
                }
            }
        }

        return false;
    }

    public boolean exist(char[][] board, String word, int row, int col) {
        LinkedList<String> list = new LinkedList<>();
        Map<String, Integer> map = new HashMap<>();

        list.add(genKey(row, col));
        map.put(genKey(row, col), START);

        int rowLength = board.length;
        if (rowLength < 0) return false;
        int colLength = board[0].length;

        int direction = START;

        for (int i = 1; i < word.length(); i++) {
            // up
            if (row - 1 >= 0 && board[row - 1][col] == word.charAt(i) && null == map.get(genKey(row - 1, col)) && direction < UP) {
                row--;
                list.add(genKey(row, col));
                map.put(genKey(row, col), UP);

                direction = START;
                continue;
            }
            // right
            if (col + 1 < colLength && board[row][col + 1] == word.charAt(i) && null == map.get(genKey(row, col + 1)) && direction < RIGHT) {
                col++;
                list.add(genKey(row, col));
                map.put(genKey(row, col), RIGHT);

                direction = START;
                continue;
            }
            // down
            if (row + 1 < rowLength && board[row + 1][col] == word.charAt(i) && null == map.get(genKey(row + 1, col)) && direction < DOWN) {
                row++;
                list.add(genKey(row, col));
                map.put(genKey(row, col), DOWN);

                direction = START;
                continue;
            }
            // left
            if (col - 1 >= 0 && board[row][col - 1] == word.charAt(i) && null == map.get(genKey(row, col - 1)) && direction < LEFT) {
                col--;
                list.add(genKey(row, col));
                map.put(genKey(row, col), LEFT);

                direction = START;
                continue;
            }

            while (list.size() > 0) {
                String lastKey = list.removeLast();
                direction = map.remove(lastKey);
                i--;

                if (direction == START) return false;
                if (direction == LEFT) continue;

                String[] split = list.peekLast().split(",");
                row = Integer.parseInt(split[0]);
                col = Integer.parseInt(split[1]);
                break;
            }
            i--;
        }

        return true;
    }

    private static String genKey(int row, int col) {
        return row + "," + col;
    }


    public static void main(String[] args) {
        Code79 code79 = new Code79();

        char[][] board = {{'A','B','C','C','E'},{'S','F','S','S','F'},{'A','D','E','E','F'}};
        String word = "ABCCED";

        boolean exist = code79.exist(board, word);
        System.out.println(exist);
    }
}
