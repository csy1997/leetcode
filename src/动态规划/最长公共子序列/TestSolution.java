package 动态规划.最长公共子序列;

import org.junit.Test;

import java.util.Arrays;

public class TestSolution {
    String X = "ABCBDAB";
    String Y = "BDCABA";

    @Test
    public void testSolution1() {
        Solution1 sol = new Solution1();
        System.out.println(sol.getMaxCommonSubsequence(X, Y));
//        System.out.println(Arrays.deepToString(sol.dp));
//        System.out.println(Arrays.deepToString(sol.tag));
        System.out.println(sol.getTrace());
    }

    @Test
    public void testSolution2() {
        Solution2 sol = new Solution2();
        System.out.println(sol.getMaxCommonSubsequence(X, Y));
//        System.out.println(Arrays.deepToString(sol.dp));
//        System.out.println(Arrays.deepToString(sol.tag));
        System.out.println(sol.getTrace());
    }
}
