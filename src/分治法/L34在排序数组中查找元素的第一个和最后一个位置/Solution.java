package 分治法.L34在排序数组中查找元素的第一个和最后一个位置;

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int l = 0;
        int r = nums.length-1;
        int mid = -1;
        while(l != r + 1) {
            mid = (l+r) / 2;
            if(nums[mid] == target) {
                break;//二分法找到第一个出现的target在mid处
            }
            if(nums[mid] > target) {
                r = mid-1;
            } else {
                l = mid+1;
            }
        }
        if(l == r + 1) {
            return new int[]{-1, -1};
        }
        //对mid左右段分别二分找到左右边界
        int left = findLeftBound(nums, mid, target);
        int right = findRightBound(nums, mid, target);
        return new int[]{left, right};
    }

    private int findLeftBound(int[] nums, int r, int target) {
        int l = 0;
        while(l != r+1) {
            int bound = (l+r) / 2;
            if(nums[bound] == target) {
                r = bound-1;
            } else {
                l = bound+1;
            }
        }
        return l;
    }

    private int findRightBound(int[] nums, int l, int target) {
        int r = nums.length-1;
        while(l != r+1) {
            int bound = (l+r) / 2;
            if(nums[bound] == target) {
                l = bound+1;
            } else {
                r = bound-1;
            }
        }
        return r;
    }
}
