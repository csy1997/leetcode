package 双指针法.L80删除排序数组中的重复项II;

public class Solution {
    public int removeDuplicates(int[] nums) {
        int p = 0;//p之前的数（不包括p）代表已排好的数
        for (int n : nums)
            if (p < 2 || n != nums[p-2]) {//排序数组，前两项重复不会超过两个，后面找到不等于p-2的位置重复数就不会超过俩，把此时n赋给p
                nums[p++] = n;
            }
        return p;
    }
}
