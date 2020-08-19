package 哈希表.L128最长连续序列;

import java.util.HashSet;

public class Solution1 {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int max = 0;
        for (int num : set) {
            if (!set.contains(num - 1)) {//找连续数的第一个，往后数长度
                int len = 1;
                while (set.contains(num + len)) {
                    len++;
                }
                max = Math.max(max, len);
            }
        }
        return max;
    }
}
