package 双指针法.L42接雨水;

public class Solution1 {
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int ans = 0;
        int left_max = 0, right_max = 0;//初始左右界都设为0
        while (left < right) {
            if (height[left] < height[right]) {//选左右指针高度小的那个，此时左右最小界也会之同边
                if (height[left] >= left_max) {//此时左界不比右界大，只需与左界比较
                    left_max = height[left];
                } else {
                    ans += (left_max - height[left]);
                }
                ++left;
            } else {
                if (height[right] >= right_max) {//此时右界不比左界大，只需与右界比较
                    right_max = height[right];
                } else {
                    ans += (right_max - height[right]);
                }
                --right;
            }
        }
        return ans;
    }
}
