public class T29两数相除 {
    public int divide(int dividend, int divisor) {
        if(dividend == Integer.MIN_VALUE && divisor == -1){
            return Integer.MAX_VALUE;
        }
        int sig = 1;
        if((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)){
            sig = -1;
        }
        dividend = minusAbs(dividend);
        divisor = minusAbs(divisor);
        int res = 0;
        long sum = divisor;
        while(dividend <= divisor){
            int i;
            for(i = 1; sum*2 >= dividend; i*=2){
                sum *= 2;
            }
            res += i;
            dividend -= sum;
            sum = divisor;
        }
        return sig*res;
    }

    public int minusAbs(int x){
        if(x < 0){
            return x;
        }
        return -x;
    }

    public static void main(String[] args) {
        T29两数相除 sol = new T29两数相除();
        int dividend = -1;
        int divisor = 1;
        System.out.println(sol.divide(dividend, divisor));
    }
}
