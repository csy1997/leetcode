package 动态规划.L132分割回文串II;

public class Solution {
    public int minCut(String s) {
        int l = s.length();
        if (l == 0 || l == 1) {
            return 0;
        }
        boolean[][] tab = new boolean[l][l];
        for (int i = 0; i < l; i++) {
            tab[i][i] = true;
        }
        for (int i = 1; i < l; i++) {
            if (s.charAt(i - 1) == s.charAt(i)) {
                tab[i - 1][i] = true;
            }
        }
        for (int d = 2; d < l; d++) {
            for (int i = 0; i + d < l; i++) {
                if (tab[i + 1][i + d - 1] && s.charAt(i) == s.charAt(i + d)) {
                    tab[i][i + d] = true;
                }
            }
        }
        int[] res = new int[l];//代表0到i长度最少分割次数
        for (int i = 0; i < l; i++) {
            res[i] = i;
            for (int j = 0; j <= i; j++) {
                if (tab[j][i]) {
                    res[i] = j == 0 ? 0 : Math.min(res[i], 1 + res[j - 1]);
                }
            }
        }
        return res[l - 1];
    }
}
