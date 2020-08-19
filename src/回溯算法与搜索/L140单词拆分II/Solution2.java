package 回溯算法与搜索.L140单词拆分II;

import java.util.ArrayList;
import java.util.List;

/**
 * 超时，需针对特例先用boolean数组判断再用List<String>存储
 */
public class Solution2 {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String>[] dp = new List[s.length() + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = new ArrayList<>();
        }
        dp[0].add("");
        for (int i = 0; i < dp.length; i++) {
            if (!dp[i].isEmpty()) {
                for (String word : wordDict) {
                    int j = i + word.length();
                    if (j <= s.length() && word.equals(s.substring(i, j))) {
                        for (String pre : dp[i]) {
                            StringBuilder temp = new StringBuilder(pre).append(word);
                            if (j != s.length()) {
                                temp.append(" ");
                            }
                            dp[j].add(temp.toString());
                        }
                    }
                }
            }
        }
        return dp[s.length()];
    }
}
