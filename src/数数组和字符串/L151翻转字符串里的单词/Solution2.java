package 数数组和字符串.L151翻转字符串里的单词;

import java.util.Stack;

public class Solution2 {
    public String reverseWords(String s) {
        int l = s.length();
        Stack<String> st = new Stack<>();
        for (int i = 0; i < l; ) {
            if (s.charAt(i) != ' ') {
                int j = i + 1;
                for (; j < l; j++) {
                    if (s.charAt(j) == ' ') {
                        break;
                    }
                }
                st.push(s.substring(i, j));
                i = j + 1;
            } else {
                i++;
            }
        }
        StringBuilder sb = new StringBuilder();
        if (!st.isEmpty()) {
            sb.append(st.pop());
        }
        while (!st.isEmpty()) {
            sb.append(" ");
            sb.append(st.pop());
        }
        return sb.toString();
    }
}
