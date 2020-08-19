package 动态规划.L121买卖股票的最佳时机;

public class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        int p = Integer.MAX_VALUE;
        for (int x : prices) {
            if (x < p) {//比下界小就更新下界，否则当前x之前的最大差值必定以p为下界
                p = x;
            } else {
                max = Math.max(max, x - p);
            }
        }
        return max;
    }
}
