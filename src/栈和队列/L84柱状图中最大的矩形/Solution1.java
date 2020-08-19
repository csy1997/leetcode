package 栈和队列.L84柱状图中最大的矩形;

import java.util.Stack;

/**
 * 单调栈
 */
public class Solution1 {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxArea = 0;
        for (int i = 0; i < heights.length; ++i) {
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {//保证栈元素对应的height单调递增
                //遇到高度小于栈顶的（此时循环第一次栈顶元素一定是i-1），计算夹在i和上一个peek之间的宽度（不包括i和上个peek），
                //且根据单调性该段的最低高度为当前peek对应的height
                maxArea = Math.max(maxArea, heights[stack.pop()] * (i - stack.peek() - 1));
            }
            stack.push(i);
        }
        while (stack.peek() != -1) {//对完成的单调栈再做一次分段计算最大值，相当于i == heights.length，此时对应的高度为0
            maxArea = Math.max(maxArea, heights[stack.pop()] * (heights.length - stack.peek() - 1));
        }
        return maxArea;
    }
}
