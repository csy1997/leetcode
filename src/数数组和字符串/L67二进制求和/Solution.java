package 数数组和字符串.L67二进制求和;

public class Solution {
    public String addBinary(String a, String b) {
        int la = a.length();
        int lb = b.length();
        if (lb > la) {
            return addBinary(b, a);
        }
        int l = la - lb;
        char[] res = new char[la];
        boolean carry = true;
        int i;
        for (i = la - 1; i >= l; i--) {
            if (carry) {
                if (a.charAt(i) == b.charAt(i - l)) {
                    if (a.charAt(i) == '1') {
                        carry = false;
                    }
                    res[i] = '0';
                } else {
                    res[i] = '1';
                }
            } else {
                if (a.charAt(i) == b.charAt(i - l)) {
                    if (a.charAt(i) == '0') {
                        carry = true;
                    }
                    res[i] = '1';
                } else {
                    res[i] = '0';
                }
            }
        }
        for (; i >= 0; i--) {
            if (carry) {
                res[i] = a.charAt(i);
            } else {
                if (a.charAt(i) == '0') {
                    carry = true;
                    res[i] = '1';
                } else {
                    res[i] = '0';
                }
            }
        }
        if (!carry) {
            return "1" + String.valueOf(res);
        }
        return String.valueOf(res);
    }
}
