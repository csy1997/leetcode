package 回溯算法与搜索.L140单词拆分II;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestSolution {
    String s = "aaaaaaaaaaaaaaaa";
    List<String> wordDict = new ArrayList<>() {{
        add("a");add("aa");add("aaa");add("aaaa");add("aaaaa");add("aaaaaa");add("aaaaaaa");add("aaaaaaaa");add("aaaaaaaaa");add("aaaaaaaaaa");
    }};

    @Test
    public void testSolution1() {
        Solution1 sol = new Solution1();
        System.out.println(sol.wordBreak(s, wordDict));
    }

    @Test
    public void testSolution2() {
        Solution2 sol = new Solution2();
        System.out.println(sol.wordBreak(s, wordDict));
    }
}
