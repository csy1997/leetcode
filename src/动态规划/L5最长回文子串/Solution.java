package 动态规划.L5最长回文子串;

import java.util.Arrays;

public class Solution {
    public String longestPalindrome(String s) {
        if(s.length() == 0) {
            return "";
        }
        boolean[][] memo = new boolean[2][s.length()];//优化空间到一维，初始为长度为0和1的子串，奇偶子串分开考虑
        Arrays.fill(memo[0], true);
        Arrays.fill(memo[1], true);
        int maxi = 0;
        int maxj = 0;
        int noMatch = 0;
        for (int l = 2; l <= s.length(); l++) {
            int row = l % 2;
            boolean temp = false;
            //i代表子串最后一个字符下标，显然当前memo值依赖于上一个同奇偶子串memo第i-1个是否true，以及s第i和i-l+1个字符是否相等
            for(int i = s.length()-1; i >= l-1; i--) {//之所以倒序遍历是因为后面更新时不会变动前面需要的memo值（i需要i-1）
                if(memo[row][i-1] && s.charAt(i) == s.charAt(i-l+1)) {
                    temp = true;
                    memo[row][i] = true;
                    maxi = i-l+1;
                    maxj = i;
                } else {
                    memo[row][i] = false;
                }
            }
            if(!temp) {
                noMatch++;
            } else {
                noMatch = 0;
            }
            if(noMatch == 2) {//连续两个长度子串都没有回文，不用往下考虑了
                break;
            }
        }
        return s.substring(maxi, maxj+1);
    }

    public static void main(String[] args) {
        String s = "abadebv";
        Solution sol = new Solution();
        System.out.println(sol.longestPalindrome(s));
    }
}
