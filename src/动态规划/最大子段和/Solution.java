package 动态规划.最大子段和;

/**
 * 求数组中连续子段的最大和
 * dp方程：dp[i] = max{dp[i-1]+arr[i], arr[i]}，dp[i]代表i往前（包括i）的连续子段中的最大值
 */
public class Solution {
    public static int getMaxContinuousSequence1(int[] arr) {
        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        int max = arr[0];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Math.max(dp[i-1]+arr[i], arr[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    /**
     * 简化版，由于dp每项只依赖前一项，所以无需数组记录，空间复杂度可以是o(1)
     * @param arr
     * @return
     */
    public static int getMaxContinuousSequence2(int[] arr) {
        int current = arr[0];
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            //dp[i]直接由前项是否为负决定
            if(current > 0) {
                current += arr[i];
            } else {
                current = arr[i];
            }
            max = Math.max(max, current);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {-2,11,-4,13,-5,-2};
        System.out.println(getMaxContinuousSequence1(arr));
        System.out.println(getMaxContinuousSequence2(arr));
    }
}
