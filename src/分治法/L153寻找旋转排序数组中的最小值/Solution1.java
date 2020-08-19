package 分治法.L153寻找旋转排序数组中的最小值;

public class Solution1 {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        if (nums[right] > nums[left]) {
            return nums[0];
        }
        int l = left, r = right;
        while (l != r) {
            int mid = (l + r) / 2;
            if (nums[mid] < nums[right]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return nums[l];
    }
}
