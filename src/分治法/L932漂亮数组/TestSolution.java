package 分治法.L932漂亮数组;

import org.junit.Test;

public class TestSolution {
    Solution sol = new Solution();
    int N = 1000;
    int[] res;

    @Test
    public void testSolution1() {
        res = sol.beautifulArray1(N);
    }

    @Test
    public void testSolution2() {
        res = sol.beautifulArray2(N);
    }

    @Test
    public void testSolution3() {
        res = sol.beautifulArray3(N);
    }

//    @After
//    public void show() {
//        for(int x : res) {
//            System.out.print(x + " ");
//        }
//        System.out.println();
//    }
}
