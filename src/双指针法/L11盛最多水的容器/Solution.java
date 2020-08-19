package 双指针法.L11盛最多水的容器;

public class Solution {
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length-1;
        int max = 0;
        while(i < j) {
            int temp = Math.min(height[i], height[j])*(j-i);
            max = Math.max(max, temp);
            //当height[i] < height[j]，i不变的话minHeight不会比height[i]大，j无论怎么减少结果都不会比现在结果大，反之同理，因此用双指针
            if(height[i] < height[j]) {
                int k = i+1;
                for(; k < j; k++) {
                    if(height[k] > height[i]) {//i处为低界，只有找到比i高的加上j界才结果有可能更大
                        break;
                    }
                }
                i = k;
            } else {
                int k = j-1;
                for(; k > i; k--) {
                    if(height[k] > height[j]) {
                        break;
                    }
                }
                j = k;
            }
        }
        return max;
    }
}
