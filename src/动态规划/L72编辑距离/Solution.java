package 动态规划.L72编辑距离;

/**
 * dp方程：dp[i][j] = dp[i-1][j-1]                                     (word1[i] == word2[j])
 *                  = min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1]) + 1    (word1[i] != word2[j])
 * 与最长公共子序列类似
 */
public class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 1; i < dp.length; i++) dp[i][0] = i;
        for (int i = 1; i < dp[0].length; i++) dp[0][i] = i;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = word1.charAt(i - 1) != word2.charAt(j - 1) ?
                        1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) : dp[i - 1][j - 1];
            }
        }
        return dp[word1.length()][word2.length()];
    }
}
