package 栈和队列.L20有效的括号;

import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            int a = s.charAt(i);
            if(a == '(' || a == '[' || a == '{') {
                st.push(a);
            }else if(a == ')' && (st.empty() || st.pop() != '(')) {
                return false;
            }else if(a == ']' && (st.empty() || st.pop() != '[')) {
                return false;
            }else if(a == '}' && (st.empty() || st.pop() != '{')) {
                return false;
            }
        }
        return st.empty();
    }
}
