package com.lunx.leetcode;

/**
 * @author XieDesong
 * @version 1.0
 * @title Code36
 * @description
 * @date 2019/07/08
 */
public class Code36 {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                if (board[j][i] == '.') {
                    continue;
                }

                if (!validLine(board, j, i) || !validSquare(board, j, i)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean validLine(char[][] board, int across, int vertical) {
        char target = board[across][vertical];

        // 验证横
        for (int i = vertical + 1; i < 9; i++) {
            if (target == board[across][i]) {
                return false;
            }
        }

        // 验证竖
        for (int i = across + 1; i < 9; i++) {
            if (target == board[i][vertical]) {
                return false;
            }
        }

        return true;
    }

    private boolean validSquare(char[][] board, int across, int vertical) {
        int endAcross = endPoint(across);
        int endVertical = endPoint(vertical);

        char target = board[across][vertical];
        for (int i = endAcross - 3; i < endAcross; i++) {
            for (int j = endVertical - 3; j < endVertical; j++) {
                if (board[i][j] == target && (i != across || j != vertical)) {
                    return false;
                }
            }
        }

        return true;
    }

    private int endPoint(int i) {
        if (i <= 2) {
            return 3;
        } else if (3 <= i && i <= 5) {
            return 6;
        } else {
            return 9;
        }
    }

    public static void main(String[] args) {

    }
}
