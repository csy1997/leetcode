package 双指针法.L18四数之和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int l = nums.length;
        Arrays.sort(nums);
        for(int i = 0; i < l-3; i++) {
            if(i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            if(nums[i] + nums[i+1] + nums[i+2] + nums[i+3] > target) {
                break;
            }
            if(nums[i] + nums[l-3] + nums[l-2] + nums[l-1] < target) {
                continue;
            }
            for(int j = i+1; j < l-2; j++) {
                if(j > i+1 && nums[j] == nums[j-1]) {
                    continue;
                }
                if(nums[i] + nums[j] + nums[j+1] + nums[j+2] > target) {
                    break;
                }
                if(nums[i] + nums[j] + nums[l-2] + nums[l-1] < target) {
                    continue;
                }
                int temp = nums[i] + nums[j] - target;
                int left = j+1;
                int right = l-1;
                while(right > left) {
                    if(nums[left] + nums[right] < -temp) {
                        left++;
                    }else if(nums[left] + nums[right] > -temp) {
                        right--;
                    }else {
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        do {
                            left++;
                        } while(left < right && nums[left] == nums[left-1]);
                        do {
                            right--;
                        } while(left < right && nums[right] == nums[right+1]);
                    }
                }
            }
        }
        return res;
    }
}
