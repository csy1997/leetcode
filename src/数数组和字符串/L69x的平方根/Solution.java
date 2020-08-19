package 数数组和字符串.L69x的平方根;

/**
 * 牛顿迭代法
 */
public class Solution {
    public int mySqrt(int a) {
        long x = a;
        while (x * x > a) {
            x = (x + a / x) / 2;
        }
        return (int) x;
    }
}
