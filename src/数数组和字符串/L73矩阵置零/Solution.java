package 数数组和字符串.L73矩阵置零;

import java.util.Arrays;

public class Solution {
    public void setZeroes(int[][] matrix) {
        int l = matrix.length;
        if (l == 0) {
            return;
        }
        int w = matrix[0].length;
        int temp = -1;
        //一轮遍历先将存在0的行列标记出来
        for (int x : matrix[0]) {
            if (x == 0) {//[0][0]只能标记第一行或第一列中的一个，所以用额外变量temp标记第一行
                temp = 0;
                break;
            }
        }
        for (int i = 1; i < l; i++) {
            for (int j = 0; j < w; j++) {
                if (matrix[i][j] == 0) {//第一行数组标记所有列情况，第一列不包括[0][0]标记第一行以外的行
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        //第二轮遍历根据标记更新
        for (int i = 1; i < l; i++) {
            for (int j = 1; j < w; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {//根据第一行和第一列标记，将除第一行第一列之外的位置更新
                    matrix[i][j] = 0;
                }
            }
        }
        if (matrix[0][0] == 0) {//根据[0][0]将第一列更新
            for (int i = 1; i < l; i++) {
                matrix[i][0] = 0;
            }
        }
        if (temp == 0) {//根据temp将第一行更新
            Arrays.fill(matrix[0], 0);
        }
    }
}
