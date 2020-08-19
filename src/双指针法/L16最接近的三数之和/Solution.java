package 双指针法.L16最接近的三数之和;

import java.util.Arrays;

public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int min = nums[0]+nums[1]+nums[2];
        int minDistance = abs(min-target);
        Arrays.sort(nums);
        for(int i = 0; i < nums.length-2; i++) {
            int sum;
            if((sum = nums[i]+nums[nums.length-2]+nums[nums.length-1]) < target) {//i情况下最大值也比target小，那就考虑该值后跳到下一个
                if(abs(sum-target) < minDistance) {
                    min = sum;
                    minDistance = abs(min-target);
                }
                continue;
            } else if((sum = nums[i]+nums[i+1]+nums[i+2]) > target) {//i情况下最小值也比target大，考虑完该值就可以结束循环
                if(abs(sum-target) < minDistance) {
                    min = sum;
                    minDistance = abs(min-target);
                }
                break;
            }
            int beg = i+1;
            int end = nums.length - 1;
            while(beg < end) {
                sum = nums[i]+nums[beg]+nums[end];
                if(abs(sum-target) < minDistance) {
                    min = sum;
                    minDistance = abs(min-target);
                }
                if(sum-target < 0) {
                    beg++;
                } else if(sum-target > 0) {
                    end--;
                } else {
                    return target;
                }
            }
        }
        return min;
    }

    public int abs(int x) {
        if(x < 0) {
            return -x;
        }
        return x;
    }
}
