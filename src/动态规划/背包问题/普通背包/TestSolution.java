package 动态规划.背包问题.普通背包;

import org.junit.Test;
import 回溯算法与搜索.背包问题.Solution;

public class TestSolution {
    int[] w = {2,3,4,7};
    int[] v = {1,3,5,9};
    int W = 100;

    @Test
    public void testSolution1() {
        Solution1 sol = new Solution1();
        System.out.println(sol.getMaxValueInBag(w, v, W));
//        System.out.println(Arrays.deepToString(sol.dp));
//        System.out.println(Arrays.deepToString(sol.trace));
//        System.out.println(sol.getTrace());
    }

    @Test
    public void testSolution2() {
        Solution2 sol = new Solution2();
        System.out.println(sol.getMaxValueInBag(w, v, W));
//        System.out.println(Arrays.deepToString(sol.dp));
//        System.out.println(Arrays.deepToString(sol.trace));
//        System.out.println(sol.getTrace());
    }

    @Test
    public void testSolution3() {//回溯方法
        Solution sol = new Solution();
        System.out.println(sol.getMaxValueInBag(w, v, W));
    }
}
