package 回溯算法与搜索.L79单词搜索;

import java.util.Arrays;

public class Solution {
    private boolean res;
    private boolean[][] isUsed;
    private int[] directions;//偏移量数组方便在循环中选各个方向的位置

    public boolean exist(char[][] board, String word) {
        this.res = false;
        this.isUsed = new boolean[board.length][board[0].length];
        this.directions = new int[]{0, 1, 0, -1, 0};
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    isUsed[i][j] = true;
                    addToList(i, j, 1, board, word);
                    if (res) {
                        return true;
                    }
                    isUsed[i][j] = false;
                }
            }
        }
        return false;
    }

    public void addToList(int x, int y, int i, char[][] board, String word) {
        if (i == word.length()) {
            this.res = true;
            return;
        }
        for (int j = 0; j < directions.length - 1; j++) {
            int nextX = x + directions[j];
            int nextY = y + directions[j + 1];
            if (nextX >= 0 && nextX < board.length && nextY >= 0 && nextY < board[0].length) {
                if (!isUsed[nextX][nextY] && board[nextX][nextY] == word.charAt(i)) {
                    isUsed[nextX][nextY] = true;
                    addToList(nextX, nextY, i + 1, board, word);
                    if (res) {
                        return;
                    }
                    isUsed[nextX][nextY] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        char[][] board = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        String word = "ABCCED";
        System.out.println(sol.exist(board, word));
        System.out.println(Arrays.deepToString(board));
        System.out.println(Arrays.deepToString(sol.isUsed));
    }
}
