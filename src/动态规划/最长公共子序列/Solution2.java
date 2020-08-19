package 动态规划.最长公共子序列;

import java.util.Arrays;

/**
 * 递归法
 */
public class Solution2 {
    final int UP = 1;
    final int LEFT = 2;
    final int UPLEFT = 3;
    String X;
    String Y;
    int[][] dp;
    int[][] tag;

    public int getMaxCommonSubsequence(String X, String Y) {
        this.X = X;
        this.Y = Y;
        dp = new int[X.length()][Y.length()];
        for(int[] d : dp) {
            Arrays.fill(d, -1);
        }
        tag = new int[X.length()][Y.length()];
        return getMaxCommonSubsequence(dp.length-1, dp[0].length-1);
    }

    public int getMaxCommonSubsequence(int i, int j) {
        if(i == -1 || j == -1) {
            return 0;
        }
        if(dp[i][j] != -1) {
            return dp[i][j];
        }
        if(X.charAt(i) == Y.charAt(j)) {
            dp[i][j] = getMaxCommonSubsequence(i-1, j-1) + 1;
            tag[i][j] = UPLEFT;
            return dp[i][j];
        }
        int up = getMaxCommonSubsequence(i-1, j);
        int left = getMaxCommonSubsequence(i, j-1);
        if(up > left) {
            dp[i][j] = up;
            tag[i][j] = UP;
        } else {
            dp[i][j] = left;
            tag[i][j] = LEFT;
        }
        return dp[i][j];
    }

    public String getTrace() {
        StringBuilder sb = new StringBuilder();
        for (int i = tag.length-1, j = tag[0].length-1; i >= 0 && j >= 0; ) {
            if(tag[i][j] == UPLEFT) {
                sb.append(X.charAt(i));
                i--;
                j--;
            } else if(tag[i][j] == LEFT) {
                j--;
            } else if(tag[i][j] == UP) {
                i--;
            }
        }
        return sb.reverse().toString();
    }
}
