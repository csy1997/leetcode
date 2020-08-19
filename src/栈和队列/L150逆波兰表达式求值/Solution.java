package 栈和队列.L150逆波兰表达式求值;

import java.util.Stack;

public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for (String s : tokens) {
            if (!isOperator(s)) {
                st.push(Integer.parseInt(s));
            } else {
                int y = st.pop();
                int x = st.pop();
                switch (s) {
                    case "+":
                        st.push(x + y);
                        break;
                    case "-":
                        st.push(x - y);
                        break;
                    case "*":
                        st.push(x * y);
                        break;
                    case "/":
                        st.push(x / y);
                        break;
                }
            }
        }
        return st.pop();
    }

    public boolean isOperator(String s) {
        if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
            return true;
        }
        return false;
    }
}
