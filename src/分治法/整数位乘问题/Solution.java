package 分治法.整数位乘问题;

/**
 * 普通乘法进位运算，o(n^2)
 */
public class Solution {
    // 字符串二进制数乘法
    public static String multiplyBinary(String b1, String b2) {
        int len1 = b1.length();
        int len2 = b2.length();
        int L = len1+len2-2;
        StringBuilder sb = new StringBuilder();
        long sum = 0;
        // l为当前i和j位数之和，例如第0位和第0位相乘等于0位
        for (int l = 0; l <= L; l++) {
            int i = Math.min(len1-1, L-l);
            int j = L-l-i;
            for (; i >= 0 && j <= len2-1; i--,j++) {
                if(b1.charAt(i) == '1' && b2.charAt(j) == '1') {
                    sum++;
                }
            }
            sb.append(sum%2);
            sum /= 2;
        }
        while(sum != 0) {
            sb.append(sum%2 == 0 ? 0 : 1);
            sum /= 2;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String a ="1";
        String b = "0";
        long res1 = Long.valueOf(a, 2) * Long.valueOf(b, 2);
        long res2 = Long.valueOf(multiplyBinary(a, b), 2);
        System.out.println(res1 == res2);
    }
}
