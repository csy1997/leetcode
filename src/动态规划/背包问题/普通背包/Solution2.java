package 动态规划.背包问题.普通背包;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 递归法
 */
public class Solution2 {
    int[][] dp;
    int[][] trace;
    int[] w;
    int[] v;
    int W;

    public int getMaxValueInBag(int[] w, int[] v, int W) {
        if(w.length == 0) {
            return 0;
        }
        this.w = w;
        this.v = v;
        dp = new int[w.length+1][W+1];
        trace = new int[w.length][W+1];
        this.W = W;
        for(int[] t : trace) {
            Arrays.fill(t, -1);
        }
        for(int[] d : dp) {
            Arrays.fill(d, -1);
        }
        return getMaxValueInBag(dp.length-1, dp[0].length-1);
    }

    public int getMaxValueInBag(int i, int j) {
        if(dp[i][j] != -1) {//即已经被记录
            return dp[i][j];
        }
        if(i == 0) {
            dp[0][j] = 0;
            return dp[0][j];
        }
        int x = getMaxValueInBag(i-1, j);
        int y;
        if(j >= w[i-1] && (y = (getMaxValueInBag(i, j - w[i-1]) + v[i-1])) > x) {
            dp[i][j] = y;
            trace[i-1][j] = i-1;
        } else {
            dp[i][j] = x;
        }
        return dp[i][j];
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
