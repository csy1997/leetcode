package 分治法.mi乘问题.fibonacci数列;

/**
 * 普通迭代
 */
public class Solution {
    public int getFibonacciN(int n) {
        if(n == 1) {
            return 0;
        }
        if(n == 2) {
            return 1;
        }
        int a = 0, b = 1;
        for (int i = 2; i < n; i++) {
            int temp = b;
            b += a;
            a = temp;
        }
        return b;
    }
}
