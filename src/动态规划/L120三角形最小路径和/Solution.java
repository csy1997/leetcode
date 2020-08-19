package 动态规划.L120三角形最小路径和;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.size()];
        for(List<Integer> list : triangle) {
            for (int i = list.size()-1; i >= 0; i--) {
                if(list.size() == 1) {
                    dp[0] = list.get(0);
                } else {
                    int l1 = i == 0 ? Integer.MAX_VALUE : list.get(i) + dp[i - 1];
                    int l2 = i == list.size()-1 ? Integer.MAX_VALUE : list.get(i) + dp[i];
                    dp[i] = Math.min(l1, l2);
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for(int x : dp) {
            min = Math.min(min, x);
        }
        return min;
    }
}
