package 数数组和字符串.L50Powxn;

public class Solution {
    public double myPow(double x, int n) {
        if (x == 1) {
            return 1.0;
        } else if (n == Integer.MIN_VALUE) {//转正数溢出一个，处理一下
            return myPow(x, n + 1) / x;
        } else if (n < 0) {
            return 1 / myPow(x, -n);
        }
        return pow(x, n);
    }

    public double pow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        if (n % 2 == 0) {
            return twice(pow(x, n / 2));
        }
        return twice(pow(x, n / 2)) * x;
    }

    public double twice(double x) {
        return x * x;
    }
}
