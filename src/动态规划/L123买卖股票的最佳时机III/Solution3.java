package 动态规划.L123买卖股票的最佳时机III;

import java.util.Arrays;

public class Solution3 {
    private int[] prices;
    private Integer[][] dp;

    public int maxProfit(int[] prices) {
        this.prices = prices;
        int k = 2;
        //dp一维代表天数，二维代表最大买卖次数(1为买入一次，2为卖出一次，3为买入2次。。以此类推)，数组值代表最大价值
        this.dp = new Integer[prices.length][2*k];
        return getMaxProfit(prices.length-1, 2*k-1);
    }

    public int getMaxProfit(int i, int j) {
        if(i == -1) {//第0天利润为0
            return 0;
        }
        if(j == -1) {//买卖0次，利润为0
            return 0;
        }
        if(dp[i][j] != null) {
            return dp[i][j];
        }
        if(j % 2 == 1) {
            //第i天状态为买卖一共j次且最后一次为卖出的最大利润 =
            //max(第i-1天同样买卖j次即第i天不作为的利润，第i-1天买卖j-1次即第i天卖股票的利润)
            dp[i][j] = Math.max(getMaxProfit(i-1, j), getMaxProfit(i-1, j-1) + prices[i]);
        } else {
            //第i天状态为买卖一共j次且最后一次为买入的最大利润 =
            //max(第i-1天同样买卖j次即第i天不作为的利润，第i-1天买卖j-1次即第i天买股票的利润)
            dp[i][j] = Math.max(getMaxProfit(i-1, j), getMaxProfit(i-1, j-1) - prices[i]);
        }
        return dp[i][j];
    }

    public static void main(String[] args) {
        Solution3 sol = new Solution3();
        int[] prices = {7,6,4,3,1};
        System.out.println(sol.maxProfit(prices));
        System.out.println(Arrays.deepToString(sol.dp));
    }
}
