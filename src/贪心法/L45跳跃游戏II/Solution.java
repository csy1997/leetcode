package 贪心法.L45跳跃游戏II;

public class Solution {
    public int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int count = 0;
        int max = 0;
        int min = 0;

        while (true) {//min到max为跳count次能跳到的区间，且前一个区间跳一次不会超出本区间
            ++count;
            int end = 0;
            for (int i = min; i <= max; i++) {//算出当前区间能跳到的最远处
                if (i + nums[i] > end) {
                    end = i + nums[i];
                }
            }
            if (end >= nums.length-1) {//最远超过数组，说明本次能到终点
                return count;
            }
            //记录新区间
            min = max + 1;
            max = end;
        }
    }
}
