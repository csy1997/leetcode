package 数数组和字符串.L48旋转图像;

public class Solution {
    public void rotate(int[][] matrix) {
        int l = matrix.length;
        for (int i = 0; i < l / 2; i++) {
            for (int j = i; j < l - i - 1; j++) {
                int temp = matrix[j][i];
                matrix[j][i] = matrix[l - 1 - i][j];//左=下
                matrix[l - 1 - i][j] = matrix[l - 1 - j][l - 1 - i];//下=右
                matrix[l - 1 - j][l - 1 - i] = matrix[i][l - 1 - j];//右=上
                matrix[i][l - 1 - j] = temp;//上=左
            }
        }
    }
}
