package 分治法.L33搜索旋转排序数组;

public class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (target == nums[mid]) {
                return mid;
            }
            if (nums[mid] >= nums[l]) {//说明l到mid全部正序，mid到r可能先比mid大，再比r小
                if (target >= nums[l] && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
//                if (target <= nums[r] || target > nums[mid]) {
//                    l = mid + 1;
//                } else {
//                    r = mid - 1;
//                }//用或满足不了l到r全部正序，即nums[r] >= nums[l]的情况
            } else {//mid到r全部正序，l到mid可能先比r大，后比mid小
                if (target <= nums[r] && target > nums[mid]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }
}
