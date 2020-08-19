package 分治法.mi乘问题.mi乘算法;


/**
 * x的n次方快速幂
 */
public class Solution {
    public static long pow(long x, int n) {
        if(n == 0) {
            return 1;
        }
        int remain = n % 2;
        n /= 2;
        long temp = pow(x, n);
        return temp * temp * (remain == 0 ? 1 : x);
    }


    public static void main(String[] args) {
        System.out.println(pow(3, 7));
    }
}
