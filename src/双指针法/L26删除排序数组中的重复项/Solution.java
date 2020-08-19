package 双指针法.L26删除排序数组中的重复项;

public class Solution {
    public int removeDuplicates(int[] nums) {
        int p = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] != nums[i-1]){
                nums[p] = nums[i];
                p++;
            }
        }
        return p;
    }
}
