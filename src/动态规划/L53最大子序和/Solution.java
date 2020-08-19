package 动态规划.L53最大子序和;

public class Solution {
    public int maxSubArray(int[] nums) {
        int sum = Integer.MIN_VALUE;//截止x的最大子序和
        int max = Integer.MIN_VALUE;
        for(int x : nums) {
            if(sum < 0) {//x前面的加起来小于0，那还不如不加
                sum = x;
            } else {
                sum += x;
            }
            max = Math.max(max, sum);
        }
        return max;
    }
}
