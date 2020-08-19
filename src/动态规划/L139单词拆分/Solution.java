package 动态规划.L139单词拆分;

import java.util.List;

public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s.length() == 0) {
            return false;
        }
        boolean[] dp = new boolean[s.length() + 1];//代表s前i长度的字符串是否合适
        dp[0] = true;
        for (int i = 1; i <= dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
