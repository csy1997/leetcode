package 回溯算法与搜索.L127单词接龙;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * 双向BFS
 */
public class Solution2 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        List<String> queue1 = new ArrayList<>();
        List<String> queue2 = new ArrayList<>();
        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();
        List<String> list1 = new ArrayList<>(wordList);
        List<String> list2 = new ArrayList<>(wordList);
        queue1.add(beginWord);
        queue2.add(endWord);
        map1.put(beginWord, 1);
        map2.put(endWord, 1);
        while (queue1.size() != 0 && queue2.size() != 0) {
            int len;
            if (queue1.size() <= queue2.size()) {
                len = queue1.size();
                for (int i = 0; i < len; i++) {
                    String leftWord = queue1.remove(0);
                    for (int j = 0; j < list1.size(); j++) {
                        String word = list1.get(j);
                        if (isValid(leftWord, word)) {
                            if (map2.containsKey(word)) {
                                return map1.get(leftWord) + map2.get(word);
                            }
                            if (!map1.containsKey(word)) {
                                map1.put(word, map1.get(leftWord) + 1);
                                queue1.add(word);
                            }
                            list1.remove(j);
                            j--;
                        }
                    }
                }
            } else {
                len = queue2.size();
                for (int i = 0; i < len; i++) {
                    String rightWord = queue2.remove(0);
                    for (int j = 0; j < list2.size(); j++) {
                        String word = list2.get(j);
                        if (isValid(rightWord, word)) {
                            if (map1.containsKey(word)) {
                                return map2.get(rightWord) + map1.get(word);
                            }
                            if (!map2.containsKey(word)) {
                                map2.put(word, map2.get(rightWord) + 1);
                                queue2.add(word);
                            }
                            list2.remove(j);
                            j--;
                        }
                    }
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
