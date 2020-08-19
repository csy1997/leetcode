package 动态规划.矩阵链相乘;

import org.junit.Test;
import 动态规划.矩阵链相乘.迭代法_自底向上.Solution1;
import 动态规划.矩阵链相乘.递归法_自顶向下.Solution2;

public class TestSolution {
    int[] P = {30,15,5,85,10,20,15,13,35,15,67,32,15};

    @Test
    public void testSolution1() {
        Solution1 sol = new Solution1();
        System.out.println(sol.minMatrixMultis(P));
        System.out.println(sol.getTrace());
    }

    @Test
    public void testSolution2() {
        Solution2 sol = new Solution2();
        System.out.println(sol.minMatrixMultis(P));
        System.out.println(sol.getTrace());
    }
}
