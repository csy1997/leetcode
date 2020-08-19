package 分治法.L81搜索旋转排序数组II;

public class Solution1 {
    public boolean search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        return search(l, r, nums, target);
    }

    public boolean search(int l, int r, int[] nums, int target) {
        if(l > r) {
            return false;
        }
        int mid = (l + r) / 2;
        if (target == nums[mid]) {
            return true;
        }
        if(nums[mid] == nums[l] && nums[mid] == nums[r]) {
            return search(l, mid-1, nums, target) || search(mid+1, r, nums, target);
        }
        if (nums[mid] >= nums[l]) {//说明l到mid全部正序，mid到r可能先比mid大，再比r小
            if (target >= nums[l] && target < nums[mid]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        } else {//mid到r全部正序，l到mid可能先比r大，后比mid小
            if (target <= nums[r] && target > nums[mid]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return search(l, r, nums, target);
    }

    public static void main(String[] args) {
        Solution1 sol = new Solution1();
        int[] nums = {0,2,0,0,0,0,0,0,0};
        int target = 1;
        System.out.println(sol.search(nums, target));
    }
}
