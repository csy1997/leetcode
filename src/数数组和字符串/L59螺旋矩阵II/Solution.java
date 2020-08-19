package 数数组和字符串.L59螺旋矩阵II;

public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int num = 1;
        for (int i = 0; i < (n + 1) / 2; i++) {
            for (int j = i; j < n - i; j++) {
                res[i][j] = num;
                num++;
            }
            for (int j = i + 1; j < n - i; j++) {
                res[j][n - 1 - i] = num;
                num++;
            }
            for (int j = i + 1; j < n - i; j++) {
                res[n - 1 - i][n - 1 - j] = num;
                num++;
            }
            for (int j = i + 1; j < n - i - 1; j++) {
                res[n - 1 - j][i] = num;
                num++;
            }
        }
        return res;
    }
}
