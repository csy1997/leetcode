package 数数组和字符串.L151翻转字符串里的单词;

public class Solution1 {
    public String reverseWords(String s) {
        s = s.trim();
        String[] words = s.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]);
            if (i != 0) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution1 sol = new Solution1();
        System.out.println(sol.reverseWords("   a good   example   "));
    }
}
