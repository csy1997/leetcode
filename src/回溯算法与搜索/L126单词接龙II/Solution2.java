package 回溯算法与搜索.L126单词接龙II;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * 改进版，Map加双向BFS
 */
public class Solution2 {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        HashSet<String> set = new HashSet<>(wordList);//未使用的节点
        if (!set.contains(endWord)) {
            return res;
        }
        HashMap<String, List<List<String>>> map1 = new HashMap<>();//从起点开始的各层搜索节点集，每搜索一层更新一次，value为以key节点结尾的所有序列集
        HashMap<String, List<List<String>>> map2 = new HashMap<>();//从终点开始的各层搜索节点集，每搜索一层更新一次，value为以key节点开头的所有序列集
        map1.put(beginWord, new ArrayList<>() {{
            add(new ArrayList<>() {{
                add(beginWord);
            }});
        }});
        set.remove(beginWord);
        map2.put(endWord, new ArrayList<>() {{
            add(new ArrayList<>() {{
                add(0, endWord);
            }});
        }});
        set.remove(endWord);
        boolean found = false;
        while (!map1.isEmpty() && !map2.isEmpty()) {//map没有新key代表没有与上一轮相连的节点，路径中断截止
            //搜索map1和map2中有没有相连的节点，有说明本轮找到了最短路径，合并相连节点对应的各个序列集依次输出
            for (String leftWord : map1.keySet()) {
                for (String rightWord : map2.keySet()) {
                    if (isValid(leftWord, rightWord)) {
                        found = true;
                        for (List<String> beginList : map1.get(leftWord)) {
                            for (List<String> endList : map2.get(rightWord)) {
                                List<String> temp = new ArrayList<>(beginList);
                                temp.addAll(endList);
                                res.add(temp);
                            }
                        }
                    }
                }
            }
            if (found) {//最短路径只存在本轮中
                break;
            }
            HashMap<String, List<List<String>>> newMap = new HashMap<>();
            HashSet<String> chosenWords = new HashSet<>();
            if (map1.size() <= map2.size()) {//每轮根据前后节点数量决定本轮从哪个方向搜索，减少搜索次数
                //从未选的节点里找到能与map中节点相连的节点，放到到newMap中
                for (String midWord : set) {
                    for (String leftWord : map1.keySet()) {
                        if (isValid(leftWord, midWord)) {
                            chosenWords.add(midWord);
                            if (!newMap.containsKey(midWord)) {
                                newMap.put(midWord, new ArrayList<>());
                            }
                            //将map节点对应的各个序列与相连的midWord合并，得到新序列放入newMap的midWord里
                            for (List<String> beginList : map1.get(leftWord)) {
                                List<String> temp = new ArrayList<>(beginList);
                                temp.add(midWord);
                                newMap.get(midWord).add(temp);
                            }
                        }
                    }
                }
                map1 = newMap;//更新map为下一轮节点集newMap
            } else {
                for (String midWord : set) {
                    for (String rightWord : map2.keySet()) {
                        if (isValid(rightWord, midWord)) {
                            chosenWords.add(midWord);
                            if (!newMap.containsKey(midWord)) {
                                newMap.put(midWord, new ArrayList<>());
                            }
                            for (List<String> endList : map2.get(rightWord)) {
                                List<String> temp = new ArrayList<>(endList);
                                temp.add(0, midWord);
                                newMap.get(midWord).add(temp);
                            }
                        }
                    }
                }
                map2 = newMap;
            }
            set.removeAll(chosenWords);
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
