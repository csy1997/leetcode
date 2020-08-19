package 分治法.L74搜索二维矩阵;

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int l = matrix.length;
        if (l == 0) {
            return false;
        }
        int w = matrix[0].length;
        int left1 = 0;
        int left2 = 0;
        int right1 = l - 1;
        int right2 = w - 1;
        while (left1 < right1 || (left1 == right1 && left2 <= right2)) {//将二维矩阵看做一维数组
            int temp = (right1 * w + right2 + left1 * w + left2) / 2;
            int mid1 = temp / w;
            int mid2 = temp % w;
            if (target > matrix[mid1][mid2]) {
                left1 = (temp + 1) / w;
                left2 = (temp + 1) % w;
            } else if (target < matrix[mid1][mid2]) {
                right1 = (temp - 1) / w;
                right2 = (temp - 1) % w;
            } else {
                return true;
            }
        }
        return false;
    }
}
