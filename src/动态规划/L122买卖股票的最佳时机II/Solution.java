package 动态规划.L122买卖股票的最佳时机II;

public class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        int p = Integer.MAX_VALUE;
        for (int x : prices) {//只叠加单调递增的部分
            if (x > p) {
                max += x - p;
            }
            p = x;
        }
        return max;
    }
}
