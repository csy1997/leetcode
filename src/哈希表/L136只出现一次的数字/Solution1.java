package 哈希表.L136只出现一次的数字;

import java.util.HashSet;

public class Solution1 {
    public int singleNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                set.remove(num);
            } else {
                set.add(num);
            }
        }
        for (int res : set) {
            return res;
        }
        return -1;
    }
}
