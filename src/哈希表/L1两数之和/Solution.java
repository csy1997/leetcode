package 哈希表.L1两数之和;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = target-nums[i];
            if(map.containsKey(temp)) {
                return new int[] {map.get(temp), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return null;
    }
}
