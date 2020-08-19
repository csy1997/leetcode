package 贪心法.L55跳跃游戏;

public class Solution {
    public boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        int max = 0;

        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, i+nums[i]);
            if(max >= nums.length-1) {
                return true;
            }
            if(max == i) {
                return false;
            }
        }
        return true;
    }
}
