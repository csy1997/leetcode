package 数数组和字符串.L29两数相除;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend == Integer.MIN_VALUE && divisor == -1){
            return Integer.MAX_VALUE;
        }
        int sig = 1;
        if((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)){
            sig = -1;
        }
        //都转成负数因为int负比正多一，正转负不会溢出
        dividend = minusAbs(dividend);
        divisor = minusAbs(divisor);
        int res = 0;
        List<Long> memo = new ArrayList<>();//牺牲空间避免重复计算
        HashMap<Long, Integer> map = new HashMap<>();
        long sum = divisor;
        for (int i = 1; sum >= dividend; i*=2){//sum和dividend都为负，符号为>=
            memo.add(sum);
            map.put(sum, i);
            sum *= 2;
        }
        for (int i = memo.size()-1; i >= 0; i--) {//相当于幂乘算法
            long temp = memo.get(i);
            if(temp >= dividend) {
                res += map.get(temp);
                dividend -= temp;
            }
        }
        return sig*res;
    }

    public int minusAbs(int x){
        if(x < 0){
            return x;
        }
        return -x;
    }
}
