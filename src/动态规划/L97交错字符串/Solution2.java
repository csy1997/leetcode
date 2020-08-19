package 动态规划.L97交错字符串;

/**
 * 空间和条件优化
 */
public class Solution2 {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length()+s2.length() != s3.length()) {
            return false;
        }
        boolean[] dp = new boolean[s2.length()+1];//滚动数组，只需要原二维dp的行即s2的空间
        dp[0] = true;//初始长度和l为0，i和j都只能为0，此时空字符串满足要求设为true
        for (int l = 1; l <= s3.length(); l++) {
            boolean rec = false;//记录当前轮是否全为false
            for (int j = Math.min(l, dp.length-1); j >= Math.max(0, l-s1.length()); j--) {
                //当前dp[j]对应二维的dp[i][j]，其依赖的dp[i-1][j]对应上一轮dp[j]，dp[i][j-1]对应上一轮dp[j-1]，因此每轮赋值需倒序，s2取长从大到小
                //且当l<=s2.length时，s1初始长度可取为0（二维j==l），此时只依赖dp[j-1]（二维dp[i][j-1]）
                //当l<=s1.length时，s2最后长度可取为0（二维j==0），此时只依赖dp[j]（二维dp[i-1][j]）
                dp[j] = (j != l && dp[j] && s1.charAt(l - j - 1) == s3.charAt(l - 1)) ||
                        (j != 0 && dp[j - 1] && s2.charAt(j - 1) == s3.charAt(l - 1));
                rec = rec || dp[j];
            }
            if(!rec) {//全为false后面就不用考虑了
                return false;
            }
        }
        return dp[s2.length()];
    }
}
