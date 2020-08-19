package 回溯算法与搜索.L127单词接龙;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution1 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        List<String> queue = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();//记录起点到各点的距离
        queue.add(beginWord);
        map.put(beginWord, 1);
        //Dijkstra算法搜索各点最短路径，到endWord时停止
        while (queue.size() != 0) {
            String lastWord = queue.remove(0);
            for (int i = 0; i < wordList.size(); i++) {
                String word = wordList.get(i);
                if (isValid(lastWord, word)) {
                    if (!map.containsKey(word)) {
                        map.put(word, map.get(lastWord) + 1);
                        if (word.equals(endWord)) {
                            return map.get(endWord);
                        }
                        queue.add(word);
                    }
                    wordList.remove(i);
                    i--;
                }
            }
        }
        return 0;
    }

    public boolean isValid(String word1, String word2) {
        int sum = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                sum++;
            }
            if (sum == 2) {
                return false;
            }
        }
        return true;
    }
}
