package 栈和队列.L84柱状图中最大的矩形;

/**
 * 暴力法
 */
public class Solution2 {
    public int largestRectangleArea(int[] heights) {
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            int width = 1;
            //往两边依次找最大宽边界
            for (int j = i + 1; j < heights.length && heights[i] <= heights[j]; j++) {
                width++;
            }
            for (int j = i - 1; j >= 0 && heights[i] <= heights[j]; j--) {
                width++;
            }
            max = Math.max(max, width * heights[i]);
        }
        return max;
    }
}
