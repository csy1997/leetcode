package 数数组和字符串.L54螺旋矩阵;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        int l = matrix.length;
        if (l == 0) {
            return res;
        }
        int w = matrix[0].length;
        int min = Math.min(l, w);
        for (int i = 0; i < (min + 1) / 2; i++) {
            for (int j = i; j < w - i; j++) {
                res.add(matrix[i][j]);
            }
            for (int j = i + 1; j < l - i; j++) {
                res.add(matrix[j][w - 1 - i]);
            }
            if (i == min / 2) {//如果最后最后一圈只有一行或者一列，那么只需遍历一半
                break;
            }
            for (int j = i + 1; j < w - i; j++) {
                res.add(matrix[l - 1 - i][w - 1 - j]);
            }
            for (int j = i + 1; j < l - i - 1; j++) {
                res.add(matrix[l - 1 - j][i]);
            }
        }
        return res;
    }
}
