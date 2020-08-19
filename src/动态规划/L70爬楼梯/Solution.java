package 动态规划.L70爬楼梯;

public class Solution {
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int x1 = 1;
        int x2 = 2;
        for (int i = 3; i <= n; i++) {
            int temp = x2;
            x2 += x1;
            x1 = temp;
        }
        return x2;
    }
}
