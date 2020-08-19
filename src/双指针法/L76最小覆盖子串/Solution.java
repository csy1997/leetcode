package 双指针法.L76最小覆盖子串;

import java.util.HashMap;

public class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        HashMap<Character, Integer> memo = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            memo.put(c, memo.getOrDefault(c, 0) - 1);//memo的value代表每个字符需要的数量，初始为负，到0就满了
        }
        int left = 0;//滑动窗口最左侧
        int right = 0;//窗口最右侧的下一个
        int fullCount = 0;//记录有效字符数
        while (right < s.length() && fullCount != t.length()) {//先增加right找到第一个刚好满足的窗口
            char c = s.charAt(right);
            if (memo.containsKey(c)) {
                int count = memo.get(c);
                if (count < 0) {//小于0代表正好缺当前字符，加上
                    fullCount++;
                }
                memo.put(c, count + 1);
            }
            right++;
        }
        if (fullCount != t.length()) {//到最后都不够，那子串也不可能够
            return "";
        }
        //记录当前解
        int resL = 0;
        int resR = right;
        boolean isFull = true;
        while (right < s.length() || isFull) {
            if (isFull) {//left到right刚好够，则left++找刚好不够的临界点
                char c = s.charAt(left);
                if (memo.containsKey(c)) {
                    if (memo.get(c) == 0) {
                        isFull = false;
                        if (right - left < resR - resL) {//这边找到临界点后要判断记录最优解
                            resL = left;
                            resR = right;
                        }
                    }
                    memo.put(c, memo.get(c) - 1);
                }
                left++;
            } else {//left到right刚好不够（left加到刚好缺一个），则right++找刚好够的临界点
                char c = s.charAt(right);
                if (memo.containsKey(c)) {
                    memo.put(c, memo.get(c) + 1);
                    if (memo.get(c) == 0) {
                        isFull = true;
                    }
                }
                right++;
            }
        }
        return s.substring(resL, resR);
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        Solution sol = new Solution();
        System.out.println(sol.minWindow(s, t));
    }
}
