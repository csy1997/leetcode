package 数数组和字符串.L7整数反转;

public class Solution {
    public int reverse(int x) {
        if(x == -2147483648){
            return 0;
        }
        if(x < 0){
            return -reverse(-x);
        }
        long sum = 0;
        while(x > 0){
            sum = sum*10 + x%10;
            x = x/10;
        }
        if(sum > Integer.MAX_VALUE){
            return 0;
        }
        return (int)sum;
    }
}
