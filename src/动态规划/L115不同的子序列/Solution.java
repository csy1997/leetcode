package 动态规划.L115不同的子序列;

public class Solution {
    public int numDistinct(String s, String t) {
        if (s.length() < t.length()) {
            return 0;
        }
        int[][] tab = new int[t.length() + 1][s.length() + 1];
        for (int i = 0; i <= s.length(); i++) {
            tab[0][i] = 1;
        }
        for (int i = 1; i <= t.length(); i++) {
            tab[i][i - 1] = 0;
        }
        for (int i = 1; i <= t.length(); i++) {
            for (int j = i; j <= s.length() - t.length() + i; j++) {//需保证s剩余的长度也要比t剩余的长度大，否则不用考虑
                if (s.charAt(j - 1) == t.charAt(i - 1)) {
                    tab[i][j] = tab[i - 1][j - 1] + tab[i][j - 1];
                } else {
                    tab[i][j] = tab[i][j - 1];
                }
            }
        }
        return tab[t.length()][s.length()];
    }
}
