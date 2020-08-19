package 回溯算法与搜索.L126单词接龙II;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestSolution {
    String beginWord = "hit";
    String endWord = "cog";
    List<String> wordList = new ArrayList<>() {{
        add("hit");add("hit");add("hit");add("hit");add("hot");add("dot");add("dog");add("lot");add("log");add("cog");
    }};

    @Test
    public void testSolution1() {
        Solution1 sol = new Solution1();
        System.out.println(sol.findLadders(beginWord, endWord, wordList));
    }

    @Test
    public void testSolution2() {
        Solution2 sol = new Solution2();
        System.out.println(sol.findLadders(beginWord, endWord, wordList));
    }
}
