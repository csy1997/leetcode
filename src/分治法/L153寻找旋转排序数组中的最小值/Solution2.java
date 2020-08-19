package 分治法.L153寻找旋转排序数组中的最小值;

public class Solution2 {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        if (nums[right] > nums[left]) {
            return nums[0];
        }
        while (left != right) {
            int mid = (left + right) / 2;//找合适mid和mid+1之间的分隔
            if (nums[mid] > nums[mid + 1]) {//如果刚好找到结果就返回
                return nums[mid + 1];
            }
            if (nums[mid] > nums[left]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }
}
