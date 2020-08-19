package 分治法.L154寻找旋转排序数组中的最小值II;

public class Solution {
    public int findMin(int[] nums) {
        return findMin(nums, 0, nums.length - 1);
    }

    public int findMin(int[] nums, int l, int r) {
        if (l == r) {
            return nums[l];
        }
        int mid = (l + r) / 2;
        if (nums[mid] == nums[l] && nums[mid] == nums[r]) {//左右中都相等，不能确定分隔极大极小的位置在左半还是右半部分
            int temp = findMin(nums, l, mid);
            if (temp != nums[l]) {//先递归判断左半部分，如果得到的结果不等于l和r处的值，则说明极小值已在左半部分找到，直接返回
                return temp;
            }
            //如果temp等于l和r处的值，说明左半部分没有找到比l和r更小的，那么右半部分找的极小值绝不会比l和r更大（等于的话说明本轮没找到最合适的极小值，回上一轮再继续判断对应的右半部分），直接返回右半部分递归结果
            return findMin(nums, mid + 1, r);
        }
        if (nums[mid] <= nums[r]) {//左右等，中比右小、以及中右等，左较大的情况都能确定极小值在左半部分
            return findMin(nums, l, mid);
        }
        return findMin(nums, mid + 1, r);
    }
}
