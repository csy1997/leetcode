package 贪心法.L135分发糖果;

public class Solution1 {
    public int candy(int[] ratings) {
        int sum = 1;
        int cur = 1;//当前取值
        int max = 1;//峰值
        int len = 0;//连续下降的数个数
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                cur++;
                sum += cur;
                max = cur;
                len = 0;
            } else if (ratings[i] == ratings[i - 1]) {
                len = 0;
                cur = 1;
                max = 1;
                sum++;
            } else {
                cur = 1;
                len++;
                sum += len;
                if (len >= max) {
                    sum++;
                }
            }
        }
        return sum;
    }
}
