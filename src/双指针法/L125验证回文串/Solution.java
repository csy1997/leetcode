package 双指针法.L125验证回文串;

public class Solution {
    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (!isValid(s.charAt(i))) {
                i++;
            } else if (!isValid(s.charAt(j))) {
                j--;
            } else {
                if (s.charAt(i) != s.charAt(j)) {
                    if (s.charAt(i) < 58 || s.charAt(j) < 58) {
                        return false;
                    } else if (s.charAt(i) - s.charAt(j) != 32 && s.charAt(j) - s.charAt(i) != 32) {
                        return false;
                    }
                }
                i++;
                j--;
            }
        }
        return true;
    }

    public boolean isValid(char a) {
        if (a > 47 && a < 58) {
            return true;
        }
        if (a > 64 && a < 91) {
            return true;
        }
        if (a > 96 && a < 123) {
            return true;
        }
        return false;
    }
}
