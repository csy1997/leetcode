package 回溯算法与搜索.L131分割回文串;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private List<List<String>> res;
    private List<String> list;
    private boolean[][] dp;

    public List<List<String>> partition(String s) {
        int l = s.length();
        dp = new boolean[l + 1][l + 1];
        //动态规划找出回文段
        for (int i = 1; i <= l; i++) {
            dp[i - 1][i] = true;
        }
        for (int i = 0; i <= l - 2; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 2] = true;
            }
        }
        for (int d = 3; d <= l; d++) {
            for (int i = 0; i + d <= l; i++) {
                if (dp[i + 1][i + d - 1] && s.charAt(i) == s.charAt(i + d - 1)) {
                    dp[i][i + d] = true;
                }
            }
        }
        res = new ArrayList<>();
        list = new ArrayList<>();
        addToList(s, 0);
        return res;
    }

    public void addToList(String s, int i) {
        int l = s.length();
        if (i == l) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int j = i + 1; j <= l; j++) {
            if (dp[i][j]) {
                list.add(s.substring(i, j));
                addToList(s, j);
                list.remove(list.size() - 1);
            }
        }
    }
}
