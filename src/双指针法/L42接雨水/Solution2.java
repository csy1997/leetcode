package 双指针法.L42接雨水;

import java.util.Stack;

public class Solution2 {
    public int trap(int[] height) {
        int ans = 0, current = 0;
        Stack<Integer> st = new Stack<>();//单调递减栈
        while (current < height.length) {
            while (!st.empty() && height[current] > height[st.peek()]) {//比栈顶元素大就以current为右界依次计算对应层体积，并弹出
                int top = st.pop();
                if (st.empty())//如果弹出后栈空了，说明没有左界了
                    break;
                int distance = current - st.peek() - 1;
                int bounded_height = (Math.min(height[current], height[st.peek()])) - height[top];//循环最后一个peek可能大于current
                ans += distance * bounded_height;//以top为底，去掉top之后的peek与current为左右界部分的体积
            }
            st.push(current++);
        }
        return ans;
    }

    public int trap2(int[] height) {
        int ans = 0, current = 0;
        Stack<Integer> st = new Stack<>();//单调递减栈
        while (current < height.length) {
            while (!st.empty() && height[current] > height[st.peek()]) {
                int top = st.pop();
                if(st.empty()) {//说明直到最后栈中没有比current大的
                    ans -= (current - top - 1) * (height[current] - height[top]);//去除掉多余的层
                    break;
                }
                int distance = top - st.peek();
                int rightBounded_height = height[current] - height[top];//假设右界current比左界小
                ans += distance * rightBounded_height;//按列增加体积
            }
            st.push(current++);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] height = {4,2,0,3,2,5};
        Solution2 sol = new Solution2();
        System.out.println(sol.trap2(height));
    }
}
