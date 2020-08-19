package 动态规划.L123买卖股票的最佳时机III;

public class Solution1 {
    public int maxProfit(int[] prices) {
        int k = 2;
        //第一维表示天数，二维表示最多买卖股票次数（已卖出为准），三维表示当前持有股票与否，数组值代表当前情况最大利润
        int[][][] dp = new int[prices.length+1][k+1][2];
        for (int j = 0; j < dp[0].length; j++) {
            dp[0][j][0] = 0;//第0天未买入股票，利润0
            dp[0][j][1] = Integer.MIN_VALUE;//第0天买入股票，不可能情况设为负无穷
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                //第i天最多卖出j次且当前未持有股票的最大利润 = max(前一天同样未持有股票今天不买的利润，前一天持有股票今天卖出j-1+1次的利润)
                dp[i][j][0] = Math.max(dp[i-1][j][0], j == 0 ? Integer.MIN_VALUE : dp[i-1][j-1][1] + prices[i-1]);//且当j=0时前一天不可能持有股票，只存在第一种情况
                //第i天最多卖出j次且当前持有股票的最大利润 = max(前一天未持有股票今天买入股票的利润，前一天同样持有股票今天不卖的利润)
                dp[i][j][1] = Math.max(dp[i-1][j][0] - prices[i-1], dp[i-1][j][1]);
            }
        }
        return dp[prices.length][k][0];
    }

    public static void main(String[] args) {
        Solution1 sol = new Solution1();
        int[] prices = {7,6,4,3,1};
        System.out.println(sol.maxProfit(prices));
    }
}
