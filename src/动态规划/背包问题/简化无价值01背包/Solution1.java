package 动态规划.背包问题.简化无价值01背包;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 每个物品只能装一个，装最多数量（直接对重量排序贪心更好）
 */
public class Solution1 {
    int[][] dp;
    int[][] trace;
    int[] w;

    public int getMaxCountInBag(int[] w, int W) {
        if(w.length == 0) {
            return 0;
        }
        this.w = w;
        dp = new int[w.length+1][W+1];
        trace = new int[w.length][W+1];
        for(int[] t : trace) {
            Arrays.fill(t, -1);
        }
//        for (int i = 1; i < dp[0].length; i++) {
//            dp[0][i] = 0;
//        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = dp[i-1][j];
                int temp;
                if(j >= w[i-1] && (temp = (dp[i-1][j - w[i-1]] + 1)) > dp[i][j]) {//相当于所有物品价值都等于其数量1
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
            getTrace(res, i-1, j-w[i]);
        } else {
            getTrace(res, i-1, j);
        }
    }

    public static void main(String[] args) {
        int[] w = {2,3,4,7};
        int W = 10;
        Solution1 sol = new Solution1();
        System.out.println(sol.getMaxCountInBag(w, W));
        System.out.println(sol.getTrace());
    }
}
