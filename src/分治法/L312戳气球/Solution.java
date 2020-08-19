package 分治法.L312戳气球;

import java.util.Arrays;

public class Solution {
    int[][] dp;
    public int maxCoins(int[] nums) {
        int[] newNums = new int[nums.length+2];
        System.arraycopy(nums, 0, newNums, 1, nums.length);
        int len = newNums.length;
        newNums[0] = 1;
        newNums[len-1] = 1;
        //数组前后各加1
        dp = new int[len][len];
        for(int[] x : dp) {
            Arrays.fill(x, -1);
        }
        return maxCoins(newNums, 0, len-1);
    }

    //i到j之间的最大值，不包括戳破i,j
    public int maxCoins(int[] nums, int i, int j) {
        //已被保存的直接拿来用
        if(dp[i][j] != -1) {
            return dp[i][j];
        }
        int res = 0;
        for (int k = i+1; k < j; k++) {
            //从最后一个戳破位置的往前递归，每个位置都有可能，取最大
            res = Math.max(res, nums[i]*nums[k]*nums[j] + maxCoins(nums, i, k) + maxCoins(nums, k, j));
        }
        //第一次求得i到j的数量保存下来
        dp[i][j] = res;
        return res;
    }

    public static void main(String[] args) {
        int[][] arr = new int[3][3];
        for(int[] x : arr) {
            Arrays.fill(x, -1);
        }
        for(int[] x : arr) {
            for(int y : x) {
                System.out.print(y+" ");
            }
            System.out.println();
        }
    }
}
