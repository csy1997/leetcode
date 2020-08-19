package 栈和队列.L155最小栈;

import java.util.Stack;

public class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minHelper;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        minHelper = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        int min = minHelper.isEmpty() || x < minHelper.peek() ? x : minHelper.peek();
        minHelper.push(min);
    }

    public void pop() {
        stack.pop();
        minHelper.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minHelper.peek();
    }
}
