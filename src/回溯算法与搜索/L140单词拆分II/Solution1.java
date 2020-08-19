package 回溯算法与搜索.L140单词拆分II;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {
    private List<String> res;
    private String s;
    private List<String> wordDict;
    private int minLength;
    private int maxLength;

    public List<String> wordBreak(String s, List<String> wordDict) {
        this.res = new ArrayList<>();
        this.s = s;
        this.wordDict = wordDict;
        this.minLength = Integer.MAX_VALUE;
        this.maxLength = 0;
        for (String word : wordDict) {
            int length = word.length();
            if (length < minLength) {
                minLength = length;
            }
            if (length > maxLength) {
                maxLength = length;
            }
        }
        addToList(0, "");
        return res;
    }

    public void addToList(int i, String current) {
        if (i == s.length()) {
            res.add(current.substring(0, current.length()-1));
            return;
        }
        for (int j = i + minLength; j <= i + maxLength && j <= s.length(); j++) {
            String sub = s.substring(i, j);
            if (wordDict.contains(sub)) {
                String temp = new StringBuilder(current).append(sub).append(" ").toString();
                addToList(j, temp);
            }
        }
    }
}
