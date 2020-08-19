package 回溯算法与搜索.N皇后问题;

import org.junit.Test;
import 回溯算法与搜索.N皇后问题.迭代法.Solution;
import 回溯算法与搜索.N皇后问题.递归法.Solution1;
import 回溯算法与搜索.N皇后问题.递归法.Solution2;

public class TestSolution {
    int n = 12;

    @Test
    public void testSolution1() {
        Solution1 sol = new Solution1();
        System.out.println(sol.solveNQueens(n));
//        System.out.println(sol.res);
    }

    @Test
    public void testSolution2() {
        Solution2 sol = new Solution2();
        System.out.println(sol.solveNQueens(n));
//        System.out.println(sol.res);
    }

    @Test
    public void testSolution3() {
        Solution sol = new Solution();
        System.out.println(sol.solveNQueens(n));
//        System.out.println(sol.res);
    }
}
