package 动态规划.L97交错字符串;

public class Solution1 {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length()+s2.length() != s3.length()) {
            return false;
        }
        boolean[][] dp = new boolean[s1.length()+1][s2.length()+1];
        dp[0][0] = true;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if((i != 0 && dp[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1)) ||
                        j != 0 && dp[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1)) {
                    dp[i][j] = true;
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }
}
