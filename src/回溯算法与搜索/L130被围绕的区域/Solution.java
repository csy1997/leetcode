package 回溯算法与搜索.L130被围绕的区域;

public class Solution {
    public void solve(char[][] board) {
        int l = board.length;
        if (l == 0) {
            return;
        }
        int w = board[0].length;
        //从board边缘开始，深度搜索将相邻的'O'转为'Y'，此部分'O'不被'X'所围
        for (int i = 0; i < w; i++) {
            replace(board, 0, i);
        }
        for (int i = 0; i < w; i++) {
            replace(board, l - 1, i);
        }
        for (int i = 0; i < l; i++) {
            replace(board, i, 0);
        }
        for (int i = 0; i < l; i++) {
            replace(board, i, w - 1);
        }
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < w; j++) {
                if (board[i][j] == 'Y') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {//其他'O'即为被'X'围绕的
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void replace(char[][] board, int i, int j) {
        int l = board.length;
        int w = board[0].length;
        if (i < 0 || i >= l || j < 0 || j >= w) {
            return;
        }
        if (board[i][j] == 'X' || board[i][j] == 'Y') {
            return;
        }
        board[i][j] = 'Y';
        replace(board, i - 1, j);
        replace(board, i + 1, j);
        replace(board, i, j - 1);
        replace(board, i, j + 1);
    }
}
