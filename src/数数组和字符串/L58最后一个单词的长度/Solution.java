package 数数组和字符串.L58最后一个单词的长度;

public class Solution {
    public int lengthOfLastWord(String s) {
        int i = s.length()-1;
        int j;
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }
        j = i;
        while (j >= 0 && s.charAt(j) != ' ') {
            j--;
        }
        return i-j;
    }
}
