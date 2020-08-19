package 双指针法.L15三数之和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> List = new ArrayList<>();
        if(nums.length < 3) {
            return List;
        }
        Arrays.sort(nums);

        for(int i = 0; i < nums.length-2 && nums[i] <= 0; i++) {
            if(i > 0 && nums[i] == nums[i-1]) {//相邻的相等的话前面已经考虑过此类情况
                continue;
            }
            int beg = i+1;
            int end = nums.length - 1;
            while(beg < end) {
                int sum = nums[i]+nums[beg]+nums[end];
                if(sum < 0) {
                    beg++;
                } else if(sum > 0) {
                    end--;
                } else {
                    if(beg != i+1 && nums[beg] == nums[beg-1]) {//相邻的相等的话前面已经考虑过此类情况
                        beg++;
                        continue;
                    }
                    if(end != nums.length-1 && nums[end] == nums[end+1]) {//相邻的相等的话前面已经考虑过此类情况
                        end--;
                        continue;
                    }
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[beg]);
                    temp.add(nums[end]);
                    List.add(temp);
                    beg++;
                    end--;
                }
            }
        }
        return List;
    }
}
