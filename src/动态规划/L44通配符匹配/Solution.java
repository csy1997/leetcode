package 动态规划.L44通配符匹配;

public class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[p.length() + 1][s.length() + 1];
        dp[0][0] = true;
        for (int i = 1; i < dp.length; i++) {
            if (p.charAt(i - 1) == '*') {
                dp[i][0] = true;
            } else {
                break;
            }
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                char c1 = s.charAt(j - 1);
                char c2 = p.charAt(i - 1);
                if (c2 == c1 || c2 == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (c2 == '*') {
                    for (int k = j; k >= 0; k--) {
                        if (dp[i - 1][k]) {
                            dp[i][j] = true;
                        }
                    }
                }
            }
        }
        return dp[p.length()][s.length()];
    }

    /**
     * 简化的动态规划
     *
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch2(String s, String p) {
        int sn = s.length();
        int pn = p.length();
        int i = 0;
        int j = 0;
        int start = -1;
        int match = 0;
        while (i < sn) {
            if (j < pn && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')) {
                i++;
                j++;
            } else if (j < pn && p.charAt(j) == '*') {//能遇到*说明之前的都匹配好（且上一个*不用考虑别的情况了），记录下到新*的情况
                start = j;
                match = i;
                j = start + 1;//从*匹配空字符串开始考虑，下一轮j+1，i不变
            } else if (start != -1) {//当前字符不匹配时，让*匹配s的字符增加一个
                j = start + 1;//j回到*的下一个
                match++;
                i = match;//i从下一个match开始
            } else {//没有出现*且当前字符不匹配，无解
                return false;
            }
        }
        while (j < pn) {//s已经读完，p剩余的字符都必须是*
            if (p.charAt(j) != '*') return false;
            j++;
        }
        return true;
    }
}
