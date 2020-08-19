package 动态规划.L123买卖股票的最佳时机III;

import java.util.Arrays;

public class Solution2 {
    private int[] prices;
    private Integer[][][] dp;

    public int maxProfit(int[] prices) {
        this.prices = prices;
        int k = 2;
        //dp一维代表天数，二维代表买卖次数(1为买入一次，2为卖出一次，3为买入2次。。以此类推)，数组值代表最大价值
        this.dp = new Integer[prices.length+1][k+1][2];
        return getMaxProfitSold(prices.length, k);
    }

    public int getMaxProfitSold(int i, int j) {
        if(i == -1) {//第0天利润为0
            return 0;
        }
        if(dp[i][j][0] != null) {
            return dp[i][j][0];
        }
        if(j == 0) {
            dp[i][j][0] = 0;
        } else {
            dp[i][j][0] = Math.max(getMaxProfitSold(i-1, j), getMaxProfitBought(i-1, j-1) + prices[i]);
        }
        return dp[i][j][0];
    }

    public int getMaxProfitBought(int i, int j) {
        if(i == -1) {//第0天不可能持有股票
            return Integer.MIN_VALUE;
        }
        if(dp[i][j][1] != null) {
            return dp[i][j][1];
        }
        dp[i][j][1] = Math.max(getMaxProfitSold(i-1, j) - prices[i], getMaxProfitBought(i-1, j));
        return dp[i][j][1];
    }

    public static void main(String[] args) {
        Solution2 sol = new Solution2();
        int[] prices = {7,6,4,3,1};
        System.out.println(sol.maxProfit(prices));
        System.out.println(Arrays.deepToString(sol.dp));
    }
}
