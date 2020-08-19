package 分治法.mi乘问题.fibonacci数列;

import org.junit.Test;

public class TestSolution {
    @Test
    public void testSolution() {
        Solution sol = new Solution();
        System.out.println(sol.getFibonacciN(20));
    }

    @Test
    public void testSolutionDC() {
        SolutionDC sol = new SolutionDC();
        System.out.println(sol.getFibonacciN(20));
    }
}
