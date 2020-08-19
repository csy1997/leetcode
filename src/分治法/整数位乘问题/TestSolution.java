package 分治法.整数位乘问题;

import org.junit.Test;

public class TestSolution {
    private String x = "1101001100111000";
    private String y = "1001000100110101";

    @Test
    public void testSolution() {
        System.out.println(Solution.multiplyBinary(x, y));
    }

    @Test
    public void testSolutionDC1() {
        System.out.println(SolutionDC.multiplyBinaryString(x, y));
    }

    @Test
    public void testSolutionDC2() {
        System.out.println(SolutionDC.multiplyBinary2(x, y));
    }

    @Test
    public void testSolutionDC3() {
        System.out.println(SolutionDC.multiplyBinary1(x, y));
    }
}
