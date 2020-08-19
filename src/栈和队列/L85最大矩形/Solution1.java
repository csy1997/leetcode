package 栈和队列.L85最大矩形;

import java.util.Stack;

public class Solution1 {
    public int maximalRectangle(char[][] matrix) {
        int l = matrix.length;
        if (l == 0) {
            return 0;
        }
        int w = matrix[0].length;
        int[][] tab = new int[l][w];
        //将每行看成一个新的柱状图，每列的柱高为当前行列元素向上连续为1的个数，然后再对每行（柱状图）计算最大值
        for (int j = 0; j < w; j++) {
            if (matrix[0][j] == '1') {
                tab[0][j] = 1;
            }
        }
        for (int j = 0; j < w; j++) {
            for (int i = 1; i < l; i++) {
                if (matrix[i][j] == '1') {//当前元素为柱底，为1则加上上一层的更新柱高，为0则无法构造矩形，柱高设为0
                    tab[i][j] = tab[i - 1][j] + 1;
                }
            }
        }
        int max = 0;
        for (int[] t : tab) {
            max = Math.max(max, largestRectangleArea(t));
        }
        return max;
    }
    //上一题柱状图最大矩形单调栈解法
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
