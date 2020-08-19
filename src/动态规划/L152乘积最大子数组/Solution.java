package 动态规划.L152乘积最大子数组;

public class Solution {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE, imax = 1, imin = 1;
        for (int num : nums) {
            if (num < 0) {//当前数为负，则imax和imin符号互换，最大最小翻转
                int tmp = imax;
                imax = imin;
                imin = tmp;
            }
            imax = Math.max(imax * num, num);//记录到当前为止连续数积最大值
            imin = Math.min(imin * num, num);//记录到当前为止连续数积最小值

            max = Math.max(max, imax);
        }
        return max;
    }
}
