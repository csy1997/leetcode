package 动态规划.背包问题.普通背包;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 迭代法
 */
public class Solution1 {
    int[][] dp;
    int[][] trace;
    int[] w;
    int[] v;

    public int getMaxValueInBag(int[] w, int[] v, int W) {
        if(w.length == 0) {
            return 0;
        }
        this.w = w;
        this.v = v;
        dp = new int[w.length+1][W+1];
        trace = new int[w.length][W+1];
        for(int[] t : trace) {
            Arrays.fill(t, -1);
        }
        //第一列为0体积背包装的情况，价值全为0
//        for (int i = 0; i < dp.length; i++) {
//            dp[i][0] = 0;
//        }
        //第一行为不装任何物品情况，价值全为0
//        for (int i = 1; i < dp[0].length; i++) {
//            dp[0][i] = 0;
//        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = dp[i-1][j];
                int temp;
                //dp第i行考虑是否装第i-1个物品的情况
                if(j >= w[i-1] && (temp = (dp[i][j - w[i-1]] + v[i-1])) > dp[i][j]) {
                    //max(不选当前物品i-1，总重量j不变)(选当前物品，总重量j减去当前物品重量w[i-1]，且w[i-1]不能大于j，再选<=i-1的物品，有=是因为有再装一个i-1的可能)
                    dp[i][j] = temp;
                    trace[i-1][j] = i-1;
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }

    public List<Integer> getTrace() {
        List<Integer> res = new ArrayList<>();
        if(trace == null) {
            return res;
        }
        getTrace(res, trace.length-1, trace[0].length-1);
        return res;
    }

    public void getTrace(List<Integer> res, int i, int j) {
        if(i == -1) {
            return;
        }
        if(trace[i][j] != -1) {
            res.add(trace[i][j]);
            getTrace(res, i, j-w[i]);
        } else {
            getTrace(res, i-1, j);
        }
    }
}
