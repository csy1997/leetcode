package 数数组和字符串.L30串联所有单词的子串;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s.length() == 0 || words.length == 0) return res;
        int wordLength = words[0].length();
        if (words.length * wordLength > s.length()) return res;
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        for (int j = 0; j < wordLength; j++) {//j%wordLength不相等则为不同滑动窗口情况（不会重合）
            HashMap<String, Integer> memo = new HashMap<>();//记录连续有效的单词
            int count = 0;
            int leftCount = (s.length()-j) / wordLength;
            int i = j;
            while (i <= s.length()-wordLength && count + leftCount >= words.length) {//当前记录的有效单词加上剩下的单词总数需覆盖所有words
                String sub = s.substring(i, i + wordLength);//当前窗口截出的字符串单词
                if (!map.containsKey(sub)) {//words中不包含该单词，之前连续有效的单词全都清空
                    count = 0;
                    memo.clear();
                } else {
                    count++;
                    memo.put(sub, memo.getOrDefault(sub, 0) + 1);
                    while (memo.get(sub) == map.get(sub)+1) {//当前单词超过有效个数，需从头开始删除记录的有效单词，直到第一个该单词被删掉
                        int beg = i - (count - 1) * wordLength;
                        String sub2 = s.substring(beg, beg + wordLength);
                        count--;
                        memo.put(sub2, memo.getOrDefault(sub2, 0) - 1);
                    }
                    if (count == words.length) {//连续有效单词数量和总单词数相等了，得到一个解
                        res.add(i - (count - 1) * wordLength);
                    }
                }
                leftCount--;
                i += wordLength;
            }
        }
        return res;
    }
}
