package 数数组和字符串.L31下一个排列;

public class Solution {
    /**
     * 13542-->14532-->14235
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {//找到从右到左第一个正序排列的位置
            i--;
        }
        if (i == -1) {
            reverse(nums, 0);
        } else {
            int j = i + 1;
            while (j < nums.length && nums[j] > nums[i]) {//向右找第一个比i小的数，它的前一个数就是向右比i大的最小数
                j++;
            }
            //交换i和j-1，i后面的数仍然是逆序，将其变成正序
            int temp = nums[i];
            nums[i] = nums[j - 1];
            nums[j - 1] = temp;
            reverse(nums, i + 1);
        }
    }

    public void reverse(int[] nums, int n) {
        int l = nums.length - 1;
        for (int i = 0; l - i > n + i; i++) {
            int temp = nums[n + i];
            nums[n + i] = nums[l - i];
            nums[l - i] = temp;
        }
    }
}
