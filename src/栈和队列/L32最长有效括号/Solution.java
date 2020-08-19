package 栈和队列.L32最长有效括号;

import java.util.Stack;

public class Solution {
    public int longestValidParentheses(String s) {
        int max = 0;
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        for (int i = 0; i < s.length(); i++) {
            int a = s.charAt(i);
            if (a == '(') {
                st.push(i);
            } else {
                st.pop();
                if (st.empty()) {
                    st.push(i);
                } else {
                    int temp = i - st.peek();
                    max = Math.max(temp, max);
                }
            }
        }
        return max;
    }
}
