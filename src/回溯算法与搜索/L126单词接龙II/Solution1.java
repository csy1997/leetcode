package 回溯算法与搜索.L126单词接龙II;

import java.util.*;

public class Solution1 {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        List<List<String>> queue = new ArrayList<>();
        queue.add(new ArrayList<>() {{
            add(beginWord);
        }});
        boolean found = false;//是否已经出现第一个序列到达终点
        //根据Dijkstra贪心原则（每轮得到合适的新节点集下一轮不必再用，因为起点到达该节点长度已是最短），进行BFS搜索，每轮将各个序列长度加1
        while (!found && queue.size() != 0) {//上一轮出了终点序列即最短路径获取完成，或者上一轮所有序列没有后续即不可能到达终点时终止
            int len = queue.size();
            HashSet<String> chosenWords = new HashSet<>();//记录本轮添加过的新单词节点
            for (int i = 0; i < len; i++) {
                List<String> headPath = queue.remove(0);
                String lastWord = headPath.get(headPath.size() - 1);
                for (String word : wordList) {
                    if (isValid(lastWord, word)) {//从未使用过的单词节点中找到能接到本轮队列中的序列后的
                        List<String> nextPath = new ArrayList<>(headPath);
                        nextPath.add(word);
                        chosenWords.add(word);
                        if (word.equals(endWord)) {//如果刚好是endWord，说明已出现第一个到达终点的序列，本轮能得到所有最短序列集
                            found = true;
                            res.add(nextPath);
                        } else {
                            queue.add(nextPath);
                        }
                    }
                }
            }
            wordList.removeAll(chosenWords);//去掉本轮添加过的节点，留下未用过的节点集
        }
        return res;
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
