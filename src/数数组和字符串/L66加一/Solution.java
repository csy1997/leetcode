package 数数组和字符串.L66加一;

public class Solution {
    public int[] plusOne(int[] digits) {
        int l = digits.length;
        for (int i = l - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i]++;
                break;
            }
        }
        if (digits[0] != 0) {
            return digits;
        }
        int[] res = new int[l + 1];
        res[0] = 1;
        return res;
    }
}
