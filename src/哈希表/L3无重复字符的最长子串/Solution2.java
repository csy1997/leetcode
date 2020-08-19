package 哈希表.L3无重复字符的最长子串;

import java.util.HashMap;

public class Solution2 {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(map.containsKey(c)) {
                left = Math.max(left, map.get(c));
            }
            max = Math.max(max, i-left);
            map.put(c, i);
        }
        return max;
    }
}
